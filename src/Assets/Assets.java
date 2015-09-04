package Assets;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class Assets {
	private static final int width = 32, height = 32;
	//perso
	public static BufferedImage  face1, left1, right1, behind1, face2, left2, right2, behind2, face3, left3, right3, behind3;
	//tiles
	public static BufferedImage regular, grass, road, rock, dirt;
	

	
	/*static LinkedList<BufferedImage> tabUp = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabDown = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabLeft = new LinkedList<BufferedImage>();
	static LinkedList<BufferedImage> tabRight = new LinkedList<BufferedImage>();
	*/
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/perso.png"));
		face1 = sheet.crop(0,0, width, height);
		left1 = sheet.crop(0, width, width, height);
		right1 = sheet.crop(0, (2 * width), width, height);
		behind1 = sheet.crop(0, (3 * width), width, height);
		
		face2 = sheet.crop(width,0, width, height);
		left2 = sheet.crop(width, width, width, height);
		right2 = sheet.crop(width, (2 * width), width, height);
		behind2 = sheet.crop(width, (3 * width), width, height);
		
		face3 = sheet.crop((2 * width),0, width, height);
		left3 = sheet.crop((2 * width), width, width, height);
		right3 = sheet.crop((2 * width), (2 * width), width, height);
		behind3 = sheet.crop((2 * width), (3 * width), width, height);
		
		/*
		tabUp.add(behind1);
		tabUp.add(behind2);
		tabUp.add(behind3);
		
		tabDown.add(face1);
		tabDown.add(face2);
		tabDown.add(face3);
		
		tabLeft.add(left1);
		tabLeft.add(left2);
		tabLeft.add(left3);
		
		tabRight.add(right1);
		tabRight.add(right2);
		tabRight.add(right3);
		*/
		SpriteSheet sheetTiles = new SpriteSheet(ImageLoader.loadImage("/textures/tilea2.png"));
		regular = sheetTiles.crop(0, width, 2*width, 2*width);
		grass = sheetTiles.crop(64, 128, 2*width, 2*width);
		road = sheetTiles.crop(4*width, width, 2*width, 2*width);
		rock = sheetTiles.crop(10*width, 10*width, 2*width, 2*width);
		dirt = sheetTiles.crop(4*width, 4*width, 2*width, 2*height);
	}
}
