package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class GUIButton extends GUIObject {

	private BufferedImage[] images;
	private ClickListener clickListener;
	private GameString gameString1, gameString2;
	private boolean toggled, toggleable;

	public GUIButton(int x, int y, int width, int height, BufferedImage[] images, String title,
			ClickListener clickListener) {
		super(x, y, width, height);
		this.images = images;
		this.clickListener = clickListener;

		int fontSize = height / 2;

		gameString1 = new GameString(title, fontSize, x + (width - fontSize * title.length()) / 2,
				y + (height - fontSize) / 2);
	}

	public GUIButton(int x, int y, int width, int height, BufferedImage[] images, String title, String title2,
			ClickListener clickListener) {
		super(x, y, width, height);
		this.images = images;
		this.clickListener = clickListener;

		int fontSize = height / 2;

		gameString1 = new GameString(title, fontSize, x + (width - fontSize * title.length()) / 2,
				y + (height - fontSize) / 2);
		gameString2 = new GameString(title2, fontSize, x + (width - fontSize * title2.length()) / 2,
				y + (height - fontSize) / 2);
		
		toggleable = true;
		
	}

	public GUIButton(BufferedImage[] images, String title, ClickListener clickListener) {
		super(0, 0, 8 * Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE);
		this.images = images;
		this.clickListener = clickListener;
		gameString1 = new GameString(title, 32, x + (width - 32 * title.length()) / 2,
				y + (height - 32) / 2);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (hovering) {
			g.drawImage(images[1], x, y, width, height, null);
		} else {
			g.drawImage(images[0], x, y, width, height, null);
		}
		if (!toggled && gameString1 != null) {
			gameString1.render(g);
		} else if (toggled && gameString2 != null) {
			gameString2.render(g);
		}
	}

	@Override
	public void onClick() {

		clickListener.onClick();
		toggle();

	}

	public void setText(String text) {
		gameString1.setText(text);
	}

	public void toggle() {
		if(toggleable) {
			toggled = !toggled;
		}
	}

}
