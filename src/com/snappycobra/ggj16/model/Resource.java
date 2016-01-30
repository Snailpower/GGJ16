package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public abstract class Resource{
	
	public static Resource getResource(String resName) {
		switch (resName) {
		case "Oil":
			return new Oil();
		}
		return null;
	}
	
	public static String getResName(){
		return "MAG NIET";
	}
}
