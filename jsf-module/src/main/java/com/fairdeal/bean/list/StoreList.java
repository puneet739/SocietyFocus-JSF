package com.fairdeal.bean.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.bean.bean.Banner;
import com.fairdeal.portal.bean.filter.DisplayOption;
import com.fairdeal.portal.bean.filter.Filter;
import com.fairdeal.utility.Config;
import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.LoggerUtil;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@Component(value = "storelist")
@Scope(value = "request")
public class StoreList {

	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	private final int PAGE_SIZE=10;
	public List<StoreBean> stores =new LinkedList<>();
	public List<Banner> banners  =new LinkedList<>();
	private String sortby;
	private long pageNo=1;
	private long totalCount;
	private List<Filter> filters;
	private String feature;
	private String cordinates;
	
	public void doNothing() {
		LoggerUtil.debug("Working here to get the Filter");
		init();
	}
	
	public void init() {
		initalizefilterCategories();
//		if (!FacesContext.getCurrentInstance().isPostback()) {
			stores =new LinkedList<>();
			banners  =new LinkedList<>();
			Map<String, String> queryParams = getQueryMap();
			String queryString = createQueryString(queryParams);
			JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/store"+queryString);
			JsonArray objects  = jsonResponse.getAsJsonArray("stores");
			
			for(int i = 0; i < objects.size(); i++){
					JsonElement jsnObj = objects.get(i);               
					StoreBean obj = gson.fromJson(jsnObj, StoreBean.class);      
					stores.add(obj);
		    }
			
			JsonPrimitive totalCount  = jsonResponse.getAsJsonPrimitive("totalCount");
			if (totalCount!=null){
				this.totalCount=NumberUtils.toLong(totalCount.toString());
			}

			String[] list = Config.getStringArray("zircon.banner.list");
			for (String obj : list){
				String prefix = "zircon.banner."+obj+".";
				Banner banner = new Banner();
				banner.setImage_url(Config.getString(prefix+"image_url"));
				banner.setTitle(Config.getString(prefix+"title"));
				banner.setDescription(Config.getString(prefix+"description"));
				banners.add(banner);
			}
			LoggerUtil.debug("Doing initalization of restaurants");
//	    }
	}

	private void initalizefilterCategories() {
		filters= new ArrayList<>();
		Filter filter = new Filter("Sort by");
		List<DisplayOption> DisplayOption = new ArrayList<>();
		DisplayOption option1= new DisplayOption("Popularity","High to Low","?sortby=views");
		DisplayOption option2= new DisplayOption("Rating","High to Low","?sortby=rating");
		DisplayOption option3= new DisplayOption("Cost","High to Low","?sortby=costForTwo&direction=descending");
		DisplayOption option4= new DisplayOption("Cost","Low to High","?sortby=costForTwo&direction=ascending");
		DisplayOption option5= new DisplayOption("Recently added","Recently added","?sortby=createdDate");
		DisplayOption.add(option1);
		DisplayOption.add(option2);
		DisplayOption.add(option3);
		DisplayOption.add(option4);
		DisplayOption.add(option5);
		filter.setDisplayOptions(DisplayOption);
		
		filters.add(filter);
	}

	public Map<String,String> getQueryMap(){
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("pageNo", ""+pageNo);
		queryParams.put("maxcount", ""+PAGE_SIZE);
		if (sortby!=null){
			queryParams.put("sort", sortby);
		}
		if (cordinates!=null){
			queryParams.put("cordinates", cordinates);
		}
		return queryParams;
	}
	private String createQueryString(Map<String, String> queryParams) {
		if (queryParams==null || queryParams.size()<1)return "";
		StringBuffer queryString = new StringBuffer("?");
		for (String key : queryParams.keySet()){
			String value = queryParams.get(key);
			if (value!=null){
				queryString.append(key+"="+value);
			}
			queryString.append("&");
		};
		return removelastand(queryString.toString());
	}

	public String queryParam(){
		String uri = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString();
		String newstring="";
		if (uri!=null){
			newstring = uri.replaceAll("page=\\d", "");
			System.out.println(newstring);
		}
		return removelastand(newstring);
	}
	
	public String queryOnlyOnce(String queryParam){
		String uri = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString();
		uri+=uri+queryParam;
		return queryParam;
	}
	
	private String removelastand(String queryString){
		if (queryString!=null){
			while (queryString.endsWith("&")){
				queryString=queryString.substring(0, queryString.length()-1);
			}
		}
		return queryString;
	}
	
	public List<StoreBean> getStores() {
		return stores;
	}

	public void setStores(List<StoreBean> stores) {
		this.stores = stores;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}


	public long getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public String getSortby() {
		return sortby;
	}

	public void setSortby(String sortby) {
		this.sortby = sortby;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getCordinates() {
		return cordinates;
	}

	public void setCordinates(String cordinates) {
		this.cordinates = cordinates;
	}

}
