package dev.ce.txt.gfx;

import dev.ce.txt.Conveyor;
import dev.ce.txt.Util;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.entities.Entity;

public class Camera {

	public int xOffset;
	public int yOffset;
	
	private Conveyor conveyor;
	
	public Camera(Conveyor conveyor) {
		this.conveyor = conveyor;
	}
	
	public void focusEntity(Entity e) {
		xOffset = (int) Util.clamp(0, (conveyor.getWorld().getWidth()) * Assets.DEFAULTRENDEREDSIZE - conveyor.getGameWidth(),
				e.getX() - conveyor.getGameWidth() / 2 + e.getWidth() / 2);
		yOffset = (int) Util.clamp(0, (conveyor.getWorld().getHeight()) * Assets.DEFAULTRENDEREDSIZE - conveyor.getGameHeight(),
				e.getY() - conveyor.getGameHeight() / 2 + e.getHeight() / 2);
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
}
