package dev.ce.txt.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.Conveyor;
import dev.ce.txt.Game;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.input.KeyHandler;

public class Player extends Entity {
	
	public int speed = 4;
	
	private BufferedImage texture;
	private Conveyor conveyor;
	private KeyHandler keyHandler;
	
	public Player(int x, int y, int width, int height, Conveyor conveyor) {
		
		super(x, y, width, height);
		this.conveyor = conveyor;
		this.keyHandler = conveyor.getKeyHandler();
		
		texture = Assets.player;
		
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
		
		if(x + Assets.DEFAULTRENDEREDSIZE > Game.WIDTH) {
			x = Game.WIDTH - Assets.DEFAULTRENDEREDSIZE;
		}
		
		if(x < 0) {
			x = 0;
		}
		
		if(y + Assets.DEFAULTRENDEREDSIZE > Game.HEIGHT) {
			y = Game.HEIGHT - Assets.DEFAULTRENDEREDSIZE;
		}
		
		if(y < 0) {
			y = 0;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(texture, x, y, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);
		
	}
	
}
