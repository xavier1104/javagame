package levels;

public class Level {
	private int[][] lvlData;
	
	public Level(int[][] lvlData) {
		// TODO Auto-generated constructor stub
		this.lvlData = lvlData;
	}
	
	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}
	
	public int[][] getData(){
		return lvlData;
	}
}
