package dev.ce.txt.assets;

import java.awt.image.BufferedImage;

import dev.ce.txt.gfx.ImageHandler;
import dev.ce.txt.gfx.SpriteSheet;

public class Assets {
	
	public static final int DEFAULTSIZE = 8;
	public static final int RENDEREDSCALE = 8;
	public static final int DEFAULTRENDEREDSIZE = DEFAULTSIZE * RENDEREDSCALE;
	
	public static BufferedImage player, grass, dirt;
	private static SpriteSheet spriteSheet;
	
	public static void init() {
		
		spriteSheet = new SpriteSheet(ImageHandler.loadImage("/textures/spritesheet.png"));
		
		player = spriteSheet.getImage(0, 0);
		grass = spriteSheet.getImage(1, 0);
		dirt = spriteSheet.getImage(2, 0);
		
	}
	
}
