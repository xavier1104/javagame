package object;

import java.awt.Graphics;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.lang.constant.Constable;
import java.lang.foreign.ValueLayout.OfBoolean;
import java.util.ArrayList;

import config.Global;

import static config.Global.*;
import object.Animator.ANI_CLIP;

public class Animation {
	Animator.ANI_CLIP clip;
	ArrayList<BufferedImage> anim;
	int currentIdx = 0;
	int len = 0;
	int speed = 0;
	int width = 0;
	int heigh = 0;
	int tick = 0;
	int updatePerFrames = 0;
	boolean isLoop = false;
	
	public Animation(Animator.ANI_CLIP clip, int len, BufferedImage img, int speed, int width, int heigh, boolean isLoop) {
		this.clip = clip;
		this.len = len;
		this.speed = speed;
		this.width = width;
		this.heigh = heigh;
		this.updatePerFrames = FPS / speed;
		this.isLoop = isLoop;
		anim = new ArrayList<BufferedImage>();
		
		for (int i = 0; i < len; ++i) {
			BufferedImage subimg = img.getSubimage(i * width, 0, width, heigh);
			anim.add(subimg);
		}
	}
	
	public void update() {
		if (isFinish()) {
			return;
		}
		
		tick++;
		if (tick == updatePerFrames) {
			tick = 0;
			
			next();
		}
	}
	
	private void next() {
		currentIdx = (currentIdx + 1) % len;
	}
	
	public void draw(Graphics g, int x, int y) {
		g.drawImage(anim.get(currentIdx), x, y, (int)(width * Global.SCALE), (int)(heigh * Global.SCALE), null);
	}
	
	public int getCurrentIdx() {
		return currentIdx;
	}
	
	public boolean isFinish() {
		if(isLoop) {
			return false;
		}
		
		if(currentIdx + 1 < len) {
			return false;
		}
		
		return true;
	}
	
	public void reset() {
		currentIdx = 0;
		tick = 0;
	}
}
