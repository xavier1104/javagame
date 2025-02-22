package utils;

import java.awt.geom.Rectangle2D;

import config.Global;
import object.*;

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
	
	public static float GetEntityXPosNextToWall(Entity entity, float xSpeed) {
		int currentTile = (int) (entity.getX() / Global.TILES_SIZE);
		if (xSpeed > 0) {
			// Right
			int tileXPos = currentTile * Global.TILES_SIZE;
			int xOffset = (int) (Global.TILES_SIZE - entity.getWidth());
			return tileXPos + xOffset - 1;
		} else {
			// Left
			return currentTile * Global.TILES_SIZE;
		}
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Entity entity, float airSpeed) {
		int currentTile = (int) (entity.getY() / Global.TILES_SIZE);
		if (airSpeed > 0) {
			// Falling - touching floor
			int tileYPos = currentTile * Global.TILES_SIZE;
			int yOffset = (int) (Global.TILES_SIZE - entity.getHeight());
			return tileYPos + yOffset - 1;
		} else
			// Jumping
			return currentTile * Global.TILES_SIZE;

	}
	
	public static boolean IsEntityOnFloor(Entity entity, int[][] lvlData) {
		if(IsSolid(entity.getX(), entity.getY() + entity.getHeight() + 1, lvlData)) {
			return true;
		}
		
		if(IsSolid(entity.getX() + entity.getWidth(), entity.getY() + entity.getHeight() + 1, lvlData)) {
			return true;
		}
		
		return false;
	}
}
