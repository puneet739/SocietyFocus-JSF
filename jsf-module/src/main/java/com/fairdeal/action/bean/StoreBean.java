package com.fairdeal.action.bean;

import java.io.Serializable;

import com.fairdeal.utility.LoggerUtil;
import com.property.player.model.mongo.Store;

public class StoreBean extends Store implements Serializable{

	public String getCordinates(){
		String result="0,0";
		try{
			result = getLocation().getPoint().getX()+","+getLocation().getPoint().getY();
		}catch(NullPointerException ne){
			LoggerUtil.error("No Location co-ordinates exist for Store: "+this);
		}
		return result;
	}
	
}