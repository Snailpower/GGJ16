package com.snappycobra.ggj16.model;

import org.dyn4j.dynamics.Body;

import com.snappycobra.motor.maps.GameObject;

public class Unit extends GameObject{
	private Job job;
	private double walkSpeed;
	private Base base;
	private Player owner;
	
	public Unit(String name, Body body, Player owner) {
		super(name, body);
		this.owner = owner;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean moveTo(Body destination) {
		double ownX = this.getBody().getWorldCenter().x;
		double desX = destination.getWorldCenter().x;
		double direction = ownX-desX;
		if (Math.abs(direction) <= walkSpeed) {
			ownX = desX;
			return true;
		}else if (direction > 0) {
			ownX += walkSpeed;
		}else if (direction < 0) {
			ownX -= walkSpeed;
		}
		this.getBody().getWorldCenter().x = ownX;
		return false;
	}
	
	public void update(){
		if (job != null) {
			job.update();
		}
		System.out.println("I don't have a Job");
	}
	
	public void removeJob() {
		job = null;
	}
	
	public Base getBase() {
		return base;
	}
	
	public Player getOwner() {
		return owner;
	}

	public void switchJob(Gatherer gatherer) {
		// TODO Auto-generated method stub
		
	}
}
