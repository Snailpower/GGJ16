package com.snappycobra.ggj16.control;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.snappycobra.ggj16.model.Cursor;

public class ArrowReleaseCommander extends CursorCommander{
	public ArrowReleaseCommander(Cursor cursor) {
		super(cursor);
		this.addCommand(KeyEvent.VK_LEFT, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor().setMovingLeft(false);
			}
		});
		
		this.addCommand(KeyEvent.VK_RIGHT, new AbstractAction() {
			private static final long serialVersionUID = 331430491826847158L;
			@Override
			public void actionPerformed(ActionEvent e) {
				getCursor().setMovingRight(false);
			}
		});
	}
}
