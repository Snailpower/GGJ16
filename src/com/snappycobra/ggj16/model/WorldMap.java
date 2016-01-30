package com.snappycobra.ggj16.model;

import java.util.List;

import com.snappycobra.motor.maps.GameObject;


public class WorldMap {
	private List<ResourcePoint> resourcePointList;
	
	public WorldMap(List<GameObject> resources) {
		for (GameObject res : resources) {
			resourcePointList.add((ResourcePoint) res);
		}
	}
	
	public List<ResourcePoint> getResourcePointList() {
		return resourcePointList;
	}
}
