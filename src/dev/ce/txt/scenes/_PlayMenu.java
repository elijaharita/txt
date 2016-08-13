package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.GameString;

public class _PlayMenu extends Scene{

	public _PlayMenu(Conveyor conveyor) {
		super(conveyor);
		
		conveyor.getMouseHandler().setGUIHandler(guiHandler);
		
		guiHandler.add(new GameString("PLAY/LOAD", 50, conveyor.getGameWidth() / 2 + 25 - Assets.DEFAULTRENDEREDSIZE * 4, 20));
		
		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 4  - Assets.DEFAULTRENDEREDSIZE * 4, conveyor.getGameHeight() / 2 - 100,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "temp loadworld", new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getWorld().loadWorld("resources/worlds/world1.lvl");
						Scene.setScene(conveyor.getGame().getGameScene());
						conveyor.getGameScene().setPaused(false);
					}

				}));
		
		guiHandler.add(new GUIButton(conveyor.getGameWidth() - 341 - Assets.DEFAULTRENDEREDSIZE * 4, conveyor.getGameHeight() / 2 - 100,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Create World", "YEET", new ClickListener() {

					@Override
					public void onClick() {
						System.out.println("not done yet :^)");
					}

				}));
		
		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 525 ,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "BACK", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(conveyor.getGame().getMenuScene());
					}

				}));
		

	}

	@Override
	public void tick() {
		guiHandler.tick();
		
	}

	@Override
	public void render(Graphics g) {
		guiHandler.render(g);
	}

}
