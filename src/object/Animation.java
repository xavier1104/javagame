package object;

import java.awt.Graphics;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.lang.constant.Constable;
import java.util.ArrayList;

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
	
	public Animation(Animator.ANI_CLIP clip, int len, BufferedImage img, int speed, int width, int heigh) {
		this.clip = clip;
		this.len = len;
		this.speed = speed;
		this.width = width;
		this.heigh = heigh;
		this.updatePerFrames = FPS / speed;
		anim = new ArrayList<BufferedImage>();
		
		for (int i = 0; i < len; ++i) {
			BufferedImage subimg = img.getSubimage(i * width, 0, width, heigh);
			anim.add(subimg);
		}
	}
	
	public void update() {
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
		g.drawImage(anim.get(currentIdx), x, y, width * 2, heigh * 2, null);
	}
}
