package dev.ce.txt.gfx.gui;

import java.awt.Graphics;

import dev.ce.txt.assets.Assets;

public class GameString extends GUIObject {

	char letters[];
	public int x, y;
	public int fontSize;
	public String text;
	
	public GameString(String text, int fontSize, int x, int y) {
		
		super(x, y, text.length() * fontSize, fontSize);
		
		this.x = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
		
		letters = new char[text.length()];
		setText(text);
		
	}
	

	public void setText(String text) {
		for(int i = 0; i < text.length(); i++) {
			
			letters[i] = text.charAt(i);
		}
		
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < text.length(); i++)
		
		g.drawImage(Assets.getCharacterImage(letters[i]), x + i * fontSize, y, fontSize, fontSize, null);
		//System.out.println(letters[i]);
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void onClick() {
		
	}
	
}
