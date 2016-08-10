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
	public static BufferedImage guiButton[];
	public static SpriteSheet spriteSheet;
	public static SpriteSheet gui;
	
	public static void init() {
		
		guiButton = new BufferedImage[2];
		
		spriteSheet = new SpriteSheet(ImageHandler.loadImage("/textures/spritesheet.png"));
		gui = new SpriteSheet(ImageHandler.loadImage("/textures/GUI.png"));
		
		ungenerated = spriteSheet.getImage(0, 0);
		player = spriteSheet.getImage(1, 0);
		grass = spriteSheet.getImage(2, 0);
		dirt = spriteSheet.getImage(3, 0);
		stone = spriteSheet.getImage(4, 0);
		npc = spriteSheet.getImage(5, 0);
		
		guiButton[0] = gui.getImage(0, 0, 8, 1);
		guiButton[1] = gui.getImage(0, 1, 8, 1);
		
	}
	
	public static void setTexturePack(int texturePack) {
		
	}
	
}
