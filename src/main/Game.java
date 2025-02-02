package main;

import java.nio.file.FileSystemNotFoundException;

import static config.Global.*;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	
	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocusInWindow();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS;
		long lastFrame = System.nanoTime();
		
		long now = System.nanoTime();
		int frames = 0;
		
		long lastCheck = System.currentTimeMillis();
		
		while(true) {
			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				gamePanel.update();
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS:" + frames);
				frames = 0;
			}
		}
		
	}
}
