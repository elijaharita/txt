package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.ce.txt.assets.Assets;

public class GUIContainer extends GUIObject {

	public int paddingX;
	public int paddingY;
	public int x;
	public int y;
	public ArrayList<GUIObject> objects;
	
	public GUIContainer(int x, int y) {

		this.x = x;
		this.y = y;
		
		paddingY = 20;
		paddingX = 20;
		
		objects = new ArrayList<GUIObject>();
		
	}

	public GUIContainer(int x, int y, int paddingX, int paddingY) {

		this.x = x;
		this.y = y;
		this.paddingX = paddingX;
		this.paddingY = paddingY;
		
		objects = new ArrayList<GUIObject>();
		
	}
	
	public void add(GUIObject object) {
		objects.add(object);
		object.setX(x);
		object.setY(y + (objects.size() + paddingY) * Assets.DEFAULTRENDEREDSIZE);
	}
	
	public void remove(GUIObject object) {
		objects.remove(object);
	}

	@Override
	public void tick() {
		for(GUIObject object : objects) {
			object.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		for(GUIObject object : objects) {
			object.render(g);
		}
	}

	@Override
	public void onClick() {
		
	}

}
