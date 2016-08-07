package dev.ce.txt;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import dev.ce.txt.assets.GlobalVariables;
import dev.ce.txt.gfx.ImageHandler;
import dev.ce.txt.gfx.SpriteSheet;
import dev.ce.txt.input.KeyHandler;

public class Game implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "txt";

	private JFrame frame;
	private Canvas canvas;

	public boolean running = false;
	public int tickCount = 0;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private KeyHandler keyHandler;
	private Thread thread;
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int frames;
	private int ticks;
	private boolean showFPS = true;

	public Game() {

		frame = new JFrame(NAME);
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		canvas.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		canvas.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setAlwaysOnTop(true);

	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;

	}
	
	public void init() {
		
		keyHandler = new KeyHandler();
		frame.addKeyListener(keyHandler);
		
	}

	public void run() {
		
		init();
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running = true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				this.ticks = ticks;
				this.frames = frames;
				frames = 0;
				ticks = 0;
			}
		}

	}

	public void tick() {
		tickCount++;

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i + tickCount;
		}
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		//test
		g.drawImage(new SpriteSheet(ImageHandler.loadImage("/textures/spritesheet.png")).getImage(0, 0), 100, 100, GlobalVariables.DEFAULTRENDEREDSIZE, GlobalVariables.DEFAULTRENDEREDSIZE, null);
		
		
		if(showFPS) {
			int x = 10;
			int y = 5;
			g.setColor(Color.YELLOW);
			g.drawString("FPS: " + frames, x, y + g.getFontMetrics().getHeight());
			g.drawString("TPS: " + ticks, x, y + g.getFontMetrics().getHeight() * 2);
		}

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
