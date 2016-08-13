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
import dev.ce.txt.gfx.World;
import dev.ce.txt.input.KeyHandler;
import dev.ce.txt.input.MouseHandler;
import dev.ce.txt.scenes.Scene;
import dev.ce.txt.scenes._Game;
import dev.ce.txt.scenes._Menu;
import dev.ce.txt.scenes._Options;
import dev.ce.txt.scenes._PlayMenu;

public class Game implements Runnable {

	public static final String NAME = "txt";

	public _Game gameScene;
	public _Menu menuScene;
	public _Options optionsScene;
	public _PlayMenu playMenuScene;
	
	public int scale = 1;
	public int width = 1366;
	public int height = 768;
	
	public JFrame frame;
	public Canvas canvas;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private World world;

	public boolean running = false;
	public int tickCount = 0;
	public Conveyor conveyor;
	public KeyHandler keyHandler;
	public MouseHandler mouseHandler;
	
	private Thread thread;
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int frames;
	private boolean showFPS = true;

	public Game() {

		frame = new JFrame(NAME);
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(width, height);

		frame.add(canvas, BorderLayout.CENTER);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.requestFocus();
		frame.pack();
		frame.setVisible(true);

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
		
		conveyor = new Conveyor(this);
		
		Assets.init();
		
		keyHandler = new KeyHandler();
		mouseHandler = new MouseHandler();
		frame.addKeyListener(keyHandler);
		frame.addMouseListener(mouseHandler);
		frame.addMouseMotionListener(mouseHandler);
		canvas.addMouseMotionListener(mouseHandler);
		canvas.addMouseListener(mouseHandler);
		
		gameScene = new _Game(conveyor);
		menuScene = new _Menu(conveyor);
		optionsScene = new _Options(conveyor);
		playMenuScene = new _PlayMenu(conveyor);
		
		Scene.setScene(menuScene);
		
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
		Scene.getScene().tick();
		
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, width, height);
		//g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		Scene.getScene().render(g);
		
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
		Game game = new Game();
		game.start();
	}
	
	public World getWorld() {
		return world;
	}

	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public _Game getGameScene() {
		return gameScene;
	}
	
	public void setGameScene(_Game gameScene) {
		this.gameScene = gameScene;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public MouseHandler getMouseHandler() {
		return mouseHandler;
	}

	public _Menu getMenuScene() {
		return menuScene;
	}
	
	public _Options getOptionsScene() {
		return optionsScene;
	}
	
	public _PlayMenu getPlayMenuScene(){
		return playMenuScene;
	}
	

}
