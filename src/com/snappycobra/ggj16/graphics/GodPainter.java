package com.snappycobra.ggj16.graphics;

import java.util.ArrayList;

import com.jogamp.opengl.GL4;
import com.snappycobra.ggj16.model.GodGame;
import com.snappycobra.motor.graphics.GamePainter;
import com.snappycobra.motor.graphics.Model;
import com.snappycobra.motor.graphics.TileModel;
import com.snappycobra.motor.maps.GameObjectLayer;
import com.snappycobra.motor.maps.Map;
import com.snappycobra.motor.model.Game;

public class GodPainter extends GamePainter{

	public GodPainter(GodGame game) {
		super(game);
	}

	@Override
	protected ArrayList<Model> loadGameObjects(GL4 arg0, GameObjectLayer arg1) {
		ArrayList<Model> models = new ArrayList<Model>();
		return models;
	}
	
	@Override
	protected void drawTile(GL4 gl4, TileModel tileModel) {
		drawModel(gl4, tileModel);
	}
	
	@Override
	protected void drawMap(GL4 gl4) {
		Map map = this.getMap();
		float width = map.getWidth();
		float height = map.getHeight();
		this.lookAt(width/2,height, -18);
		super.drawMap(gl4);
	}

}
