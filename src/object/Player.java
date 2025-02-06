package object;

import java.awt.Graphics;

import object.Animator.ANI_CLIP;
import states.StateMachine;

public class Player extends Entity {
	Animator animator;
	StateMachine stateMachine;
	boolean isMoving = false;
	
	public Player(int x, int y) {
		super(x, y);
		animator = new Animator("/player_sprites.png");
		
		stateMachine = new StateMachine(this);
		
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update() {
		stateMachine.update();
		animator.update();
	}
	
	@Override
	public void render(Graphics g) {
		animator.draw(g, x, y);
	}
	
	public void changeY(int value) {
		y += value;
	}
	
	public void changeX(int value) {
		x += value;
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}
	
	public Animator getAnimator() {
		return animator;
	}
}
