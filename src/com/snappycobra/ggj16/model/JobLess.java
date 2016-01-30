package com.snappycobra.ggj16.model;

import com.snappycobra.motor.graphics.Frame;
import com.snappycobra.motor.graphics.Sprite;

public class JobLess extends Job {
	
	public JobLess() {
		sprite = new Sprite(new Frame("data/images/Workers/Worker_Green.png", 10));
	}
	@Override
	public void update() {
	}

}
