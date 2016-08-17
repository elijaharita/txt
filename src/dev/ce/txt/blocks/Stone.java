package dev.ce.txt.blocks;

import java.awt.image.BufferedImage;

import dev.ce.txt.assets.Assets;

public class Stone extends Block{

	public Stone(int id) {
		super(id);
	}

	@Override
	public BufferedImage texture() {
		return Assets.stone;
	}

}
