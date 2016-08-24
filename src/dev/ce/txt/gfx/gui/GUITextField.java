package dev.ce.txt.gfx.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;

public class GUITextField extends GUIObject implements KeyListener {

	public String text;
	public GameString renderText;
	public JPanel panel;
	public int x;
	public int y;

	public GUITextField(int x, int y, Conveyor conveyor) {
		super(x, y, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE);
		renderText = new GameString("", 32, x, y);
		text = renderText.getText();
		this.x = x;
		this.y = y;
		conveyor.getGame().getFrame().addKeyListener(this);
	}

	@Override
	public void tick() {

		renderText.tick();

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.textArea, x, y, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, null);
		renderText.render(g);

	}

	@Override
	public void onClick() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (focused) {
			if (Assets.CHARACTERSTRING.contains(Character.toString(e.getKeyChar()))) {
				addChar(e.getKeyChar());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 8 || e.getKeyCode() == 127) {
			removeChar();
		}
	}

	public void addChar(char charTyped) {
		text += charTyped;
		renderText.setText(text);
	}
	
	public void removeChar() {
		StringBuilder sb = new StringBuilder(text);
		sb.deleteCharAt(text.length() - 1);
		text = sb.toString();
		renderText.setText(text);
	}

	public String getText() {
		return text;
	}

}
