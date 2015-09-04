package Items;

import java.awt.image.BufferedImage;

public class Potion extends Items {

	
	private int effet;
	
	public Potion(BufferedImage image, int effet) {
		super(image);
		this.effet = effet;
	}

}
