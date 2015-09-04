package Assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path){
		try  {
			return ImageIO.read(ImageLoader.class.getResource(path));
			//return ImageIO.read(this.getClass().getResource("res/textures/beam.png"));
		
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
