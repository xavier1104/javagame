package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import input.KeyboardInputs;
import input.MouseInputs;
import object.MyRect;

public class GamePanel extends JPanel {
	private MouseInputs mouseInputs;
	private float xDelta = 100;
	private float yDelta = 100;
	
	private ArrayList<MyRect> rects = new ArrayList<MyRect>();
	
	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public void changeYDelta(float value) {
		this.yDelta += value;
		//repaint();
	}
	
	public void changeXDelta(float value) {
		this.xDelta += value;
		//repaint();
	}
	
	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y, this));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (MyRect rect : rects) {
			rect.updateRect();
			rect.draw(g);
		}
	}
}
