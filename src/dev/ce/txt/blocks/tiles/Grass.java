package dev.ce.txt.blocks.tiles;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;
import dev.ce.txt.blocks.Block;

public class Grass extends Block {
	
	public Grass(int id) {
		super(id);
	}

	@Override
	public BufferedImage texture() {
		return Assets.grass;
	}

}
