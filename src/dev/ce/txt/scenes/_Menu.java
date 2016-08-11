package dev.ce.txt.scenes;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.GUIButton;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIHandler;

public class _Menu extends Scene {

	public JButton play;
	public JFrame frame;

	private _Options optionsScene;

	public _Menu(Conveyor conveyor) {
		super(conveyor);

		conveyor.getMouseHandler().setGUIHandler(guiHandler);
		optionsScene = new _Options(conveyor);

		guiHandler.addObject(new GUIButton(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, "Play", new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getWorld().loadWorld("resources/worlds/world1.lvl");
						Scene.setScene(conveyor.getGame().getGameScene());
						conveyor.getGameScene().setPaused(false);
					}

				}));

		guiHandler.addObject(new GUIButton(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8,
				Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "Options", new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(optionsScene);
					}

				}));
		
		guiHandler.addObject(new GUIButton(20, 60 + Assets.DEFAULTRENDEREDSIZE * 2, Assets.DEFAULTRENDEREDSIZE * 8,
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

	class _Options extends Scene {

		public GUIHandler guiHandler;

		private boolean perBlockMovement;

		public _Options(Conveyor conveyor) {
			super(conveyor);
			guiHandler = new GUIHandler(conveyor);

			guiHandler.addObject(new GUIButton(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
					Assets.guiButton, "Blocky Movement", "Smooth Movement", new ClickListener() {

						@Override
						public void onClick() {
							Assets.perBlockMovement = !Assets.perBlockMovement;
							perBlockMovement = !perBlockMovement;
						}

					}));

			guiHandler.addObject(new GUIButton(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8,
					Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, "back", new ClickListener() {

						@Override
						public void onClick() {
							conveyor.getMouseHandler().setGUIHandler(conveyor.getMenuScene().getGUIHandler());
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

}
