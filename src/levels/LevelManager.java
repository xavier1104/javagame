package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.print.attribute.standard.MediaSize.Other;

import config.Global;
import main.Game;
import utils.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	private static LevelManager instance;
	
	private LevelManager() {
		importOutsideSprites();
		levelOne = new Level(LoadSave.getLevelData());
	}
	
	public static LevelManager getInstance() {
		if (instance == null) {
			instance = new LevelManager();
		}
		
		return instance;
	}
	
	public Level getLevel() {
		return levelOne;
	}
	
	private void importOutsideSprites() {
		BufferedImage img = LoadSave.getSpriteAtlas(Global.OUTSIDE_ATLAS);
		levelSprite = new BufferedImage[48];
		int tileSize = Global.TILES_DEFAULT_SIZE;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 12; ++i) {
				int index = j * 12 + i;
				levelSprite[index] = img.getSubimage(i * tileSize, j * tileSize, tileSize, tileSize);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int j = 0; j < Global.TILES_IN_HEIGHT; j++) {
			for(int i = 0; i < Global.TILES_IN_WIDTH; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Global.TILES_SIZE * i, Global.TILES_SIZE * j, Global.TILES_SIZE, Global.TILES_SIZE, null);
			}
		}
	}
}
