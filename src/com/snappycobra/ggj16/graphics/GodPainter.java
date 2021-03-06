package com.snappycobra.ggj16.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.List;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.AABB;
import org.dyn4j.geometry.Vector2;

import com.snappycobra.ggj16.model.Base;
import com.snappycobra.ggj16.model.Building;
import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.ggj16.model.GameModel;
import com.snappycobra.ggj16.model.Player;
import com.snappycobra.ggj16.model.Resource;
import com.snappycobra.ggj16.model.ResourcePoint;
import com.snappycobra.ggj16.model.Shrine;
import com.snappycobra.ggj16.model.Unit;
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
	private BufferedImage air, path, foreground, scrap1, scrap2, shrineImg, arrowUp;
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
		this.shrineImg = ImageManager.getImage("data/images/Hud_Sacrifice.png");
		this.arrowUp = ImageManager.getImage("data/images/Interface_Pijl_up.png");
		
		this.scroll1=0;
		this.scroll2=0;
	}

	@Override
	protected void drawFrame(Graphics2D g) {
		bufferMap();
		scroll2 += 10;
		this.drawScreens(g);
		g.setColor(new Color(1,1,1));
	}
	
	protected void drawScreens(Graphics2D g) {
		int sWidth = this.getWidth();
		int sHeight = this.getHeight();
		int numPlayers = players.size();
		float scaledY = sHeight/(1f*numPlayers)/mapHeight;
		
		int i=0;
		for (Player player : players) {
			Cursor cursor = player.getCursor();
			int posX = (int) (cursor.getPosition()*getMap().getTileWidth()*scaledY);
			//System.out.println(posX);
			this.drawTiled(g, air, i*(sHeight/numPlayers));
			//g.drawImage(air, 0, i*(sHeight/numPlayers), (int)(air.getWidth()*scaledY), (int)(air.getHeight()*scaledY), null);
			//g.drawImage(air, (int)(air.getWidth()*scaledY), i*(sHeight/numPlayers), (int)(air.getWidth()*scaledY), (int)(air.getHeight()*scaledY), null);
			this.drawParralax(g, sWidth/2+posX/2, i*(sHeight/numPlayers));
			this.drawLoopMap(g, sWidth/2+posX, i*(sHeight/numPlayers));
			i++;
		}
		g.setColor(Color.BLACK);
		g.drawLine(sWidth/2, sHeight, sWidth/2, 0);
	}
	
	protected void drawResources(Graphics2D g) {
		Map map = this.getMap();
		List<ResourcePoint> points = new GameObjectGrabber<ResourcePoint>().getObjects(map, ResourcePoint.class);
		for (ResourcePoint point : points) {
			int x = getX(point.getBody());
			int y = getY(point.getBody());
			Sprite sprite = point.getResource().getSprite();
			int width = sprite.getImage().getWidth();
			int height = sprite.getImage().getHeight();
			this.drawSprite(g,sprite, x, y-height);
		}
	}
	
	protected void drawUnits(Graphics2D g) {
		Map map = this.getMap();
		for (Player player : players) {
			for (Unit unit : player.getUnitList()) {
				Sprite sprite = unit.getJob().getSprite();
				int x = getX(unit.getBody());
				int y = getY(unit.getBody());

				int width = sprite.getImage().getWidth();
				int height = sprite.getImage().getHeight();
				this.drawSprite(g, sprite, x, y-height);
			}
		}
	}
	
	protected void drawShrine(Graphics2D g) {
		Map map = this.getMap();
		Shrine shrine = new GameObjectGrabber<Shrine>().getObjects(map, Shrine.class).get(0);
		int x = getX(shrine.getBody());
		int y = getY(shrine.getBody());
		g.drawImage(arrowUp, x+shrineImg.getWidth()/2, 0, null);
		g.drawImage(shrineImg, x, 0, null);
	}
	
	protected int getX(Body body) {
		return (int) (getLoc(body).x*getMap().getTileWidth());
	}
	
	protected int getY(Body body) {
		return (int) (getLoc(body).y*getMap().getTileHeight());
	}
	
	protected Vector2 getLoc(Body body) {
		AABB aabb = body.createAABB();
		double width = aabb.getWidth();
		double height = aabb.getHeight();
		double x= body.getWorldCenter().x-width/2;
		double y= body.getWorldCenter().y+height/2;
		return new Vector2(x, y);
	}
	
	protected void drawBuildings(Graphics2D g) {
		Map map = this.getMap();
		for (Player player : players) {
			List<Building> buildings = player.getBuildingList();
			for (Building building : buildings) {
				int x = getX(building.getBody());
				int y = getY(building.getBody());
				Sprite sprite = building.getSprite();
				int width = sprite.getImage().getWidth();
				int height = sprite.getImage().getHeight();
				this.drawSprite(g,sprite, x, y-height);
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
		this.drawUnits(g);
		this.drawShrine(g);
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
