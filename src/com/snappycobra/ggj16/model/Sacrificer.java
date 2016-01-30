package com.snappycobra.ggj16.model;

public class Sacrificer extends Job {
	private Shrine god;
	private int yield;
	private int state;
	private Unit owner;
	
	public Sacrificer(Unit owner, Resource res, Shrine god, int yield) {
		this.owner = owner;
		this.god = god;
		yield = 50;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
