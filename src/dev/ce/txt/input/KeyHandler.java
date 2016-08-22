package dev.ce.txt.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean up, down, left, right, stats, paused;
	
	public boolean keys[];
	public boolean toggleKeys[];
	
	public KeyHandler() {
		
		keys = new boolean[1024];
		toggleKeys = new boolean[1024];
		
	}
	
	public void tick() {
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		stats = toggleKeys[192];
		paused = toggleKeys[KeyEvent.VK_ESCAPE];
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
		//System.out.println(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		toggleKeys[e.getKeyCode()] = !toggleKeys[e.getKeyCode()];
		
	}

}
