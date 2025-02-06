package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import object.Player;
import object.Animator.ANI_CLIP;

public class IdleState implements State {
	Player player;
	
	public IdleState(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W :
		case KeyEvent.VK_S : 
		case KeyEvent.VK_A : 
		case KeyEvent.VK_D :
			player.getStateMachine().setState(new MoveState(player, e));
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterState() {
		// TODO Auto-generated method stub
		player.getAnimator().setClip(ANI_CLIP.IDLE);
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
