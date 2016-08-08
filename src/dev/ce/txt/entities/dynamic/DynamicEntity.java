package dev.ce.txt.entities.dynamic;

import dev.ce.txt.Conveyor;
import dev.ce.txt.entities.Entity;

public abstract class DynamicEntity extends Entity {
	
	protected boolean collisionVertical;
	protected boolean collisionHorizontal;
	protected int xSpeed;
	protected int ySpeed;

	public DynamicEntity(int x, int y, int width, int height, Conveyor conveyor) {
		super(x, y, width, height, conveyor);
	}

	public void move() {
		
		if (!collisionVertical) {
			y += ySpeed;
		}

		if (!collisionHorizontal) {
			x += xSpeed;
		}

	}

}
