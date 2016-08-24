package dev.ce.txt.assets;

import java.awt.image.BufferedImage;
import dev.ce.txt.gfx.ImageHandler;
import dev.ce.txt.gfx.SpriteSheet;

public class Assets {
	
	public static final int DEFAULTSIZE = 8;
	public static final int RENDEREDSCALE = 8;
	public static final int DEFAULTRENDEREDSIZE = 64;
	
	public static final String CHARACTERSTRING = " abcdefghijklmnopqrstuvwxyz0123456789.,:;'\"!?$%()-=+/";;
	
	public static BufferedImage cobblestone, grass, dirt, stone, ungenerated, entity, log;
	public static BufferedImage guiButton[];
	public static BufferedImage character[];
	public static BufferedImage textArea;
	public static SpriteSheet spriteSheet;
	public static SpriteSheet gui;
	public static SpriteSheet characters;
	
	public static void init() {
		
		guiButton = new BufferedImage[2];
		
		setTexturePack("Graphics");
		
	}
	
	public static void setTexturePack(String path) {
		
		path = "/textures/" + path;
		spriteSheet = new SpriteSheet(ImageHandler.loadImage(path + "/tiles.png"));
		gui = new SpriteSheet(ImageHandler.loadImage(path + "/GUI.png"));
		characters = new SpriteSheet(ImageHandler.loadImage(path + "/characters.png"));
		
		loadImages();
		
	}
	
	public static void loadImages() {
		
		ungenerated = spriteSheet.getImage(0, 0);
		cobblestone = spriteSheet.getImage(1, 0);
		grass = spriteSheet.getImage(2, 0);
		dirt = spriteSheet.getImage(3, 0);
		stone = spriteSheet.getImage(4, 0);
		entity = spriteSheet.getImage(5, 0);
		log = spriteSheet.getImage(6, 0);
		
		guiButton[0] = gui.getImage(0, 0, 8, 1);
		guiButton[1] = gui.getImage(0, 1, 8, 1);
		textArea = gui.getImage(0, 2, 8, 1);
		
	}
	
	public static BufferedImage getCharacterImage(char character) {

		return getCharacter(character);
		
	}
	
	public static BufferedImage getCharacter(char character) {
		
		int charAt = 0;
		char currentChar = 0;
		
		for(int y = 0; y < characters.getWidth(); y++) {
			for(int x = 0; x < characters.getHeight(); x++) {
				try {
					currentChar = CHARACTERSTRING.charAt(charAt);
				} catch(StringIndexOutOfBoundsException e) {
					System.err.println("String out of bounds exception: " + charAt);
				}
				if(Character.toLowerCase(character) == currentChar) {
					return characters.getImage(x, y);
				}
				charAt++;
			}
		}
		
		System.err.println("Couldn't find character: " + character);
		return null;
		
	}
	
}