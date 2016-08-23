package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.ce.txt.Conveyor;

public class GUIHandler {

	@SuppressWarnings("unused")
	private Conveyor conveyor;
	private ArrayList<GUIObject> objects;
	private boolean enabled = true;

	public void addPanel(GUIObject[] objects) {
		for (GUIObject object : objects) {
			add(object);
		}
	}

	public GUIHandler(Conveyor conveyor) {
		this.conveyor = conveyor;
		objects = new ArrayList<GUIObject>();
	}

	public void tick() {
		if (enabled) {
			for (GUIObject object : objects) {
				object.tick();
			}
		}
	}

	public void render(Graphics g) {
		if (enabled) {
			for (GUIObject object : objects) {
				object.render(g);
			}
		}
	}

	public void onMouseMoved(MouseEvent e) {
		if (enabled) {
			for (GUIObject object : objects) {
				object.onMouseMoved(e);
			}
		}
	}

	public void onMouseRelease(MouseEvent e) {
		if (enabled) {
			for (GUIObject object : objects) {
				object.onMouseRelease(e);
			}
		}
	}

	public void add(GUIObject object) {
		objects.add(object);
	}

	public void remove(GUIObject object) {
		objects.remove(object);
	}

	public void disableGUIHandler() {
		enabled = false;
	}
	
	public void enableGUIHandler() {
		enabled = true;
	}
	
	public boolean getEnabled() {
		return enabled;
	}

}
