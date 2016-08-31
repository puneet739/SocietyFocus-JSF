package com.fairdeal.action.bean;

import java.io.Serializable;

import com.property.player.model.mongo.Store;

public class StoreBean extends Store implements Serializable{

	public String getCordinates(){
		String result = getLocation().getPoint().getX()+","+getLocation().getPoint().getY();
		return result;
	}
	
}