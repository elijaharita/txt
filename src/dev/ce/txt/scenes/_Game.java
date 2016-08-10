package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.gfx.World;

public class _Game extends Scene {

	public World world;
	public boolean paused = false;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		
		world = new World(conveyor);
	}

	@Override
	public void tick() {
		
		if(!paused) {
			conveyor.getWorld().tick();
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		conveyor.getWorld().render(g);
		
	}
	
	public World getWorld() {
		return world;
	}

}
