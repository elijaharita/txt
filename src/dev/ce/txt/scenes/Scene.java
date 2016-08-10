package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;

public abstract class Scene {

	protected Conveyor conveyor;
	
	public static Scene currentScene;
	
	public Scene(Conveyor conveyor) {
		this.conveyor = conveyor;
	}
	
	public static Scene getScene() {
		return currentScene;
	}
	
	public static void setScene(Scene scene) {
		currentScene = scene;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
