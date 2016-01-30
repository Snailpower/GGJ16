package com.snappycobra.ggj16.control;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.motor.control.KeyCommander;

public class CursorCommander extends KeyCommander {
	private Cursor cursor;
	public CursorCommander(Cursor cursor) {
		this.cursor = cursor;
	}
	
	public Cursor getCursor() {
		return this.cursor;
	}
}
