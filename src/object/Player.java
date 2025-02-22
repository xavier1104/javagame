package object;

import java.awt.Graphics;

import config.Global;
import object.Animator.ANI_CLIP;
import states.StateMachine;

public class Player extends Entity {
	Animator animator;
	StateMachine stateMachine;
	float moveSpeed = 2;
	float xDrawOffset = 21 * Global.SCALE;
	float yDrawOffset = 4 * Global.SCALE;
	
	public Player(float x, float y) {
		super(x, y, (20 * Global.SCALE), (28 * Global.SCALE));
		animator = new Animator(Global.PLAYER_ATLAS);
		stateMachine = new StateMachine(this);
	}
	
	public void setPos(float x, float y) {
		setX(x);
		setY(y);
	}
	
	@Override
	public void update() {
		super.update();
		stateMachine.update();
		animator.update();
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		animator.draw(g, (int)(getX() - xDrawOffset), (int)(getY() - yDrawOffset));
	}
	
	public void changeY(int value) {
		setY((int)(getY() + value));
	}
	
	public void changeX(int value) {
		setX((int)(getX() + value));
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}
	
	public Animator getAnimator() {
		return animator;
	}
	
	public float getMoveSpeed() {
		return moveSpeed;
	}
}
