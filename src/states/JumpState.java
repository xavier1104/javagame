package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import config.Global;
import levels.Level;
import levels.LevelManager;
import object.Animator.ANI_CLIP;
import utils.HelpMethods;
import object.Player;

public class JumpState implements State {
	private Player player;
	private float xDir;
	public JumpState(Player player, float xDir) {
		// TODO Auto-generated constructor stub
		this.player = player;
		this.xDir = xDir;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		updateXPos();
		updateYPos();
		
		if(player.getAirSpeed() > 0) {
			player.getStateMachine().setState(new FallState(player, xDir));
		}
		else {
			float airSpeed = player.getAirSpeed() + Global.GRAVIRY;
			player.setAirSpeed(airSpeed);
		}
	}

	private void updateXPos() {
		Level level = LevelManager.getInstance().getLevel();
		float xSpeed = xDir * player.getMoveSpeed();
		float xPos = player.getX() + xSpeed;
		float yPos = player.getY();
		if (HelpMethods.CanMoveHere(xPos, yPos, player.getWidth(), player.getHeight(), level.getData())) {
			player.setX(xPos);
		}
		else {
			xPos = HelpMethods.GetEntityXPosNextToWall(player, xSpeed);
			player.setX(xPos);
		}
	}
	
	private void updateYPos() {
		Level level = LevelManager.getInstance().getLevel();
		float ySpeed = player.getAirSpeed();
		float xPos = player.getX();
		float yPos = player.getY() + ySpeed;
		if (HelpMethods.CanMoveHere(xPos, yPos, player.getWidth(), player.getHeight(), level.getData())) {
			player.setY(yPos);
		}
		else {
			yPos = HelpMethods.GetEntityYPosUnderRoofOrAboveFloor(player, ySpeed);
			player.setY(yPos);
		}
	}
	
	@Override
	public void enterState() {
		// TODO Auto-generated method stub
		player.setAirSpeed(player.getJumpSpeed());
		player.getAnimator().setClip(ANI_CLIP.JUMP);
	}
}
