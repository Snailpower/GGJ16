package com.snappycobra.ggj16.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.motor.control.KeyCommander;

public abstract class CursorController extends KeyAdapter {
	protected CursorCommander pressCommander, releaseCommander;
	
}
