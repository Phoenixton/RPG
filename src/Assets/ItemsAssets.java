package Assets;

import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class ItemsAssets {
	private static final int width = 28, height = 28;
	//perso
	
	public static BufferedImage inventory;
	public static BufferedImage fruit;

	
	/*static LinkedList<BufferedImage> tabUp = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabDown = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabLeft = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabRight = new LinkedList<BufferedImage>();
	*/
	public static void init(){
		
		SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/Items/items.png"));
		fruit = items.crop(0, 0, width, height);
		SpriteSheet inventoryDisplay = new SpriteSheet(ImageLoader.loadImage("/textures/Items/inv.png"));
		inventory = inventoryDisplay.crop(0, 0, 268, 202);
	}
}
