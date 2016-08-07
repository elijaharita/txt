package dev.ce.txt.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	private boolean keys[];
	
	public KeyHandler() {
		keys = new boolean[256];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		System.out.println(e.getKeyCode() + " Is true!");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
