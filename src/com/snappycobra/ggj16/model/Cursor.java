package com.snappycobra.ggj16.model;

import com.snappycobra.motor.maps.GameObject;

public class Cursor {
	private double position;
	private double movementSpeed=1;
	private double mapWidth;
	private Player owner;
	private WorldMap worldMap;
	
	public Cursor(double mapWidth, Player player, WorldMap worldmap) {
		this.owner = player;
		this.worldMap = worldMap;
		this.mapWidth = mapWidth;
		position = mapWidth/2;
	}
	
	public GameObject select() {
		return null;//for(ResourcePoint rP : worldMap.)
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
