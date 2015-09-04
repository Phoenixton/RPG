package Items;

import java.awt.image.BufferedImage;

public class Weapons extends Items{

	private float attaque;
	private int range;
	
	public Weapons(BufferedImage image, int range, float attaque) {
		super(image);
		this.attaque = attaque;
		this.range = range;
	}

}
