package dev.ce.txt.entities.dynamic;

import java.awt.Graphics;
import java.util.Random;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;

public class Frownie extends DynamicEntity {

	private int speed = 3;
	private boolean direction[];
	
	public Frownie(int x, int y, int width, int height, Conveyor conveyor) {
		
		super(x, y, width, height, conveyor);
		
		direction = new boolean[4];
		texture = Assets.player;
		
	}

	@Override
	public void tick() {
		
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		if(randInt >= 97) {
			
			changeCourse();
			
		}
		
		if(direction[0] == true) {
			x -= speed;
		}
		
		if(direction[1] == true) {
			x += speed;
		}
		
		if(direction[2] == true) {
			y += speed;
		}
		
		if(direction[3] == true) {
			y -= speed;
		}
		
	}
	
	public void changeCourse() {
		
		Random rand = new Random();
		
		for(int i = 0; i < 4; i++) {
			
			int randInt = rand.nextInt(2);
			
			if(randInt == 0) {
				direction[i] = true;
			} else {
				direction[i] = false;
			}
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(texture, x, y, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);
		
	}
	
}
