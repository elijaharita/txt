package dev.ce.txt.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	private boolean keys[];
	
	public KeyHandler() {
		
		keys = new boolean[256];
		
	}
	
	public void tick() {
		
		up = keys[87];
		down = keys[83];
		left = keys[65];
		right = keys[68];
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

}
