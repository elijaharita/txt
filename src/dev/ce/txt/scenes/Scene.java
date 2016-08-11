package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.gfx.gui.GUIHandler;

public abstract class Scene {

	protected static Conveyor conveyor;
	protected GUIHandler guiHandler;
	
	public static Scene currentScene;
	
	public Scene(Conveyor conveyor) {
		this.conveyor = conveyor;
		guiHandler = new GUIHandler(conveyor);
	}
	
	public static Scene getScene() {
		return currentScene;
	}
	
	public static void setScene(Scene scene) {
		currentScene = scene;
		conveyor.getMouseHandler().setGUIHandler(scene.getGUIHandler());
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public GUIHandler getGUIHandler() {
		return guiHandler;
	}
	
}
