package dev.ce.txt.scenes;

import java.awt.Graphics;
import java.io.File;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.GUIHandler;
import dev.ce.txt.gfx.gui.GUITextField;
import dev.ce.txt.gfx.gui.GameString;
import dev.ce.txt.scenes.subscenes.SubScene;

public class _PlayMenu extends SubScene {

	private File dir;
	private String files[];
	private int worldsLoaded;
	private _LoadWorld loadWorldScene;
	private _NewWorld newWorldScene;

	public _PlayMenu(Conveyor conveyor) {
		super(conveyor);

		loadWorldScene = new _LoadWorld(conveyor);
		newWorldScene = new _NewWorld(conveyor);
		
		conveyor.getMouseHandler().setGUIHandler(guiHandler);

		guiHandler.add(new GameString("PLAY/LOAD", 50, conveyor.getGameWidth() / 2 + 25 - Assets.DEFAULTRENDEREDSIZE * 4, 20));
		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 4 - Assets.DEFAULTRENDEREDSIZE * 4,
				conveyor.getGameHeight() / 2 - 100, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "LOAD WORLD", new ClickListener() {

					@Override
					public void onClick() {
						loadWorldScene.initializeWorlds("resources/worlds/");
						Scene.setSubScene(loadWorldScene);
					}

				}));
		guiHandler.add(new GUIButton(conveyor.getGameWidth() - 341 - Assets.DEFAULTRENDEREDSIZE * 4,
				conveyor.getGameHeight() / 2 - 100, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "Create World", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setSubScene(newWorldScene);
					}

				}));

		guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 525,
				Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "BACK",
				new ClickListener() {

					@Override
					public void onClick() {
						Scene.terminateSubScene();
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
	
	class _LoadWorld extends SubScene {

		public _LoadWorld(Conveyor conveyor) {
			super(conveyor);
			guiHandler = new GUIHandler(conveyor);
			
			guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 525,
					Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "BACK",
					new ClickListener() {

						@Override
						public void onClick() {
							Scene.setSubScene(conveyor.getGame().getPlayMenuScene());
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
		
		public void initializeWorlds(String path) {
			guiHandler.removeAll();
			dir = new File(path);
			files = dir.list();
			for (String file : files) {
				loadWorld(file);
				worldsLoaded++;
			}
		}
		
		public void loadWorld(String name) {
			String path = "resources/worlds/" + name;
			name = name.replaceAll(".lvl", "");
			guiHandler.add(new GUIButton(20, 20 + 20 * worldsLoaded + Assets.DEFAULTRENDEREDSIZE * worldsLoaded,
					Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, name, new ClickListener() {

						@Override
						public void onClick() {
							conveyor.getWorld().loadWorld(path);
							conveyor.getGameScene().setPaused(false);
							Scene.setScene(conveyor.getGameScene());
							Scene.terminateSubScene();
						}

					}));
		}
		
	}
	
	class _NewWorld extends SubScene {
		
		private GUITextField newWorldName = new GUITextField(20, 20, conveyor);
		
		public _NewWorld(Conveyor conveyor) {
			super(conveyor);
			
			guiHandler = new GUIHandler(conveyor);
			
			guiHandler.add(newWorldName);
			guiHandler.add(new GUIButton(conveyor.getGameWidth() / 2 - Assets.DEFAULTRENDEREDSIZE * 4, 40 + Assets.DEFAULTRENDEREDSIZE,
					Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Create World",
					new ClickListener() {

						@Override
						public void onClick() {
							conveyor.getWorld().newWorld(newWorldName.getText(), 100, 100, 3, 3);
							conveyor.getWorld().loadWorld("resources/worlds/" + newWorldName.getText() + ".lvl");
							Scene.setScene(conveyor.getGameScene());
							Scene.terminateSubScene();
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

}
