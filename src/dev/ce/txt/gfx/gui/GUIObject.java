package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javafx.scene.shape.Rectangle;

public abstract class GUIObject {

	protected int x, y, width, height;
	protected Rectangle bounds;
	protected boolean hovering;

	public GUIObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(x, y, width, height);

	}
	
	public GUIObject() {
		
		bounds = new Rectangle(x, y, width, height);

	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void onClick();

	public void onMouseMoved(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		} else {
			hovering = false;
		}
	}

	public void onMouseRelease(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (hovering) {
				onClick();
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isHovering() {
		return hovering;
	}

}
