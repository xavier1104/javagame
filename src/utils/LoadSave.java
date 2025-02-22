package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.foreign.ValueLayout;

import javax.imageio.ImageIO;

import config.Global;

public class LoadSave {
	public static BufferedImage getSpriteAtlas(String filename) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
		
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
		
		return img;
	}
	
	public static int[][] getLevelData(){
		int[][] lvlData = new int[Global.TILES_IN_HEIGHT][Global.TILES_IN_WIDTH];
		BufferedImage img = getSpriteAtlas(Global.LEVEL_ONE_DATA);
		
		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				Color color = new Color(img.getRGB(x, y));
				int idx = color.getRed();
				if(idx >= 48) {
					idx = 0;
				}
				lvlData[y][x] = idx;
			}
		}
		
		return lvlData;
	}
}
