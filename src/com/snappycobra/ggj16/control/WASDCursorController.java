package com.snappycobra.ggj16.control;

import java.awt.event.KeyEvent;

import com.snappycobra.ggj16.model.Cursor;

public class WASDCursorController extends CursorController{

	public WASDCursorController(Cursor cursor) {
		this.pressCommander = new WASDPressCommander(cursor);
		this.releaseCommander = new WASDReleaseCommander(cursor);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		pressCommander.execute(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e) {
		releaseCommander.execute(e.getKeyCode());
	}

}
