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
	public static BufferedImage character[];
	public static SpriteSheet spriteSheet;
	public static SpriteSheet gui;
	public static SpriteSheet characters;
	
	public static void init() {
		
		guiButton = new BufferedImage[2];
		
		setTexturePack("ASCII");
		
	}
	
	public static void setTexturePack(String path) {
		path = "/textures/" + path;
		spriteSheet = new SpriteSheet(ImageHandler.loadImage(path + "/spritesheet.png"));
		gui = new SpriteSheet(ImageHandler.loadImage(path + "/GUI.png"));
		characters = new SpriteSheet(ImageHandler.loadImage(path + "/characters.png"));
		
		loadImages();
		
	}
	
	public static void loadImages() {
		
		ungenerated = spriteSheet.getImage(0, 0);
		player = spriteSheet.getImage(1, 0);
		grass = spriteSheet.getImage(2, 0);
		dirt = spriteSheet.getImage(3, 0);
		stone = spriteSheet.getImage(4, 0);
		npc = spriteSheet.getImage(5, 0);
		
		guiButton[0] = gui.getImage(0, 0, 8, 1);
		guiButton[1] = gui.getImage(0, 1, 8, 1);
		
	}
	
	public static BufferedImage getCharacterImage(char character) {

		return getCharacter(character);
		
	}
	
	public static BufferedImage getCharacter(char character) {
		
		switch(Character.toLowerCase(character)) {
		case 'a':
			return characters.getImage(0, 0);
			
		case 'b':
			return characters.getImage(1, 0);

		case 'c':
			return characters.getImage(2, 0);
			
		case 'd':
			return characters.getImage(3, 0);
			
		case 'e':
			return characters.getImage(4, 0);
			
		case 'f':
			return characters.getImage(5, 0);
			
		case 'g':
			return characters.getImage(6, 0);
			
		case 'h':
			return characters.getImage(7, 0);
			
		case 'i':
			return characters.getImage(0, 1);
			
		case 'j':
			return characters.getImage(1, 1);

		case 'k':
			return characters.getImage(2, 1);
			
		case 'l':
			return characters.getImage(3, 1);
			
		case 'm':
			return characters.getImage(4, 1);
			
		case 'n':
			return characters.getImage(5, 1);
			
		case 'o':
			return characters.getImage(6, 1);
			
		case 'p':
			return characters.getImage(7, 1);
			
		case 'q':
			return characters.getImage(0, 2);
			
		case 'r':
			return characters.getImage(1, 2);
			
		case 's':
			return characters.getImage(2, 2);
			
		case 't':
			return characters.getImage(3, 2);
			
		case 'u':
			return characters.getImage(4, 2);
			
		case 'v':
			return characters.getImage(5, 2);
			
		case 'w':
			return characters.getImage(6, 2);
			
		case 'x':
			return characters.getImage(7, 2);
			
		case 'y':
			return characters.getImage(0, 3);
			
		case 'z':
			return characters.getImage(1, 3);
			
		}
		
		return null;
		
	}
	
}
