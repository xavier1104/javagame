package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import config.Global;
import object.Player;
import levels.*;
import utils.HelpMethods;
import object.Animator.ANI_CLIP;

public class FallState implements State {
	private Player player;
	private float xDir;
	
	public FallState(Player player, float xDir) {
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
		
		Level level = LevelManager .getInstance().getLevel();
		
		if(HelpMethods.IsEntityOnFloor(player, level.getData())) {
			player.getStateMachine().setState(new GroundState(player));
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
		player.getAnimator().setClip(ANI_CLIP.FALLING);
	}
}
