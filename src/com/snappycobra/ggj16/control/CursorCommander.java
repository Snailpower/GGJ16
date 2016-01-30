package com.snappycobra.ggj16.control;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.snappycobra.ggj16.model.Cursor;
import com.snappycobra.motor.control.KeyCommander;

public class CursorCommander extends KeyCommander {
	private Cursor cursor1, cursor2;
	public CursorCommander(Cursor cursor1, Cursor cursor2) {
		this.cursor1 = cursor1;
		this.cursor2 = cursor2;
		this.addCommand(KeyEvent.VK_LEFT, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor1().moveLeft();
			}
		});
		
		this.addCommand(KeyEvent.VK_A, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor2().moveLeft();
			}
		});
		
		this.addCommand(KeyEvent.VK_RIGHT, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor1().moveRight();
			}
		});
		
		this.addCommand(KeyEvent.VK_D, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor2().moveRight();
			}
		});
	}
	
	private Cursor getCursor1() {
		return this.cursor1;
	}
	
	private Cursor getCursor2() {
		return this.cursor2;
	}
}
