package dev.ce.txt.scenes;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.Button;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIHandler;
import dev.ce.txt.gfx.gui.GameString;

public class _Menu extends Scene {
	
	public JButton play;
	public JFrame frame;
	
	private _Options optionsScene;

	public _Menu(Conveyor conveyor) {
		super(conveyor);
		
		conveyor.getMouseHandler().setGUIHandler(guiHandler);
		optionsScene = new _Options(conveyor);
		
		guiHandler.addObject(new Button(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, "hi",
				Assets.guiButton, new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getWorld().loadWorld("resources/worlds/world1.lvl");
						Scene.setScene(conveyor.getGame().getGameScene());
						conveyor.getGameScene().setPaused(false);
					}

				}));
		
		guiHandler.addObject(new Button(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, new ClickListener() {

					@Override
					public void onClick() {
						Scene.setScene(optionsScene);
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
		
		public _Options(Conveyor conveyor) {
			super(conveyor);
			guiHandler = new GUIHandler(conveyor);
			
			guiHandler.addObject(new Button(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, new ClickListener() {

				@Override
				public void onClick() {
					Assets.perBlockMovement = !Assets.perBlockMovement;
				}
				
			}));
			
			guiHandler.addObject(new Button(20, 40 + Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE, Assets.guiButton, new ClickListener() {

				@Override
				public void onClick() {
					Scene.setScene(conveyor.getMenuScene());
					conveyor.getMouseHandler().setGUIHandler(conveyor.getMenuScene().getGUIHandler());
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
