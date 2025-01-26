package object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.GamePanel;

public class MyRect {
	int x;
	int y;
	int w;
	int h;
	private int xDir = 1;
	private int yDir = 1;
	private Random random;
	Color color;
	GamePanel gamePanel;
	
	public MyRect(int x, int y, GamePanel gamePanel) {
		this.x = x;
		this.y = y;
		random = new Random();
		w = random.nextInt(50);
		h = w;
		color = newColor();
		this.gamePanel = gamePanel;
	}
	
	public void updateRect() {
		this.x += xDir;
		this.y += yDir;
		
		if ((x + w) > gamePanel.getSize().width || x < 0) {
			xDir *= -1;
			color = newColor();
		}
		
		if ((y + h) > gamePanel.getSize().height || y < 0) {
			yDir *= -1;
			color = newColor();
		}
	}
	
	private Color newColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, w, h);
	}
}
