package com.snappycobra.ggj16;

import com.snappycobra.ggj16.graphics.GodPainter;
import com.snappycobra.ggj16.model.GameModel;
import com.snappycobra.ggj16.model.GodGame;
import com.snappycobra.motor.demo.DemoGame;
import com.snappycobra.motor.demo.DemoPainter;
import com.snappycobra.motor.demo.WindowCloseController;
import com.snappycobra.motor.gui.Window;

public class Main {
	public static void main(String[] args){
		GodPainter painter = new GodPainter(new GameModel(2));
		Window window = new Window(300,300,painter);
		window.addKeyListener(new WindowCloseController());
		window.setResizable(true);
		painter.showFPS(true);
		window.setTitle("GGJ16");
		window.setVisible(true);
	}
}
