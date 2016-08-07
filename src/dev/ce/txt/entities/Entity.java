package dev.ce.txt.entities;

import java.awt.Graphics;

public abstract class Entity {

	int x;
	int y;
	int width;
	int height;
	
	public Entity(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
