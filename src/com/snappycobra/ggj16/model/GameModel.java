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
		addPlayers(amountPlayers, map);
	}
	
	private void addPlayers(int amountPlayers, Map map) {
		System.out.println("am:"+amountPlayers);
		for (int i=0; i<amountPlayers; i++) {
			playerList.add(new Player(i,map, new Cursor(map.getWidth())));
		}
	}
	
	@Override
	public void tick() {
		for(Player player : playerList) {
			player.update();
		}
	}

	public List<Player> getPlayerList() {
		return playerList;
	}	

}
