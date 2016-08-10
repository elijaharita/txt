package dev.ce.txt.scenes;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.ce.txt.Conveyor;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.gfx.gui.Button;
import dev.ce.txt.gfx.gui.ClickListener;
import dev.ce.txt.gfx.gui.GUIHandler;

public class _Menu extends Scene {
	
	public JButton play;
	public JFrame frame;

	public GUIHandler guiHandler;

	public _Menu(Conveyor conveyor) {
		super(conveyor);

		guiHandler = new GUIHandler(conveyor);
		System.out.println(guiHandler);
		conveyor.getMouseHandler().setGUIHandler(guiHandler);

		guiHandler.addObject(new Button(20, 20, Assets.DEFAULTRENDEREDSIZE * 8, Assets.DEFAULTRENDEREDSIZE,
				Assets.guiButton, new ClickListener() {

					@Override
					public void onClick() {
						conveyor.getWorld().loadWorld("resources/worlds/world1.lvl");
						Scene.setScene(conveyor.getGame().getGameScene());
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
		
		

		public _Options(Conveyor conveyor) {
			super(conveyor);
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			
		}
		
	}

}
