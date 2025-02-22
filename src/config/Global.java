package config;

public class Global {
	public static final int FPS = 120;
	public static final int UPS = 200;
	
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	public final static String PLAYER_ATLAS = "player_sprites.png";
	public final static String OUTSIDE_ATLAS = "outside_sprites.png";
	public final static String LEVEL_ONE_DATA = "level_one_data.png";
}
