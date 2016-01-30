package com.snappycobra.ggj16.model;

import java.util.ArrayList;
import java.util.List;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public class Player extends GameObject{
	public Player(String name, Body body) {
		super(name, body);
		// TODO Auto-generated constructor stub
	}

	private List<Unit> unitList = new ArrayList<Unit>();
	private List<Building> buildingList = new ArrayList<Building>();
	private List<ResourceAmount> resourceList = new ArrayList<ResourceAmount>();
	
	
	public void addResource(String resName, int amount) {
		for(ResourceAmount res : resourceList) {
			if (res.getResName().equals(resName)) {
				res.addAmount(amount);
			}
		}
	}

	@Override
	public void init() {
		resourceList.add(new ResourceAmount(Oil.getResName()));
	}
}
