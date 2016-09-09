package com.property.player.model.mongo;

import java.io.Serializable;

//db.store.ensureIndex({"location.point":"2dsphere"});
public class Location implements Serializable {

	private Point point;

	public Location() {
	}

	public Location(double latitude, double longitude) {
		point = new Point(latitude, longitude);
	}

	public Location(String latitude, String longitude) {
		point = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude));
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Location [point=" + point + "]";
	}

}


