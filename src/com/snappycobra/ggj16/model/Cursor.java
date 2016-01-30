package com.snappycobra.ggj16.model;

public class Cursor {
	private double position;
	private double movementSpeed=1;
	private double mapWidth;
	
	public Cursor(double mapWidth) {
		this.mapWidth = mapWidth;
		position = mapWidth/2;
	}
	
	public void moveRight() {
		moveCursor(movementSpeed);
	}
	
	public void moveLeft() {
		System.out.println("LEFT:"+this.position);
		moveCursor(-movementSpeed);
	}
	
	public void moveCursor(double movementSpeed2) {
		position = (position+movementSpeed)%mapWidth;
	}

	public double getPosition() {
		return position;
	}
}
