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
		text = "";
		renderText = new GameString("", 32, 100, 100);
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
			addChar(e.getKeyChar());
		}
		System.out.println(focused);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public void addChar(char charTyped) {
		text += charTyped;
		renderText.setText(text);
		System.out.println(text);
	}

	public String getText() {
		return text;
	}

}
