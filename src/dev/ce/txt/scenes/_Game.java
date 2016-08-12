package dev.ce.txt.scenes;

import java.awt.Color;
import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.World;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.ClickListener;

public class _Game extends Scene {

	public World world;
	public boolean showGUI;
	public boolean paused = false;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		
		world = new World(conveyor);
		
		guiHandler.add(new GUIButton(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "Quit to menu", new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getGameScene().getWorld().saveWorld();
						Scene.setScene(conveyor.getMenuScene());
					}

				}));
		
		guiHandler.add(new GUIButton(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "options", new ClickListener() {

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
		
		if(paused) {
			g.setColor(new Color(0, 0, 0, 127));
			g.fillRect(0, 0, conveyor.getGameWidth(), conveyor.getGameHeight());
		}
		
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
