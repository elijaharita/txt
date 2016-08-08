package dev.ce.txt.gfx;

import dev.ce.txt.Conveyor;
import dev.ce.txt.entities.Entity;

public class Camera {

	public int xOffset;
	public int yOffset;
	
	private Conveyor conveyor;
	
	public Camera(Conveyor conveyor) {
		this.conveyor = conveyor;
	}
	
	public void focusEntity(Entity e) {
		xOffset = e.getX() - conveyor.getGameWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - conveyor.getGameHeight() / 2 + e.getHeight() / 2;
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
}
