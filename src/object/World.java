package object;

import java.awt.Graphics;
import java.util.ArrayList;

import levels.LevelManager;

public class World {
	private ArrayList<Entity> entities;
	private Player player;
	private LevelManager levelManager;
	
	public World() {
		// TODO Auto-generated constructor stub
		entities = new ArrayList<Entity>();
		player = new Player(200, 200);
		entities.add(player);
	}
	
	public void update() {
		for (Entity entity : entities) {
			entity.update();
		}
	}
	
	public void render(Graphics g) {
		LevelManager.getInstance().draw(g);
		for (Entity entity : entities) {
			entity.render(g);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
