package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public class ResourcePoint extends GameObject {
	private int yield;
	
	public ResourcePoint(String name, Body body) {
		super(name, body);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		if (this.getPropertySet().hasProperty("amount")){
			yield = Integer.parseInt(this.getPropertySet().getProperty("amount"));
		} else {
			yield = 5000000;
		}
	}
}
