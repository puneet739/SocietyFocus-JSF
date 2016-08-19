package com.fairdeal.bean.list;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.bean.bean.Banner;
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
@Scope(value = "session")
public class StoreList {

	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	private final int PAGE_SIZE=10;
	public List<StoreBean> stores =new LinkedList<>();
	public List<Banner> banners  =new LinkedList<>();
	private long pageNo=1;
	private long totalCount;

	public void doNothing() {
		LoggerUtil.debug("Working here to get the filters");
		init();
	}

	public void init() {
//		if (!FacesContext.getCurrentInstance().isPostback()) {
			stores =new LinkedList<>();
			banners  =new LinkedList<>();
			JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/store?maxcount="+PAGE_SIZE+"&pageNo="+pageNo);
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
}
