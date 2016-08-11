package dev.ce.txt.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean up, down, left, right, stats, pause;
	
	private boolean keys[];
	private boolean toggleKeys[];
	
	public KeyHandler() {
		
		keys = new boolean[1024];
		toggleKeys = new boolean[1024];
		
	}
	
	public void tick() {
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		stats = keys[192];
		pause = toggleKeys[KeyEvent.VK_ESCAPE];
		
		for(int i = 0; i < 1024; i++) {
			if(toggleKeys[i] == true) {
				toggleKeys[i] = false;
			}
		}
		
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
		toggleKeys[e.getKeyCode()] = true;
		
	}

}
