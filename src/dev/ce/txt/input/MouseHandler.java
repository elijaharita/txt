package dev.ce.txt.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.ce.txt.gfx.gui.GUIHandler;

public class MouseHandler implements MouseListener, MouseMotionListener {

	public boolean leftClick;
	public boolean rightClick;
	public int mouseX;
	public int mouseY;
	public GUIHandler guiHandler;

	public MouseHandler() {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(guiHandler != null) {
			guiHandler.onMouseMoved(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClick = true;
		}

		if (e.getButton() == MouseEvent.BUTTON2) {
			rightClick = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClick = false;
			if(guiHandler != null) {
				guiHandler.onMouseRelease(e);
			}
		}
		
		if (e.getButton() == MouseEvent.BUTTON2) {
			rightClick = false;
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public boolean isRightDown() {
		return rightClick;
	}

	public boolean isLeftDown() {
		return leftClick;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setGUIHandler(GUIHandler guiHandler) {
		this.guiHandler = guiHandler;
	}

}
