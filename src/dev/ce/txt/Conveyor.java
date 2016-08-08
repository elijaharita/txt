package dev.ce.txt;

import dev.ce.txt.gfx.World;
import dev.ce.txt.input.KeyHandler;

public class Conveyor {

	public Game game;
	
	public Conveyor(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public World getWorld() {
		return game.getWorld();
	}
	
	public KeyHandler getKeyHandler() {
		return game.getKeyHandler();
	}
	
}
