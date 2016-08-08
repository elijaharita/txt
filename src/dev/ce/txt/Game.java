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

import dev.ce.txt.assets.Assets;
import dev.ce.txt.entities.EntityHandler;
import dev.ce.txt.entities.Frownie;
import dev.ce.txt.entities.Player;
import dev.ce.txt.gfx.World;
import dev.ce.txt.input.KeyHandler;

public class Game implements Runnable {

	public static final String NAME = "txt";

	public static final int SCALE = 3;
	public static final int WIDTH = 420 * SCALE;
	public static final int HEIGHT = WIDTH / 16 * 9;
	
	private JFrame frame;
	private Canvas canvas;
	private EntityHandler entityHandler;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private KeyHandler keyHandler;
	private World world;

	public boolean running = false;
	public int tickCount = 0;
	
	private Thread thread;
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int frames;
	private boolean showFPS = true;

	public Game() {

		frame = new JFrame(NAME);
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(WIDTH, HEIGHT);

		frame.add(canvas, BorderLayout.CENTER);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocus();

	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void init() {
		
		Assets.init();
		
		keyHandler = new KeyHandler();
		frame.addKeyListener(keyHandler);
		entityHandler = new EntityHandler();
		
		world = new World("resources/worlds/world1.lvl");
		
		for(int i = 0; i < 10; i++) {
			entityHandler.addEntity(new Frownie(WIDTH / 2, HEIGHT / 2, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE));
		}
		
		entityHandler.addEntity(new Player(0, 0, Assets.DEFAULTRENDEREDSIZE, Assets.DEFAULTRENDEREDSIZE, keyHandler));
		
	}

	public void run() {
		
		init();
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running = true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			while (delta >= 1) {
				frames++;
				tick();
				render();
				delta -= 1;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				this.frames = frames;
				frames = 0;
			}
		}

	}

	public void tick() {
		
		showFPS = keyHandler.stats;
		
		tickCount++;

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i / 7 + tickCount;
		}
		
		keyHandler.tick();
		//world.tick();
		entityHandler.tick();
		
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		world.render(g);
		entityHandler.render(g);
		
		if(showFPS) {
			int x = 10;
			int y = 5;
			g.setColor(Color.WHITE);
			g.drawString("FPS: " + frames, x, y + g.getFontMetrics().getHeight());
		}

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
