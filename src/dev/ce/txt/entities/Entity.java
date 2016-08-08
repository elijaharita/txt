package dev.ce.txt.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.Conveyor;

public abstract class Entity {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected BufferedImage texture;
	protected Conveyor conveyor;
	
	public Entity(int x, int y, int width, int height, Conveyor conveyor) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.conveyor = conveyor;
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
