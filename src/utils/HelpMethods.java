package utils;

import config.Global;

public class HelpMethods {
	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
		if (IsSolid(x, y, lvlData)) {
			return false;
		}
		
		if (IsSolid(x + width, y, lvlData)) {
			return false;
		}
		
		if (IsSolid(x, y + height, lvlData)) {
			return false;
		}
		
		if (IsSolid(x + width, y + height, lvlData)) {
			return false;
		}
		
		return true;
	}
	
	private static boolean IsSolid(float x, float y, int[][] lvlData) {
		if (x < 0 || x >= Global.GAME_WIDTH) {
			return true;
		}
		
		if (y < 0 || y >= Global.GAME_HEIGHT) {
			return true;
		}
		
		int xIdx = (int)x / Global.TILES_SIZE;
		int yIdx = (int)y / Global.TILES_SIZE;
		
		int value = lvlData[(int)yIdx][(int)xIdx];
		
		if (value >= 48 || value < 0 || value != 11) {
			return true;
		}
		
		return false;
	}
}
