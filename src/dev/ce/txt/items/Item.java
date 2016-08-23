package dev.ce.txt.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public abstract class Item {
	
	public static Item items[] = new Item[256];
	
	protected BufferedImage texture;
	protected int id;

	public Item(BufferedImage texture, int id) {
		
		this.id = id;
		
		items[id] = this;
		
	}
	
	public abstract BufferedImage texture();
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		
		g.drawImage(texture(), x, y, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, null);
		
	}
	
}