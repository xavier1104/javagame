package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;



public class Animator {
	public enum ANI_CLIP{
		IDLE,
		RUNNING,
		JUMP,
		FALLING,
		GROUND,
		HIT,
		ATTACK_1,
		ATTACK_JUMP_1,
		ATTACK_JUMP_2
	}
	
	BufferedImage img;
	HashMap<ANI_CLIP, Animation> anims;
	
	ANI_CLIP currentAni;
	
	public Animator(String fileName) {
		InputStream is = getClass().getResourceAsStream(fileName);
		
		try {
			img = ImageIO.read(is);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		anims = new HashMap<Animator.ANI_CLIP, Animation>();
		BufferedImage subImg = img.getSubimage(0, 0, 64 * 5, 40);
		anims.put(ANI_CLIP.IDLE, new Animation(ANI_CLIP.IDLE, 5, subImg, 8, 64, 40, true));
		subImg = img.getSubimage(0, 1 * 40, 64 * 6, 40);
		anims.put(ANI_CLIP.RUNNING, new Animation(ANI_CLIP.RUNNING, 6, subImg, 5, 64, 40, true));
		subImg = img.getSubimage(0, 2 * 40, 64 * 3, 40);
		anims.put(ANI_CLIP.JUMP, new Animation(ANI_CLIP.JUMP, 3, subImg, 5, 64, 40, false));
		subImg = img.getSubimage(0, 3 * 40, 64 * 1, 40);
		anims.put(ANI_CLIP.FALLING, new Animation(ANI_CLIP.FALLING, 1, subImg, 5, 64, 40, true));
		subImg = img.getSubimage(0, 4 * 40, 64 * 2, 40);
		anims.put(ANI_CLIP.GROUND, new Animation(ANI_CLIP.GROUND, 2, subImg, 5, 64, 40, false));
		subImg = img.getSubimage(0, 5 * 40, 64 * 4, 40);
		anims.put(ANI_CLIP.HIT, new Animation(ANI_CLIP.HIT, 4, subImg, 5, 64, 40, false));
		subImg = img.getSubimage(0, 6 * 40, 64 * 3, 40);
		anims.put(ANI_CLIP.ATTACK_1, new Animation(ANI_CLIP.ATTACK_1, 3, subImg, 5, 64, 40, false));
		subImg = img.getSubimage(0, 7 * 40, 64 * 3, 40);
		anims.put(ANI_CLIP.ATTACK_JUMP_1, new Animation(ANI_CLIP.ATTACK_JUMP_1, 3, subImg, 5, 64, 40, false));
		subImg = img.getSubimage(0, 8 * 40, 64 * 3, 40);
		anims.put(ANI_CLIP.ATTACK_JUMP_2, new Animation(ANI_CLIP.ATTACK_JUMP_2, 3, subImg, 5, 64, 40, false));
		
		currentAni = ANI_CLIP.IDLE;
	}
	
	public void setClip(ANI_CLIP clip) {
		currentAni = clip;
		anims.get(currentAni).reset();
	}
	
	public void update() {
		anims.get(currentAni).update();
	}
	
	public void draw(Graphics g, int x, int y) {
		anims.get(currentAni).draw(g, x, y);
	}
	
	public Animation getAnimation() {
		return anims.get(currentAni);
	}
}
