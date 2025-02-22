package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected Rectangle.Float hitbox;
	
	public Entity(float x, float y, float width, float height) {
		hitbox = new Rectangle.Float(x, y, width, height);
	}
	
	public void update() {

	}
	
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	
	public float getX() {
		return hitbox.x;
	}
	
	public void setX(float x) {
		hitbox.x = x;
	}
	
	public void setY(float y) {
		hitbox.y = y;
	}
	
	public float getY() {
		return hitbox.y;
	}
	
	public float getHeight() {
		return hitbox.height;
	}
	
	public float getWidth() {
		return hitbox.width;
	}
}
