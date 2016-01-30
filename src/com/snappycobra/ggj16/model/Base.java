package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.graphics.Frame;
import com.snappycobra.motor.graphics.Sprite;

public class Base extends Building {

	public Base(String name, Body body) {
		super(name, body);
		this.sprite = new Sprite(new Frame("data/images/TheBase.png", 10));
	}

}
