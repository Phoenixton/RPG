package Items;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseItem {

	private int itemSize;
	
	
	private int itemsPerLine;
	private int spriteWidth = 34;
	private int spriteHeight = 34;
	
	private BufferedImage itemSheet;
	public static Items[][] items;
	
	public BaseItem(int itemSize) {
		this.itemSize = itemSize;
		
		
	}

	public void loadItems(String path) throws IOException{
		itemSheet = ImageIO.read(getClass().getResourceAsStream(path));
		
		
		itemsPerLine = itemSheet.getWidth() / itemSize;
		items = new Items[2][itemsPerLine];
		
		BufferedImage subimage;
		for(int col = 0; col < itemsPerLine; col++) {
			
			
			//FOOD
			subimage = itemSheet.getSubimage(col * itemSize, 0,	itemSize, itemSize);
			
			items[0][col] = new Food(subimage, 1); //classées par effet (+ 2sante/s par exemple)
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
				);
			items[1][col] = new Food(subimage, 2);
		
			
			//POPO
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
				);
			items[2][col] = new Potion(subimage, 2); //par effet - potion d'agi premiere ligne par exemple
		
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[3][col] = new Potion(subimage, 2);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[4][col] = new Potion(subimage, 2);
			
			
			
			//WEAPONS
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[5][col] = new Weapons(subimage, 1, 1);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[6][col] = new Weapons(subimage, 1, 1);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[7][col] = new Weapons(subimage, 2, 3); // a voir -- + attaque is float
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[8][col] = new Weapons(subimage, 2, 3);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[9][col] = new Weapons(subimage, 2, 5);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[10][col] = new Weapons(subimage, 2, 6);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[6][col] = new Weapons(subimage, 10, 3);
			
			
			
			//ARMORS
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[6][col] = new Armor(subimage, 10);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[6][col] = new Armor(subimage, 10);
			
			subimage = itemSheet.getSubimage(
					col * itemSize,
					itemSize,
					itemSize,
					itemSize
					);
			items[6][col] = new Armor(subimage, 10);
			
		
		}
	
	
	}
	
}
