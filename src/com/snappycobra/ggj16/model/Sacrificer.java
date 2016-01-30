package com.snappycobra.ggj16.model;

public class Sacrificer extends Job {
	private Shrine shrine;
	private int state;
	private Unit owner;
	private ResourceAmount resourceAmount;
	
	public Sacrificer(Unit owner, Shrine shrine, ResourceAmount res) {
		this.owner = owner;
		this.shrine = shrine;
		this.state = 1;
		this.resourceAmount = res;
	}
	
	@Override
	public void update() {
		switch(state){
		case 1:
			if(owner.moveTo(shrine.getBody())) {
				Offer();
				state = 2;
			}
			
			break;
		case 2:
			if(owner.moveTo(owner.getBase().getBody())) {
				owner.removeJob();
			}
		}
	}
	
	public void Offer() {
		
	}

}
