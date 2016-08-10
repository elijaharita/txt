package dev.ce.txt.entities.dynamic;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.input.KeyHandler;

public class Player extends DynamicEntity {

	public int speed = 4;

	private Conveyor conveyor;
	private KeyHandler keyHandler;

	// These variables only used in per-block movement
	private int ticksSinceLastMoveX;
	private int ticksSinceLastMoveY;

	public Player(int x, int y, int width, int height, Conveyor conveyor) {

		super(x, y, width, height, conveyor);
		this.conveyor = conveyor;
		this.keyHandler = conveyor.getKeyHandler();

		texture = Assets.player;

	}

	public void smoothMove() {

	}

	@Override
	public void tick() {

		ticksSinceLastMoveY++;
		ticksSinceLastMoveX++;

		if (!Assets.perBlockMovement) {

			if (keyHandler.up) {
				ySpeed = -speed;
			}

			if (keyHandler.down) {
				ySpeed = speed;
			}

			else if (!keyHandler.down && !keyHandler.up) {
				ySpeed = 0;
			}

			if (keyHandler.left) {
				xSpeed = -speed;
			}

			if (keyHandler.right) {
				xSpeed = speed;
			}

			else if (!keyHandler.left && !keyHandler.right) {
				xSpeed = 0;
			}

		}

		if (Assets.perBlockMovement) {

			x = (int) Math.floor(x / Assets.DEFAULTRENDEREDSIZE) * Assets.DEFAULTRENDEREDSIZE;
			y = (int) Math.floor(y / Assets.DEFAULTRENDEREDSIZE) * Assets.DEFAULTRENDEREDSIZE;

			if (ticksSinceLastMoveY >= Assets.DEFAULTRENDEREDSIZE / speed) {

				if (keyHandler.up) {
					y -= Assets.DEFAULTRENDEREDSIZE;
					ticksSinceLastMoveY = 0;
				}

				if (keyHandler.down) {
					y += Assets.DEFAULTRENDEREDSIZE;
					ticksSinceLastMoveY = 0;
				}

			}

			if (ticksSinceLastMoveX >= Assets.DEFAULTRENDEREDSIZE / speed) {

				if (keyHandler.left) {
					x -= Assets.DEFAULTRENDEREDSIZE;
					ticksSinceLastMoveX = 0;
				}

				if (keyHandler.right) {
					x += Assets.DEFAULTRENDEREDSIZE;
					ticksSinceLastMoveX = 0;
				}

			}

		}

		if (x < 0)

		{
			x = 0;
		}

		if (y < 0)

		{
			y = 0;
		}

		if (x >= conveyor.getWorld().getWidth() * Assets.DEFAULTRENDEREDSIZE - 8)

		{
			x = conveyor.getWorld().getWidth() * Assets.DEFAULTRENDEREDSIZE - 8;
		}

		if (y >= conveyor.getWorld().getHeight() * Assets.DEFAULTRENDEREDSIZE + 8)

		{
			y = conveyor.getWorld().getHeight() * Assets.DEFAULTRENDEREDSIZE + 8;
		}

		move();
		conveyor.getCamera().focusEntity(this);

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(texture, x - conveyor.getCamera().getXOffset(), y - conveyor.getCamera().getYOffset(),
				Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);
	}

}
