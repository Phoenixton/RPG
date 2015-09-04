package Main;


public class Launcher {
	public static final int  WIDTH = 500, HEIGHT = 500;
	
	
	public static void main(String[] args) {
		
		Game game = new Game("Game Title!", WIDTH, HEIGHT);
		game.start();
		
	}
	
}
