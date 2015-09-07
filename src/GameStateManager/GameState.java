package GameStateManager;

import java.awt.Graphics;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Entities.Monster;
import Entities.Player;
import Entities.Pnj;
import Gameplay.Inventory;
import LevelDesign.World;
import Utils.Handler;
import Utils.KeyManager;

public class GameState extends State {
	private Pnj pnj;
	private Pnj pnj2;
	private Monster mob1;
	private Player player;//test
	private World world; //test
	private KeyManager km;
//	private Inventory inventory;

	public GameState(Handler handler) throws IOException{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt"); //test
		handler.setWorld(world); //order is important. The variable world in Handler class is set to whatever we give it - here world
		player = new Player(handler, 250, 150); //test
		//inventory = new Inventory();
		pnj = new Pnj(500, 500, 64, 64, handler, "res/pnj/essai1.xml");
		pnj.start();
		pnj2 = new Pnj(300, 300, 32, 32, handler, "res/pnj/essai2.xml");
		pnj2.start();
		mob1 = new Monster(handler, 400, 100);
	}
	
	public void tick(){
		world.tick();//test
		player.tick();//test
		//inventory.tick();
		mob1.tick();
		
	}
	// int x = 0;
	// int y = 60;
	
	public void render(Graphics g){
		
		world.render(g);//test
		player.render(g); //test -- on top of the world that way
		mob1.render(g, player);
		try {
			pnj.render(g, player, km);
			pnj2.render(g, player, km);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//inventory.draw(g);
		
		//would add "path" if we had to
		
		//for now
		//Tile.tiles[0].render(g, 0, 0);  // we can access cause static
		
		
		// x++;
		// y++;
		// g.drawImage(Assets.droit, x, 0, null);
		// g.drawImage(Assets.gauche, y, 0, null);
		
		// used to be g.drawImage(Assets.face, 0, 0, null);
		
	}

}
