package com.snappycobra.ggj16;

import com.snappycobra.motor.demo.DemoGame;
import com.snappycobra.motor.demo.DemoPainter;
import com.snappycobra.motor.graphics.GamePainter;
import com.snappycobra.motor.gui.Window;

public class Main {
	public static void main(String[] args){
		GamePainter painter = new DemoPainter(new DemoGame());
		Window window = new Window(painter);
		window.setTitle("GGJ16");
		window.setVisible(true);
	}
}
