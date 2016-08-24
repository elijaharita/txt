package dev.ce.txt.scenes;

import java.awt.Graphics;

import dev.ce.txt.Conveyor;
import dev.ce.txt.gfx.gui.GUIHandler;
import dev.ce.txt.scenes.subscenes.SubScene;

public abstract class Scene {

	protected static Conveyor conveyor;
	protected GUIHandler guiHandler;

	public static Scene currentScene;
	public static SubScene currentSubScene;

	@SuppressWarnings("static-access")
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

	public static SubScene getSubScene() {
		return currentSubScene;
	}

	public static void terminateSubScene() {
		setSubScene(null);
		conveyor.getMouseHandler().setGUIHandler(currentScene.getGUIHandler());
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public GUIHandler getGUIHandler() {
		return guiHandler;
	}

	public static void setSubScene(SubScene subScene) {
		currentSubScene = subScene;
		if (subScene != null) {
			conveyor.getMouseHandler().setGUIHandler(subScene.getGUIHandler());
		}
	}

}
