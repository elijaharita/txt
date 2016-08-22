package dev.ce.txt.blocks;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class Cobblestone extends Block{

	public Cobblestone(int id) {
		super(id);
	}

	@Override
	public BufferedImage texture() {
		return Assets.cobblestone;
	}

}
