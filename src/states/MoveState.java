package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import levels.*;
import object.Player;
import utils.HelpMethods;
import object.Animator.ANI_CLIP;

public class MoveState implements State {
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
		case KeyEvent.VK_SPACE:
			player.getStateMachine().setState(new JumpState(player, getXDir()));
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		}
	}

	private float getXDir() {
		float xDir = 0;
		if(left) {
			xDir = -1;
		}
		
		if (right) {
			xDir = 1;
		}
		
		return xDir;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		}
		
		if (!left && !right) {
			player.getStateMachine().setState(new IdleState(player));
		}
	}
	
	@Override
	public void update() {
		updateXPos();
		
		Level level = LevelManager.getInstance().getLevel();
		if(!HelpMethods.IsEntityOnFloor(player, level.getData())) {
			player.getStateMachine().setState(new FallState(player, getXDir()));
		}
	}
	
	private void updateXPos() {
		float xOffset = 0;
		
		if (left) {
			xOffset = -1 * player.getMoveSpeed();
		}
		
		if (right) {
			xOffset = 1 * player.getMoveSpeed();
		}
		
		Level level = LevelManager.getInstance().getLevel();
		float xPos = player.getX() + xOffset;
		float yPos = player.getY();
		if (HelpMethods.CanMoveHere(xPos, yPos, player.getWidth(), player.getHeight(), level.getData())) {
			player.setPos(xPos, yPos);
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
