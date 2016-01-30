package com.snappycobra.ggj16.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.motor.control.KeyCommander;

public class CursorController extends KeyAdapter {
	private KeyCommander cursorCommander;
	
	public CursorController(Cursor cursor1, Cursor cursor2) {
		this.cursorCommander = new CursorCommander(cursor1, cursor2);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		cursorCommander.execute(e.getKeyCode());
	}
}
