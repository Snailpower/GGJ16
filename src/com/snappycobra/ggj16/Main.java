package com.snappycobra.ggj16;

import java.util.List;

import com.snappycobra.ggj16.control.CursorController;
import com.snappycobra.ggj16.graphics.GodPainter;
import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.ggj16.model.GameModel;
import com.snappycobra.ggj16.model.Player;
import com.snappycobra.motor.demo.DemoGame;
import com.snappycobra.motor.demo.DemoPainter;
import com.snappycobra.motor.demo.WindowCloseController;
import com.snappycobra.motor.gui.Window;

public class Main {
	public static void main(String[] args){
		GameModel model = new GameModel(2);
		GodPainter painter = new GodPainter(new GameModel(2));
		Window window = new Window(300,300,painter);
		List<Player> player = model.getPlayerList();
		Cursor cursor1 = player.get(0).getCursor();
		Cursor cursor2 = player.get(1).getCursor();
		CursorController controller = new CursorController(cursor1, cursor2);
		window.addKeyListener(controller);
		window.addKeyListener(new WindowCloseController());
		window.setResizable(true);
		painter.showFPS(true);
		window.setTitle("GGJ16");
		window.setVisible(true);
	}
}
