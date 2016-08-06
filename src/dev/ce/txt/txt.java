package dev.ce.txt;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class txt {
	
	public int width = 768; 
	public int height = 512;
	public String title = "txt";
	
	private JFrame frame;
	public Canvas canvas;
	
	public boolean running = false;
	
	public txt(int width, int height, String title) {
		
		this.height = height;
		this.width = width;
		this.title = title;
		
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		
		frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}