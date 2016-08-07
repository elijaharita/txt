package dev.ce.txt.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;
import dev.ce.txt.input.KeyHandler;

public class Player extends Entity {
	
	public int speed = 4;
	
	private BufferedImage texture;
	private KeyHandler keyHandler;
	
	public Player(int x, int y, int width, int height, KeyHandler keyHandler) {
		
		super(x, y, width, height);
		this.keyHandler = keyHandler;
		
		texture = Assets.player;
		System.out.println("init");
		
	}

	@Override
	public void tick() {
		
		if(keyHandler.up) {
			y -= speed;	
		}
		
		if(keyHandler.down) {
			y += speed;	
		}
		
		if(keyHandler.left) {
			x -= speed;	
		}
		
		if(keyHandler.right) {
			x += speed;	
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(texture, x, y, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);
		
	}
	
}
