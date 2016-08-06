package dev.ce.txt;

public class Game implements Runnable {
	
	public boolean running = false;
	Thread thread;
	TXT txt;
	int width, height;
	String title;
	
	public Game(int width, int height, String title) {
		
		this.width = width;
		this.height = height;
		this.title = title;
		
		start();
		
	}
	
	public synchronized void start() {
		
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}

	public synchronized void stop() {
		
		try {
			thread.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		running = false;
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double tpt = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			
			now = System.nanoTime();
			delta += (now - lastTime) / tpt;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				
				tick();
				render();
				ticks++;
				delta--;
				
			}
			
			if(timer >= 1000000000) {
				
				System.out.println(ticks + " ticks per second");
				ticks = 0;
				timer = 0;
				
			}
			
		}
		
		stop();
		
	}
	
	public void init() {
		
		txt = new TXT(width, height, title);
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
}
