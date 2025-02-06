package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

import object.*;

public class KeyboardInputs implements KeyListener {
	private Player player;
	
	public KeyboardInputs(World world) {
		this.player = world.getPlayer();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		player.getStateMachine().getState().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		player.getStateMachine().getState().keyReleased(e);
	}
}
