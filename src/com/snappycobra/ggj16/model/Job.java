package com.snappycobra.ggj16.model;

import com.snappycobra.motor.graphics.Frame;
import com.snappycobra.motor.graphics.Sprite;

public abstract class Job {
	protected Sprite sprite;
	protected Unit owner;
	
	public abstract void update();
	
	public Sprite getSprite() {
		return sprite;
	}
}
