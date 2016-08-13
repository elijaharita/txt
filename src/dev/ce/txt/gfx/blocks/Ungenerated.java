package dev.ce.txt.gfx.blocks;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class Ungenerated extends Block {

	public Ungenerated(int id) {
		super(id);
	}

	@Override
	public BufferedImage texture() {
		return Assets.ungenerated;
	}

}
