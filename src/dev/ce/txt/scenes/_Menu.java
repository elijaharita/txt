package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.GameString;

public class _Menu extends Scene {

	public _Menu(Conveyor conveyor) {
		super(conveyor);

		conveyor.getMouseHandler().setGUIHandler(guiHandler);
		
		/* COPY AND PASTE BUTTON
		 * guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, yCoord,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "text1",
				"text2", new ClickListener() {

					@Override
					public void onClick() {
						whathappenswhenclickedhere
					}

				}));
		 * 
		 */
		
		guiHandler.add(new  GameString("txt", 75, conveyor.getGameWidth() / 2 - 115, 10));
		guiHandler.add(new  GameString("v0.12", 20, conveyor.getGameWidth() / 2 - 50, 85));

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 200, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Play", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(conveyor.getGame().getPlayMenuScene());
					}

				}));

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 275, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Options", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(conveyor.getGame().getOptionsScene());
					}

				}));
		
		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 525, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "quit", new ClickListener() {

					@Override
					public void onClick() {
						System.exit(0);
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
