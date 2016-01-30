package com.snappycobra.ggj16.model;

import java.util.ArrayList;
import java.util.List;

import com.snappycobra.motor.maps.GameObject;
import com.snappycobra.motor.maps.Map;
import com.snappycobra.motor.maps.MapFactory;
import com.snappycobra.motor.model.Game;

public class GameModel extends Game {
	private WorldMap worldMap;
	private List<Player> playerList = new ArrayList<Player>();

	public GameModel() {
		MapFactory factory = new MapFactory();
		Map map = factory.loadMap("data/maps/map0.tmx");
		this.setMap(map);
		
		worldMap = new WorldMap(map.getGameObjectsWithProp("resource"));
		addPlayers(map);
	}
	
	private void addPlayers(Map map) {
		for (GameObject player : map.getGameObjectsWithProp("player")) {
			playerList.add((Player) player);
		}
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}	

}
