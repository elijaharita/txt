package dev.ce.txt.gfx;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.GlobalVariables;

public class SpriteSheet {
	
	private BufferedImage spriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	public BufferedImage getImage(int x, int y) {
		return spriteSheet.getSubimage(x * GlobalVariables.DEFAULTSIZE, y * GlobalVariables.DEFAULTSIZE, GlobalVariables.DEFAULTSIZE, GlobalVariables.DEFAULTSIZE);
	}
	
	public BufferedImage getImage(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x * GlobalVariables.DEFAULTSIZE, y * GlobalVariables.DEFAULTSIZE, width, height);
	}
	
}
