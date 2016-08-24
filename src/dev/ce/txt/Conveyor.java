package dev.ce.txt;

import dev.ce.txt.gfx.Camera;
import dev.ce.txt.input.KeyHandler;
import dev.ce.txt.input.MouseHandler;
import dev.ce.txt.scenes._Game;
import dev.ce.txt.scenes._Menu;
import dev.ce.txt.world.World;

public class Conveyor {

	public Game game;
	
	public Conveyor(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public World getWorld() {
		return game.getGameScene().getWorld();
	}
	
	public KeyHandler getKeyHandler() {
		return game.getKeyHandler();
	}
	
	public int getGameWidth() {
		return game.getWidth();
	}
	
	public int getGameHeight() {
		return game.getHeight();
	}
	
	public Camera getCamera() {
		return game.getGameScene().getWorld().getCamera();
	}

	public MouseHandler getMouseHandler() {
		return game.getMouseHandler();
	}
	
	public _Game getGameScene() {
		return game.getGameScene();
	}
	
	public _Menu getMenuScene() {
		return game.getMenuScene();
	}
	
	public String getGameName(){
		return Game.getGameName();
	}

	public String getGameVersion() {
		return Game.getGameVersion();
	}
	
}
