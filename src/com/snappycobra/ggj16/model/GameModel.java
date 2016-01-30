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

	public GameModel(int amountPlayers) {
		MapFactory factory = new MapFactory();
		Map map = factory.loadMap("data/maps/test.tmx");
		this.setMap(map);
		
		worldMap = new WorldMap(map.getGameObjectsWithProp("Resource"));
		addPlayers(amountPlayers, map, worldMap);
	}
	
	private void addPlayers(int amountPlayers, Map map, WorldMap worldMap) {
		for (int i=0; i<amountPlayers; i++) {
			Player player = new Player(i,map);
			player.addCursor(new Cursor(map.getWidth(),player, worldMap));
			playerList.add(player);
		}
	}
	
	@Override
	public void tick() {
		for(Player player : playerList) {
			player.update();
		}
	}	
	
}
