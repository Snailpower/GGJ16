package com.snappycobra.ggj16.model;

public class Cursor {
	private double position;
	private static final double SPEED=0.5;
	private double mapWidth;
	
	public Cursor(double mapWidth) {
		this.mapWidth = mapWidth;
		position = mapWidth/2;
	}
	
	public void moveRight() {
		moveCursor(-SPEED);
	}
	
	public void moveLeft() {
		moveCursor(SPEED);
	}
	
	public void moveCursor(double speed) {
		position = (position+speed)%mapWidth;
	}

	public double getPosition() {
		return position;
	}
}
