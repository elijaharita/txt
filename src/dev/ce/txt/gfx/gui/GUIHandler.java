package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.ce.txt.Conveyor;

public class GUIHandler {

	private Conveyor conveyor;
	private ArrayList<GUIObject> objects;
	
	public void addPanel(GUIObject[] objects) {
		for(GUIObject object : objects) {
			add(object);
		}
	}
	
	public GUIHandler(Conveyor conveyor) {
		this.conveyor = conveyor;
		objects = new ArrayList<GUIObject>();
	}
	
	public void tick() {
		for(GUIObject object : objects) {
			object.tick();
		}
	}
	
	public void render(Graphics g) {
		for(GUIObject object : objects) {
			object.render(g);
		}
	}
	
	public void onMouseMoved(MouseEvent e) {
		for(GUIObject object : objects) {
			object.onMouseMoved(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(GUIObject object : objects) {
			object.onMouseRelease(e);
		}
	}
	
	public void add(GUIObject object) {
		objects.add(object);
	}
	
	public void remove(GUIObject object) {
		objects.remove(object);
	}
	
}
