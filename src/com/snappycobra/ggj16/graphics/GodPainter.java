package com.snappycobra.ggj16.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.List;

import com.snappycobra.ggj16.model.Base;
import com.snappycobra.ggj16.model.Building;
import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.ggj16.model.GameModel;
import com.snappycobra.ggj16.model.Player;
import com.snappycobra.ggj16.model.Resource;
import com.snappycobra.ggj16.model.ResourcePoint;
import com.snappycobra.motor.graphics.AbstractPainter;
import com.snappycobra.motor.graphics.Frame;
import com.snappycobra.motor.graphics.ImageManager;
import com.snappycobra.motor.graphics.Sprite;
import com.snappycobra.motor.maps.GameObject;
import com.snappycobra.motor.maps.GameObjectGrabber;
import com.snappycobra.motor.maps.Map;
import com.snappycobra.motor.maps.MapContainer;
import com.snappycobra.motor.timing.Timer;

public class GodPainter extends AbstractPainter{
	private List<Player> players;
	private int mapWidth, mapHeight;
	private BufferedImage mapBuffer;
	private BufferedImage air, path, foreground, scrap1, scrap2;
	private int scroll1, scroll2;
	
	public GodPainter(GameModel gameModel) {
		super(gameModel);
		this.players = gameModel.getPlayerList();
		Map map = getMap();
		this.mapWidth = map.getWidth()*map.getTileWidth();
		this.mapHeight = map.getHeight()*map.getTileHeight();
		this.mapBuffer = newBuffer(mapWidth, mapHeight, Transparency.TRANSLUCENT);
		this.air = ImageManager.getImage("data/images/air.png");
		this.path = ImageManager.getImage("data/images/background_Path.png");
		this.foreground = ImageManager.getImage("data/images/voorgrond.png");
		this.scrap1 = ImageManager.getImage("data/images/background_Scrap1.png");
		this.scrap2 = ImageManager.getImage("data/images/background_Scrap2.png");
		
		this.scroll1=0;
		this.scroll2=0;
	}

	@Override
	protected void drawFrame(Graphics2D g) {
		bufferMap();
		scroll2 += 10;
		this.drawScreens(g);
	}
	
	protected void drawScreens(Graphics2D g) {
		int sWidth = this.getWidth();
		int sHeight = this.getHeight();
		int numPlayers = players.size();
		float scaledY = sHeight/(1f*numPlayers)/mapHeight;
		
		int i=0;
		for (Player player : players) {
			Cursor cursor = player.getCursor();
			int posX = (int) (cursor.getPosition()*getMap().getTileWidth());
			this.drawTiled(g, air, i*(sHeight/numPlayers));
			//g.drawImage(air, 0, i*(sHeight/numPlayers), (int)(air.getWidth()*scaledY), (int)(air.getHeight()*scaledY), null);
			this.drawParralax(g, posX/2, i*(sHeight/numPlayers));
			this.drawLoopMap(g, posX, i*(sHeight/numPlayers));
			i++;
		}
	}
	
	protected void drawResources(Graphics2D g) {
		Map map = this.getMap();
		List<ResourcePoint> points = new GameObjectGrabber<ResourcePoint>().getObjects(map, ResourcePoint.class);
		for (ResourcePoint point : points) {
			int x = (int) (point.getBody().getWorldCenter().x*map.getTileWidth());
			int y = (int) (point.getBody().getWorldCenter().y*map.getTileHeight());
			Sprite sprite = point.getResource().getSprite();
			int width = sprite.getImage().getWidth();
			int height = sprite.getImage().getHeight();
			this.drawSprite(g,sprite, x-width/2, y-height);
		}
	}
	
	protected void drawBuildings(Graphics2D g) {
		Map map = this.getMap();
		for (Player player : players) {
			List<Building> buildings = player.getBuildingList();
			for (Building building : buildings) {
				int x = (int) (building.getBody().getWorldCenter().x*map.getTileWidth());
				int y = (int) (building.getBody().getWorldCenter().y*map.getTileHeight());
				Sprite sprite = building.getSprite();
				int width = sprite.getImage().getWidth();
				int height = sprite.getImage().getHeight();
				this.drawSprite(g,sprite, x-width/2, y-height);
			}
		}
	}
	
	protected void drawParralax(Graphics2D g, int offX, int offY) {
		int sHeight = this.getHeight();
		int sWidth = this.getWidth();
		float scaledY = sHeight/2f/mapHeight;
		g.drawImage(scrap1, (int)(sWidth*Math.sin(-offX/(float)sWidth)), offY, (int)(scrap1.getWidth()*scaledY), (int)(scrap1.getHeight()*scaledY), null);
	}
	
	protected void drawLoopMap(Graphics2D g, int offX, int offY){
		int sWidth = this.getWidth();
		int sHeight = this.getHeight();
		float scaledY = sHeight/2f/mapHeight;
		int scaledWidth =  (int) (mapWidth*scaledY);
		//g.drawImage(scrap2, 100, 0, null);
		//float scaledY = sHeight/2f/mapHeight;
		this.drawMap(g, offX%(scaledWidth)+scaledWidth, offY);
		this.drawMap(g, offX%(scaledWidth), offY);
		this.drawMap(g, offX%(scaledWidth)-scaledWidth, offY);
	}
	
	protected void drawMap(Graphics2D g, int offX, int offY) {
		int sWidth = this.getWidth();
		int sHeight = this.getHeight();
		float scaledY = sHeight/2f/mapHeight;
		int scaledWidth =  (int) (mapWidth*scaledY);
		int scaledHeight =  (int) (mapHeight*scaledY);
		g.drawImage(mapBuffer, offX, offY, scaledWidth, scaledHeight, null);
	}
	
	protected void bufferMap() {
		Graphics2D g = mapBuffer.createGraphics();
		g.setBackground(new Color(1,1,1,0));
		g.clearRect(0, 0, mapWidth, mapHeight);
		drawTiled(g, path, mapHeight-path.getHeight());
		this.drawResources(g);
		this.drawBuildings(g);
		drawTiled(g, foreground, mapHeight-path.getHeight());
		//this.drawSprite(g, mapMiddle, 0, 0);
		g.dispose();
	}
	
	protected void drawTiled(Graphics2D g, BufferedImage image, int height) {
		for (int x=0; x<mapWidth; x+=image.getWidth()) {
			g.drawImage(image, x, height, null);
		}
	}

	@Override
	protected void drawGameObjects(Graphics2D g, List<GameObject> gameObjects) {
		// Not needed.
	}

}
