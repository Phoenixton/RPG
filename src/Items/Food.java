package Items;

import java.awt.image.BufferedImage;

public class Food extends Items{

	private int healthUp;
	
	public Food(BufferedImage image, int healthUp) {
		super(image);
		this.healthUp = healthUp;
	}

}
