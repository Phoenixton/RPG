package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Utils.Handler;

public class Monster extends Creature {

	public Monster(Handler handler, float x, float y){
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		// this.game = game; used to be
		
		//this is to customize according to the picture of the player/creatures (ep collision detection)
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
	}
	
	public void Animation(Graphics g){

		g.setColor(Color.red);
		g.drawRect((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
		//possibility of moving/making an animation here
	}
	
public boolean isClose(Player player){
		
		return (Math.sqrt((player.getX() - x) * (player.getX() - x)
				+ (player.getY() - y) * (player.getY() - y)) <= 100) ;
		
	}
	
	public void tick(){
		move(); //in creature class/ Uses xMove/yMove
		
	}
	
	public void render(Graphics g, Player player){
		Animation(g);
		
		if(this.isClose(player))
		{
			System.out.println("hoho");
			//creation instance combat ou qqch '^'
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
