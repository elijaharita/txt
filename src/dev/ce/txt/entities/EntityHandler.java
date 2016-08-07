package dev.ce.txt.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class EntityHandler {

	List<Entity> entity;
	
	public EntityHandler() {
		
		entity = new ArrayList<Entity>();
		
	}
	
	public void tick() {
		
		for(Entity e : entity) {
			
			e.tick();
			
		}
		
	}
	
	public void render(Graphics g) {
		
		for(Entity e : entity) {
			
			e.render(g);
			
		}
		
	}
	
	public void addEntity(Entity e) {
		
		entity.add(e);
		
	}
	
}
