package com.snappycobra.ggj16.control;

import java.awt.event.KeyEvent;

import com.snappycobra.ggj16.model.Cursor;

public class ArrowCursorController extends CursorController{

	public ArrowCursorController(Cursor cursor) {
		this.pressCommander = new ArrowPressCommander(cursor);
		this.releaseCommander = new ArrowReleaseCommander(cursor);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		pressCommander.execute(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		releaseCommander.execute(e.getKeyCode());
	}

}
