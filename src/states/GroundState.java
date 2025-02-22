package states;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import object.Player;
import object.Animator.ANI_CLIP;

public class GroundState implements State {
	private Player player;
	
	public GroundState(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
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
		if (player.getAnimator().getAnimation().isFinish()) {
			player.getStateMachine().setState(new IdleState(player));
		}
	}

	@Override
	public void enterState() {
		// TODO Auto-generated method stub
		player.setAirSpeed(0);
		player.getAnimator().setClip(ANI_CLIP.GROUND);
	}
}
