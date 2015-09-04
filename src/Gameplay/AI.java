package Gameplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class AI implements Runnable {

	
	static Rectangle AI;
	int xDirection, yDirection;
	
	
	
	public AI(Rectangle r) {
		AI = r;
	}

	public static void render(Graphics g){
		g.setColor(Color.BLUE);
		if(AI != null)
			g.fillRect(AI.x, AI.y, AI.width, AI.height);
	}
	
	//chose Random dir
	public int chooseRandomDirection(){
		Random r = new Random();
		int[] randDirections = new int[3]; //don't need more
		randDirections[0] = 0;
		randDirections[1] = 1;
		randDirections[2] = -1;
		
		int randChoice = r.nextInt(3);
		return randDirections[randChoice];
	}
	//move in that dir
	
	public void setXDirection(int dir){
		xDirection = dir;
	}
	public void setYDirection(int dir){
		yDirection = dir;
	}
	
	//in run meth, mov and then wait
	
	public void move()
	{
		AI.x += xDirection;
		AI.y += yDirection;
	}
	
	public void run() {
		try{
			
		}catch(Exception e){
			System.err.println((e.getMessage()));
		}
	}

}
