package com.fairdeal.bean.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.HelpdeskQuery;
import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.action.model.CusineEnum;
import com.fairdeal.action.model.Image;
import com.fairdeal.bean.bean.Banner;
import com.fairdeal.utility.Constants;
import com.fairdeal.utility.GsonHelper;
import com.fairdeal.utility.LoggerUtil;
import com.fairdeal.utility.Util;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component(value = "storelist")
@Scope(value = "session")
public class StoreList {

	private Gson gson = GsonHelper.getBaseGsonBuilder().create();
	
	public List<StoreBean> stores =new LinkedList<>();;
	public List<Banner> banners  =new LinkedList<>();;;

	public void init() {
		
		JsonObject jsonResponse = Util.httpGetRequest(Constants.SERVICE_URL + "/v1/store");
		JsonArray objects  = jsonResponse.getAsJsonArray("stores");
		
		for(int i = 0; i < objects.size(); i++){
				JsonElement jsnObj = objects.get(i);               
				StoreBean obj = gson.fromJson(jsnObj, StoreBean.class);      
				stores.add(obj);
	    }
		
		// TODO :: add method to get data.
		/*for (int i = 0; i < 10; i++) {
			StoreBean store = new StoreBean();
			store.setName("Gulati");
			store.setBackgroundImage(new Image("http://image6.buzzintown.com/files/venue/upload_22000/upload_original/523257-gulati-restaurant.jpg"));
			store.setAddress("House no 124, Sec 37, Faridabad");
			List<CusineEnum> cusines = new LinkedList<>();
			cusines.add(CusineEnum.CONTINENTAL);
			cusines.add(CusineEnum.MUGHLAI);
			store.setDetail2("12:00 am to 12:00 pm");
			store.setDetail3("Featured in best restaurants in delhi");
			store.setCusines(cusines);
			store.setCostForTwo(200);
			store.setRating(2.4f);
			store.setPromotion("Discount of 20% on food bill");
			List<String> phoneNos = new ArrayList<>();
			phoneNos.add("9711616135");
			store.setPhoneNo(phoneNos);
			stores.add(store);
		}*/
		
		for (int i=0; i<3; i++){
			Banner banner = new Banner();
			banner.setImage_url("http://localhost:8080/store-ui/resources/images/1010.jpg");
			banner.setTitle("Ttile:"+i);
			banner.setDescription("this is a test description with banner: "+i);
			banners.add(banner);
			//dm.delhi-do@licindia.com
		}
		
		LoggerUtil.debug("Doing initalization of restaurants");
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
}
