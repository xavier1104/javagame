package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

import object.*;

public class KeyboardInputs implements KeyListener {
	private Player player;
	
	public KeyboardInputs(Player player) {
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int offset = 5;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setMoving(true);
			player.changeY(-offset);
			break;
		case KeyEvent.VK_S:
			player.setMoving(true);
			player.changeY(offset);
			break;
		case KeyEvent.VK_A:
			player.setMoving(true);
			player.changeX(-offset);
			break;
		case KeyEvent.VK_D:
			player.setMoving(true);
			player.changeX(offset);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
			player.setMoving(false);
			break;
		}
	}
}
