package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.World;
import dev.ce.txt.gfx.gui.Button;
import dev.ce.txt.gfx.gui.ClickListener;

public class _Game extends Scene {

	public World world;
	public boolean showGUI;
	public boolean paused = false;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		
		world = new World(conveyor);
		
		guiHandler.addObject(new Button(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(conveyor.getMenuScene());
					}

				}));
		
	}

	@Override
	public void tick() {
		
		if(!paused) {
			conveyor.getWorld().tick();
		}
		
		if(conveyor.getKeyHandler().pause) {
			togglePause();
		}
		
		if(showGUI) {
			guiHandler.tick();
		}
		
		if(paused) {
			showGUI = true;
		} else {
			showGUI = false;
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		conveyor.getWorld().render(g);
		
		if(showGUI) {
			guiHandler.render(g);
		}
		
	}
	
	public World getWorld() {
		return world;
	}
	
	public void togglePause() {
		paused = !paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

}
