package dev.ce.txt.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler {

	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ImageHandler.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
