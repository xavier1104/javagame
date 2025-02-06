package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import object.Player;
import object.Animator.ANI_CLIP;

public class MoveState implements State {
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	private Player player;
	public MoveState(Player player, KeyEvent e) {
		// TODO Auto-generated constructor stub
		this.player = player;
		
		keyPressed(e);
	}

	@Override
	public void enterState() {
		player.getAnimator().setClip(ANI_CLIP.RUNNING);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		}
		
		if (!up && !down && !left && !right) {
			player.getStateMachine().setState(new IdleState(player));
		}
	}
	
	@Override
	public void update() {
		int offset = 1;
		if (up) {
			player.changeY(-offset);
		}
		
		if (down) {
			player.changeY(offset);
		}
		
		if (left) {
			player.changeX(-offset);
		}
		
		if (right) {
			player.changeX(offset);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(e.getButton()) {
		case MouseEvent.BUTTON1:
			player.getStateMachine().setState(new AttackState(player));
			break;
		}
	}
}
