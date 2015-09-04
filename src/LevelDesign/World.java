package LevelDesign;

import java.awt.Graphics;

import Tiles.Tile;
import Utils.Handler;
import Utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height; //size of the map
	private int spawnX, spawnY; //depart position of the player
	private int[][] tiles; //tiles + position on the map . x and y coordinates
	
	
	
	public World(Handler handler, String path){ //load a world from a file
		this.handler = handler;
		loadWorld(path);
		
	}

	public void tick(){
		
	}
	
	public void render(Graphics g){ // 20
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH); //the tile the user can currently see at the far left of the screen. The max with 0 serves to not get a negative value. If you add 1 after TILEWIDTH, you'll see tiles being removed.
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);//the tile the user can currently see at the far right of the screen
		int yStart = (int) Math.max(0,  handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT); //same idea
		int yEnd = (int) Math.min(height,  (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		// will change with the size of the screen
		// for(int y = yStart; y < yEnd; y++){ //va dessiner -- way more efficient this way. Tiles not on the screen aren't drawn
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); //transform the x and y in Tile coordinates
			}
		}
		//
		
		
	}
	
	public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0 || x >= width || y >= height) //if x or y are outside the boundaries of the map
			return Tile.grassTile;
		
		
		Tile t = Tile.tiles[tiles[x][y]]; // le tableau dans Tile
		if(t == null)
			return Tile.dirtTile; //in case you call a non assigned number in array tile/default tile
		return t; //otherwise
	}
	
	
	private void loadWorld(String path){ //next
		
		
		String file = Utils.loadFileAsString(path);
		// we have to split up the world1 file
		String[] tokens = file.split("\\s+"); //splits every little number in its own string
		width = Utils.parseInt(tokens[0]); // the very first number in the file. It gives the size width of the world. tokens[0] is the first position in the file and it returns 5 here.
		height = Utils.parseInt(tokens[1]); //same for height
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[x + y * width + 4]); //cause we already set the first four variables
			}
		}
		
		
		//not permanent
		/*
		width = 5;
		height = 5; //5x5 tiles
		
		tiles = new int[width][height];
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){ // check tout le tableau
				tiles[x][y] = 0; // toutes les cases du tableau renvoient 0, c'est à dire regular tile
			}
		}
		*/
		
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	
}
