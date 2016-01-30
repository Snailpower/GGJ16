package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public class ResourcePoint extends GameObject {
	private int yield;
	private Resource resource;
	
	public ResourcePoint(String name, Body body) {
		super(name, body);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		if (this.getPropertySet().hasProperty("type")){
			resource = Resource.getResource(this.getPropertySet().getProperty("type"));
		}
	}
	
	public void roudUp() {
		if (this.getPropertySet().hasProperty("worldMap")) {
			
			this.getPropertySet().getProperty("worldMap");
		}
	}
	
	public Resource getResource() {
		return resource;
	}
}
