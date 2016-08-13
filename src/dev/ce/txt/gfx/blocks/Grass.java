package dev.ce.txt.gfx.blocks;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class Grass extends Block {
	
	public Grass(int id) {
		super(id);
	}

	@Override
	public BufferedImage texture() {
		return Assets.grass;
	}

}
