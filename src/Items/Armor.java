package Items;

import java.awt.image.BufferedImage;

public class Armor extends Items{

	private float defense;
	
	public Armor(BufferedImage image, float defense) {
		super(image);
		this.defense = defense;
	}

}
