package com.snappycobra.ggj16.model;

import com.snappycobra.motor.maps.Map;
import com.snappycobra.motor.maps.MapFactory;
import com.snappycobra.motor.model.Game;

public class GodGame extends Game{

	public GodGame() {
		MapFactory factory = new MapFactory();
		Map map = factory.loadMap("data/maps/test2.tmx");
		this.setMap(map);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
