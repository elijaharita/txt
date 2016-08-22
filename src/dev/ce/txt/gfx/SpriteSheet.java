package dev.ce.txt.gfx;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class SpriteSheet {
	
	private BufferedImage spriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	public BufferedImage getImage(int x, int y) {
		return spriteSheet.getSubimage(x * Assets.DEFAULTSIZE, y * Assets.DEFAULTSIZE, Assets.DEFAULTSIZE, Assets.DEFAULTSIZE);
	}
	
	public BufferedImage getImage(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x * Assets.DEFAULTSIZE, y * Assets.DEFAULTSIZE, width * Assets.DEFAULTSIZE, height * Assets.DEFAULTSIZE);
	}
	
	public int getWidth() {
		return spriteSheet.getWidth() / Assets.DEFAULTSIZE;
	}
	
	public int getHeight() {
		return spriteSheet.getHeight() / Assets.DEFAULTSIZE;
	}
	
}
