package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.GameString;
import dev.ce.txt.scenes.subscenes._Options;

public class _Menu extends Scene {

	private _Options optionsScene;
	private GameString title = new GameString(conveyor.getGameName(), 75, 0, 10);
	private GameString version = new GameString(conveyor.getGameVersion(), 15, 0, 85);
	
	public _Menu(Conveyor conveyor) {
		super(conveyor);

		optionsScene = new _Options(conveyor);
		conveyor.getMouseHandler().setGUIHandler(guiHandler);

		/*
		 * COPY AND PASTE BUTTON guiHandler.add(new
		 * GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE *
		 * 4, yCoord, Assets.DEFAULTRENDEREDSIZE * 8,
		 * Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "text1", "text2", new
		 * ClickListener() {
		 * 
		 * @Override public void onClick() { whathappenswhenclickedhere }
		 * 
		 * }));
		 * 
		 */
		title.centerX();
		version.centerX();
		guiHandler.add(title);
		guiHandler.add(version);

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 200,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Play",
				new ClickListener() {

					@Override
					public void onClick() {
						Scene.setSubScene(conveyor.getGame().getPlayMenuScene());
					}

				}));

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 275,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Options",
				new ClickListener() {

					@Override
					public void onClick() {
						Scene.setSubScene(optionsScene);
					}

				}));

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 525,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "quit",
				new ClickListener() {

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
