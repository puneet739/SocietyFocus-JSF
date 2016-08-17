package com.fairdeal.bean.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.action.model.CusineEnum;
import com.fairdeal.action.model.Image;
import com.fairdeal.bean.bean.Banner;
import com.fairdeal.utility.LoggerUtil;

@Component(value = "storelist")
@Scope(value = "session")
public class StoreList {

	public List<StoreBean> stores;
	public List<Banner> banners;

	public void init() {
		// TODO :: add method to get data.
		stores = new LinkedList<>();
		banners= new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			StoreBean store = new StoreBean();
			store.setName("Gulati");
			store.setBackgroundImage(new Image("http://image6.buzzintown.com/files/venue/upload_22000/upload_original/523257-gulati-restaurant.jpg"));
			store.setAddress("House no 124, Sec 37, Faridabad");
			List<CusineEnum> cusines = new LinkedList<>();
			cusines.add(CusineEnum.CONTINENTAL);
			cusines.add(CusineEnum.MUGHLAI);
			store.setDetail2("Open from 12:00 am to 12:00 pm");
			store.setDetail3("Featured in best restaurants in delhi");
			store.setCusines(cusines);
			store.setCostForTwo(200);
			store.setRating(2.4f);
			store.setPromotion("Discount of 20% on food bill");
			List<String> phoneNos = new ArrayList<>();
			phoneNos.add("9711616135");
			store.setPhoneNo(phoneNos);
			stores.add(store);
		}
		
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
