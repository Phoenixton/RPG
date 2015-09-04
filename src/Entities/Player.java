package Entities;

import java.awt.Graphics;

import Assets.Assets;
import Assets.ItemsAssets;
import Gameplay.Inventory;
import Utils.Handler;


public class Player extends Creature {

	//private Game game; //need it to access the keyManager
	int t;
	private int lastPos = 0; //permet de garder la derniere pos pour l'animation
	
	
	private int u = 0;
	
	private boolean inventoryToDisplay = false;
	
	
	
	
	
	public Player(Handler handler, float x, float y){
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		// this.game = game;	not anymore with ep 19
		
		//this is to customize according to the picture of the player/creatures episode collision detection
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		t = 0;
	}
	
	//PLayer isn't abstract so needs tick and render
	public void tick(){
		//not the proper way
		/*
		if(game.getKeyManager().up)//so if it is true
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().left)
			x -= 3;
		if(game.getKeyManager().right)
			x +=3;
		*/
		getInput();
		move(); //in creature class/ Uses xMove/yMove
		
		handler.getGameCamera().centerOnEntity(this); //so that we center on this ^ player
	}
	//responsible of how the player moves
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		
		if(handler.getKeyManager().down)
			yMove = speed;
		
		if(handler.getKeyManager().left)
			xMove = -speed;
		
		if(handler.getKeyManager().right)
			xMove = speed;
		
		if(handler.getKeyManager().inv)
			inventoryToDisplay = true;
		
	}



	
	public void Animation(Graphics g){
	
		if(handler.getKeyManager().down){
			lastPos = 0; //en mettre un dans chaque elseif serait peut etre plus réaliste
			if(t < 10)
			{
				g.drawImage(Assets.face1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 20)
			{
				g.drawImage(Assets.face2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 30)
			{
				g.drawImage(Assets.face3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 40)
			{
				g.drawImage(Assets.face2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else
			{
				t = 0;
				g.drawImage(Assets.face2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			t++;
		}
		else if(handler.getKeyManager().up){
			lastPos = 1;
			if(t < 10)
			{
				g.drawImage(Assets.behind1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 20)
			{
				g.drawImage(Assets.behind2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 30)
			{
				g.drawImage(Assets.behind3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 40)
			{
				g.drawImage(Assets.behind2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else
			{
				t = 0;
				g.drawImage(Assets.behind2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			t++;
		}
		else if(handler.getKeyManager().left){
			lastPos = 2;
			if(t < 10)
			{
				g.drawImage(Assets.left1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 20)
			{
				g.drawImage(Assets.left2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 30)
			{
				g.drawImage(Assets.left3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 40)
			{
				g.drawImage(Assets.left2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else
			{
				t = 0;
				g.drawImage(Assets.left2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			t++;
		}
		else if(handler.getKeyManager().right){
			lastPos = 3;
			if(t < 10)
			{
				g.drawImage(Assets.right1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 20)
			{
				g.drawImage(Assets.right2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 30)
			{
				g.drawImage(Assets.right3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else if(t < 40)
			{
				g.drawImage(Assets.right2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			else
			{
				t = 0;
				g.drawImage(Assets.right2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
			t++;
		}
		else if(!handler.getKeyManager().down && !handler.getKeyManager().down && !handler.getKeyManager().down && !handler.getKeyManager().down){
			if(lastPos == 0)
				g.drawImage(Assets.face1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			if(lastPos == 1)
				g.drawImage(Assets.behind1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			if(lastPos == 2)
				g.drawImage(Assets.left1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			if(lastPos == 3)
				g.drawImage(Assets.right1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			
		}
	
	}
	
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	
	
	public void render(Graphics g){
		Animation(g);
		
		//pour avoir un rectangle de collision visible
		/*
		g.setColor(Color.red);

		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		*/
		
		/* We did : 
		 * 
		 * x -- la position du joueur upper left hand corner
		 * we substracted the offset of the camera : handler machin
		 * et on a rajouté le bounds.x pour avoir le bon endroit pour creer le rectangle
		 */
		
	}
	
	
	public boolean enterIsReleased()
	{
		//int u = 0
		int enterIsTouched = 0; //faux
		if(u == 1 && (handler.getKeyManager().enter))
		{
			enterIsTouched = 1;
		}
		if(!handler.getKeyManager().enter)
		{
			u = 1;
		}
		else
		{
			u = 0;
		}
		return enterIsTouched == 1;
	}
	
	public boolean shouldDisplayInventory(){
		return(handler.getKeyManager().inv); 
	}
	
}
