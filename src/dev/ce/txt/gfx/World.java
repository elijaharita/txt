package dev.ce.txt.gfx;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.Util;
import dev.ce.txt.assets.Assets;
import dev.ce.txt.entities.EntityHandler;
import dev.ce.txt.gfx.blocks.Block;

public class World {
	
	private int blocks[][];
	
	public Conveyor conveyor;
	
	public int xOffset = 0;
	public int yOffset = 0;
	public int width;
	public int height;
	public int spawnX;
	public int spawnY;
	
	private EntityHandler entityHandler;
	
	public World(String worldPath, Conveyor conveyor) {
		
		this.conveyor = conveyor;
		
		loadWorld(worldPath);
		entityHandler = new EntityHandler();
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for (int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				getBlock(x, y).render(g, x * Assets.DEFAULTRENDEREDSIZE, y * Assets.DEFAULTRENDEREDSIZE);
			}
		}
	}
	
	public Block getBlock(int x, int y) {
		
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Block.grass;
		}
		
		Block block = Block.blocks[blocks[x][y]];
		
		if(block == null) {
			return Block.grass;
		}
		
		return block;
		
	}
	
	public void loadWorld(String worldPath) {
		
		String worldString = Util.loadFile(worldPath);
		String[] tokens = worldString.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		blocks = new int[width][height];
		
		for (int x = 0; x < width; x++) {
			
			for(int y = 0; y < height; y++) {
				
				blocks[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
				
			}
			
		}
		
		//entityHandler.addEntity(new Player(spawnX * Assets.DEFAULTRENDEREDSIZE, spawnY * Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, ));
		
	}
	
}
