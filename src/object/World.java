package object;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	private ArrayList<Entity> entities;
	private Player player;
	
	public World() {
		// TODO Auto-generated constructor stub
		entities = new ArrayList<Entity>();
		
		player = new Player(0, 0);
		entities.add(player);
	}
	
	public void update() {
		for (Entity entity : entities) {
			entity.update();
		}
	}
	
	public void render(Graphics g) {
		for (Entity entity : entities) {
			entity.render(g);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
