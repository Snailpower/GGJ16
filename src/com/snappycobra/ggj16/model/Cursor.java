package com.snappycobra.ggj16.model;

import com.snappycobra.motor.maps.GameObject;

public class Cursor {
	private double position;
	private boolean movingLeft, movingRight;
	private static final double SPEED=0.5;
	private double mapWidth;
	private Player owner;
	private WorldMap worldMap;
	
	public Cursor(double mapWidth, Player player, WorldMap worldmap) {
		this.owner = player;
		this.worldMap = worldMap;
		this.mapWidth = mapWidth;
		this.movingLeft=false;
		this.movingRight=false;
		position = mapWidth/2;
	}
	
	public void update() {
		if (movingRight) {
			this.moveRight();
		} else if (movingLeft) {
			this.moveLeft();
		}
	}
	
	public void moveRight() {
		moveCursor(-SPEED);
	}

	public GameObject select() {
		return null;//for(ResourcePoint rP : worldMap.)
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

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}
	
}
