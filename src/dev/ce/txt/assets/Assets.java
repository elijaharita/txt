package dev.ce.txt.assets;

import java.awt.image.BufferedImage;

import dev.ce.txt.gfx.ImageHandler;
import dev.ce.txt.gfx.SpriteSheet;

public class Assets {
	
	public static final int DEFAULTSIZE = 8;
	public static final int RENDEREDSCALE = 8;
	public static final int DEFAULTRENDEREDSIZE = DEFAULTSIZE * RENDEREDSCALE;
	public static boolean perBlockMovement = true;
	
	public static BufferedImage player, grass, dirt, stone, ungenerated, npc;
	public static SpriteSheet spriteSheet;
	
	public static void init() {
		
		spriteSheet = new SpriteSheet(ImageHandler.loadImage("/textures/spritesheet.png"));
		
		ungenerated = spriteSheet.getImage(0, 0);
		player = spriteSheet.getImage(1, 0);
		grass = spriteSheet.getImage(2, 0);
		dirt = spriteSheet.getImage(3, 0);
		stone = spriteSheet.getImage(4, 0);
		npc = spriteSheet.getImage(5, 0);
		
	}
	
	public static void setTexturePack(int texturePack) {
		
	}
	
}
