package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public class Cursor {
	private double position;
	private static final double SPEED=0.5;
	private double mapWidth;
	private Player owner;
	private WorldMap worldMap;
	private Unit selectedUnit;
	
	public Cursor(double mapWidth, Player player, WorldMap worldmap) {
		this.owner = player;
		this.worldMap = worldMap;
		this.mapWidth = mapWidth;
		position = mapWidth/2;
	}
	
	public void click() {
		GameObject clicked = select();
		if (clicked != null) {
			doClicked(clicked);
		}
	}
	
	public void doClicked(GameObject go) {
		System.out.println("You are doing something wrong");
	}
	
	public void doClicked(Unit unit) {
		selectedUnit = unit;
	}
	
	public void doClicked(ResourcePoint rp) {
		if (selectedUnit != null) {
			selectedUnit.switchJob(new Gatherer(selectedUnit, rp));
		}
	}
	
	public void moveRight() {
		moveCursor(-SPEED);
	}

	public GameObject select() {
		for(ResourcePoint rp : worldMap.getResourcePointList()) {
			if (inBoundaryBox(rp.getBody())) {
				System.out.println("Resource Selected");
				return rp;
			}
		}
		for(Unit unit : owner.getUnitList()) {
			if (inBoundaryBox(unit.getBody())) {
				System.out.println("UNIT Selected");
				return unit;
			}
		}
		return null;
	}
	
	private boolean inBoundaryBox(Body body) {
		return position > body.createAABB().getMinX() && position < body.createAABB().getMinX();
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
