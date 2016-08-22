package dev.ce.txt.scenes.subscenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.gfx.gui.GUIHandler;
import dev.ce.txt.scenes.Scene;

public abstract class SubScene extends Scene {

	public SubScene(Conveyor conveyor) {
		super(conveyor);
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void render(Graphics g);

}
