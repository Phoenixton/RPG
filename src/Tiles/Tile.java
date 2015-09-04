package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//static Stuff here
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0); //gave him the id of 0. So 0 is grass
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2); //actually road but well...s
	public static Tile roadTile = new RoadTile(3);
	public static Tile regularTile = new RegularTile(4);
	
	//main class for every tile 
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64; //sizing the tiles
	
	protected BufferedImage texture; //prtected cause classes will expand the class
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		//whenever we create a new tile we add it to the array
		tiles[id] = this;
	}
	
	public int getId(){ //getter
		return id;
	}
	
	public boolean isSolid(){ //tells you if a tile is walkable on
		return false; //by default -- not a solid block is false
	}
	
	
	public void tick(){
		
		
	}
	
	public void render(Graphics g, int x, int y){ //positions on the screen
		g.drawImage(texture,  x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
}
