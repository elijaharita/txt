package dev.ce.txt.entities.dynamic;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.input.KeyHandler;

public class Player extends DynamicEntity {

	public int speed = 4;

	private Conveyor conveyor;
	private KeyHandler keyHandler;

	public Player(int x, int y, int width, int height, Conveyor conveyor) {

		super(x, y, width, height, conveyor);
		this.conveyor = conveyor;
		this.keyHandler = conveyor.getKeyHandler();

		texture = Assets.player;

	}

	@Override
	public void tick() {
		
		if (keyHandler.up) {
			ySpeed = -speed;
		}

		if (keyHandler.down) {
			ySpeed = speed;
		} 
		
		else if(!keyHandler.down && !keyHandler.up) {
			ySpeed = 0;
		}

		if (keyHandler.left) {
			xSpeed = -speed;
		}

		if (keyHandler.right) {
			xSpeed = speed;
		}
		
		else if(!keyHandler.left && !keyHandler.right) {
			xSpeed = 0;
		}
		
		move();
		conveyor.getCamera().focusEntity(this);
		
	}

	@Override
	public void render(Graphics g) {
		System.out.println(x);

		g.drawImage(texture, x - conveyor.getCamera().getXOffset(), y - conveyor.getCamera().getYOffset(), Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);

	}

}
