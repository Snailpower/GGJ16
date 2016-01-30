package com.snappycobra.ggj16.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Unit> unitList = new ArrayList<Unit>();
	private List<Building> buildingList = new ArrayList<Building>();
	private List<ResourceAmount> resourceList = new ArrayList<ResourceAmount>();
	
	public Player() {
		resourceList.add(new ResourceAmount(Oil.getResName()));
	}
	
	public void addResource(String resName, int amount) {
		for(ResourceAmount res : resourceList) {
			if (res.getResName().equals(resName)) {
				res.addAmount(amount);
			}
		}
	}
}
