package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import levels.*;
import object.Player;
import utils.HelpMethods;
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
		case KeyEvent.VK_SPACE :
			player.getStateMachine().setState(new JumpState(player, 0));
			break;
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
		Level level = LevelManager .getInstance().getLevel(); 
		if(!HelpMethods.IsEntityOnFloor(player, level.getData())) {
			player.getStateMachine().setState(new FallState(player, 0));
		}
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
