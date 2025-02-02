package object;

import java.awt.Graphics;

import object.Animator.ANI_CLIP;

public class Player {
	Animator animator;
	int x = 0;
	int y = 0;
	boolean isMoving = false;
	
	public Player() {
		animator = new Animator("/player_sprites.png");
		animator.setClip(ANI_CLIP.IDLE);
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		animator.update();
	}
	
	public void draw(Graphics g) {
		animator.draw(g, x, y);
	}
	
	public void changeY(int value) {
		y += value;
	}
	
	public void changeX(int value) {
		x += value;
	}
	
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
		
		if (this.isMoving) {
			animator.setClip(ANI_CLIP.RUNNING);
		}
		else {
			animator.setClip(ANI_CLIP.IDLE);
		}
	}
}
