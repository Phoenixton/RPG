package Gameplay;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entities.Player;

public class Inventory {

	private Player player;
	private BufferedImage inventory;
	
	public Inventory() throws IOException {
		
		inventory = ImageIO.read(getClass().getResourceAsStream("/textures/Items/inv.png"));
	}
	
	public void draw(Graphics g){
		if(player.shouldDisplayInventory()){
			g.drawImage(inventory, 0, 0, null);
			System.out.println("L'inventaire est Displayed");
		}
	}
	
	public void tick(){
		
	}

}
//faire un getter ToucheIEnclenchée() boolean dans player 
//et une methode render ici à appeler dans GameState avec des ticks 
//avec un if dans GameState