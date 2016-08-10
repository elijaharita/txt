package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends GUIObject {

	private BufferedImage[] images;
	private ClickListener clickListener;
	
	public Button(int x, int y, int width, int height, BufferedImage[] images, ClickListener clickListener) {
		super(x, y, width, height);
		this.images = images;
		this.clickListener = clickListener;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images[1], x, y, width, height, null);
		} else {
			g.drawImage(images[0], x, y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		clickListener.onClick();
		
	}

}
