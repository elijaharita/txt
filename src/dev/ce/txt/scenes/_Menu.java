package dev.ce.txt.scenes;

import java.awt.Graphics;
import java.io.File;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.GUIContainer;
import dev.ce.txt.gfx.gui.GUIHandler;

public class _Menu extends Scene {

	public GUIContainer container;

	private _Options optionsScene;
	private _TexturePack texturePackScene;

	public _Menu(Conveyor conveyor) {
		super(conveyor);

		conveyor.getMouseHandler().setGUIHandler(guiHandler);
		optionsScene = new _Options(conveyor);
		texturePackScene = new _TexturePack(conveyor);

		guiHandler.add(new GUIButton(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "Play", new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getWorld().loadWorld("resources/worlds/world1.lvl");
						Scene.setScene(conveyor.getGame().getGameScene());
						conveyor.getGameScene().setPaused(false);
					}

				}));

		guiHandler.add(new GUIButton(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Options", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(optionsScene);
					}

				}));
		
		guiHandler.add(new GUIButton(20, 60 + Assets.DEFAULTRENDEREDSIZE * 2, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "quit", new ClickListener() {

					@Override
					public void onClick() {
						System.exit(0);
					}

				}));
		
		guiHandler.add(new GUIButton(20, 80 + Assets.DEFAULTRENDEREDSIZE * 3, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "texture packs", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(texturePackScene);
						
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

	class _Options extends Scene {

		public GUIHandler guiHandler;

		private boolean perBlockMovement;

		public _Options(Conveyor conveyor) {
			super(conveyor);
			guiHandler = new GUIHandler(conveyor);

			guiHandler.add(new GUIButton(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
					Assets.guiButton, "Blocky Movement", "Smooth Movement", new ClickListener() {

						@Override
						public void onClick() {
							Assets.perBlockMovement = !Assets.perBlockMovement;
							perBlockMovement = !perBlockMovement;
						}

					}));

			guiHandler.add(new GUIButton(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8,
					Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "back", new ClickListener() {

						@Override
						public void onClick() {
							Scene.setScene(conveyor.getMenuScene());
							
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

		public GUIHandler getGUIHandler() {
			return guiHandler;
		}

	}
	
	class _TexturePack extends Scene {

		public GUIHandler guiHandler;
		private int texturePacksLoaded;
		private String[] files;
		private File dir;
		
		public _TexturePack(Conveyor conveyor) {
			super(conveyor);
			
			guiHandler = new GUIHandler(conveyor);
			
			guiHandler.add(new GUIButton(40 + Assets.DEFAULTRENDEREDSIZE * 8, 20 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8,
					Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "back", new ClickListener() {

						@Override
						public void onClick() {
							Scene.setScene(conveyor.getMenuScene());
							
						}

					}));
			
			initializeTexturePacks("resources/textures/");
			
		}
		
		public void initializeTexturePacks(String path) {
			dir = new File(path);
			files = dir.list();
			for(String file : files) {
				System.out.println(file);
				loadTexturePack(file);
				texturePacksLoaded++;
			}
			
		}
		
		public void loadTexturePack(String path) {
			
			guiHandler.add(new GUIButton(20, 20 + 20 * texturePacksLoaded + Assets.DEFAULTRENDEREDSIZE * texturePacksLoaded, Assets.DEFAULTRENDEREDSIZE * 8,
					Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, path, new ClickListener() {

				@Override
				public void onClick() {
					Assets.setTexturePack(path);
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
		
		public GUIHandler getGUIHandler() {
			return guiHandler;
		}
		
	}

}
