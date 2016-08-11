package com.fairdeal.bean.list;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fairdeal.action.bean.StoreBean;
import com.fairdeal.bean.bean.Banner;

@Component(value = "storelist")
@Scope(value = "session")
public class StoreList {

	public List<StoreBean> stores;
	public List<Banner> banners;

	public void init() {
		// TODO :: add method to get data.
		stores = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			StoreBean store = new StoreBean();
			store.setAddress("Address 124");
			stores.add(store);
		}
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
