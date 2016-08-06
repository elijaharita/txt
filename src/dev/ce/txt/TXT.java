package dev.ce.txt;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class txt extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 637; 
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "txt";
	
	private JFrame frame;
	
	public boolean running = false;
	
	public txt() {
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		int ticks = 0;
		int frames = 0;
		
		double delta = 0;
		
		while(running = true){
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			while (delta >= 1){
				ticks++;
				tick();
				delta -= 1;
			}
			frames++;
			render();
			
			System.out.println(frames + ", " + ticks);
		}
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}
	
	public static void main(String[] args){
		new txt().start();
	}

}