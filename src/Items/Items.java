package Items;

import java.awt.image.BufferedImage;

public abstract class Items {
	
	
	private BufferedImage image;
	//private String name;
	
	//items types
	/*
	public static final int CONSOMMABLE = 0;
	public static final int POTIONS = 1;
	public static final int WEAPONS = 2;
	public static final int ARMORS = 3;
	*/
	
	public Items(BufferedImage image) {
		this.image = image;
		//this.name = name;
	
	}
	
	
	//getters
	public BufferedImage getImage(){
		return image;
	}

	
}
