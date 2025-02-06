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
	private KeyboardInputs keyboardInputs;
	private World world;
	
	
	private ArrayList<MyRect> rects = new ArrayList<MyRect>();
	
	public GamePanel(World world) {
		this.world = world;
		mouseInputs = new MouseInputs(world);
		keyboardInputs = new KeyboardInputs(world);
		
		setPanelSize();
		addKeyListener(keyboardInputs);
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(640, 400);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y, this));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.render(g);
		
		
		for (MyRect rect : rects) {
			rect.updateRect();
			rect.draw(g);
		}
	}
}
