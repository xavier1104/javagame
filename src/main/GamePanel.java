package main;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.LoaderHandler;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import input.KeyboardInputs;
import input.MouseInputs;
import object.*;

public class GamePanel extends JPanel {
	private MouseInputs mouseInputs;
	private Player player;
	
	
	private ArrayList<MyRect> rects = new ArrayList<MyRect>();
	
	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		player = new Player();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(player));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void setPosition(int x, int y) {
		player.setPos(x, y);
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(640, 400);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}
	
	public void changeYDelta(int value) {
		player.setMoving(true);
		player.changeY(value);
		//repaint();
	}
	
	public void changeXDelta(int value) {
		player.setMoving(true);
		player.changeX(value);
		//repaint();
	}
	
	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y, this));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		
		
		for (MyRect rect : rects) {
			rect.updateRect();
			rect.draw(g);
		}
	}
	
	public void update() {
		player.update();
	}
}
