package Entities;
import java.awt.Graphics;
import java.awt.Rectangle;

import Utils.Handler;

public abstract class Entity {

	protected Handler handler; //was done when wanted camera moving -- changed to Handler -- used to be Game game
	protected float x, y; //classes that extends also have them -- float cause need smooth
	
	protected int width, height;
	protected Rectangle bounds; //which stands for collision bounds
	
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	
		bounds = new Rectangle(0, 0, width, height); //upper left corner of the image, no offset by default
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//getters and setters 
	
	public float getX(){
		
		return x;
		
	}
	
	public void setX(float x){
		this.x = x;
	}

	public float getY() {
		return y;
	}
	
	public void setY(float Y){
		this.y = y;
	}

	public int getWidth(){
		return width;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
}
