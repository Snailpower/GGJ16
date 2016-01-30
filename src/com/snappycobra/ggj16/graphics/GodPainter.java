package com.snappycobra.ggj16.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.List;

import com.snappycobra.ggj16.model.GodGame;
import com.snappycobra.motor.graphics.AbstractPainter;
import com.snappycobra.motor.graphics.Frame;
import com.snappycobra.motor.graphics.ImageManager;
import com.snappycobra.motor.graphics.Sprite;
import com.snappycobra.motor.maps.GameObject;
import com.snappycobra.motor.maps.Map;
import com.snappycobra.motor.maps.MapContainer;
import com.snappycobra.motor.timing.Timer;

public class GodPainter extends AbstractPainter{
	private int mapWidth, mapHeight;
	private BufferedImage mapBuffer;
	private BufferedImage air, path, foreground, scrap1, scrap2;
	private int scroll1, scroll2;
	
	public GodPainter(GodGame godGame) {
		super(godGame);
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
		int sWidth = this.getWidth();
		int sHeight = this.getHeight();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sWidth, sHeight);
		scroll1 += Timer.getPassedTime()/Math.pow(10, 7);
		scroll2 -= Timer.getPassedTime()/Math.pow(10, 7);
		g.drawImage(air, 0, 0, (int)(air.getWidth()), (int)(air.getHeight()), null);
		float scaledY = sHeight/2f/mapHeight;
		g.drawImage(scrap1, 0, 0, (int)(scrap1.getWidth()*scaledY), (int)(scrap1.getHeight()*scaledY), null);
		this.drawLoopMap(g, scroll1, 0);
		this.drawLoopMap(g, scroll2, sHeight/2);
	}
	
	protected void drawParralax(Graphics2D g) {
		
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
