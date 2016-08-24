package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.Game;
import dev.ce.txt.assets.Assets;

public class GameString extends GUIObject {

	public char letters[];
	public BufferedImage character[];
	public int x, y;
	public int fontSize;
	public String text;

	public GameString(String text, int fontSize, int x, int y) {

		super(x, y, text.length() * fontSize, fontSize);

		this.x = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
		setText(text);

	}

	public void setText(String text) {
		this.text = text;
		letters = new char[text.length()];
		character = new BufferedImage[letters.length];
		
		for (int i = 0; i < text.length(); i++) {
			letters[i] = text.charAt(i);
			character[i] = Assets.getCharacterImage(letters[i]);
		}
		
	}
	
	public String getText() {
		return text;
	}

	public void render(Graphics g) {
		
		for (int i = 0; i < text.length(); i++) {

			g.drawImage(character[i], x + i * fontSize, y, fontSize, fontSize, null);
			
		}

	}
	
	public void centerX() {
		x = Game.width / 2 - text.length() * fontSize / 2;
	}

	@Override
	public void tick() {
	}

	@Override
	public void onClick() {
	}

}
