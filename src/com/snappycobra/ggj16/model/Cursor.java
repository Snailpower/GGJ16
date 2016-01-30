package com.snappycobra.ggj16.model;

public class Cursor {
	private double position;
	private double movementSpeed=1;
	private double mapWidth;
	
	public Cursor(double mapWidth) {
		this.mapWidth = mapWidth;
		position = mapWidth/2;
	}
	
	public void moveRigth() {
		moveCursor(movementSpeed);
	}
	
	public void moveLeft() {
		moveCursor(-movementSpeed);
	}
	
	public void moveCursor(double movementSpeed2) {
		position = (position+movementSpeed)%mapWidth;
	}
}
