package Entities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Main.Launcher;
import Tiles.Tile;
import Utils.Handler;
import Utils.KeyManager;

public class Pnj extends Entity implements Runnable {

	int x;
	int y;
	int width;
	int height;
	private Handler handler;
	private boolean hasBeenPressed = false;
	private String path;
	private int count = 0;
	private int xDirection;
	private int yDirection;
	private boolean resting = false;
	private boolean shouldSetRandomDir = true;
	private Thread thread;
	private boolean talking = false;
	
	
	//private Rect bounds for collision 
	
	public Pnj(int x,int y, int width, int height, Handler handler, String path){
		super(handler, x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		this.path = path;
		
	}
	
	public synchronized void start(){
		thread = new Thread(this); // this = game class
		thread.start();
	}
	public void tick(){


		
	}
	/*
	public void render(Graphics g, Player player, KeyManager km, String path){
		
		g.setColor(Color.black);
		g.drawRect((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
		for(int i = 0; i < sentencesCounting(path).length; i++){
			if(this.isClose(player) && player.enterIsReleased())
			{
				hasBeenPressed = !hasBeenPressed;
			}
			if(hasBeenPressed && this.isClose(player)){
				displayBubble(sentencesCounting(path)[i], g);
				
			} else {
				hasBeenPressed = false;
			}
	
		}
	}*/
	
	public void render(Graphics g, Player player, KeyManager km) throws ParserConfigurationException, SAXException, IOException{
		
		g.setColor(Color.black);
		g.drawRect((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
		
		if(this.isClose(player) && player.enterIsReleased())
		{
			hasBeenPressed = true;
			count++; //donc count = 0 pour avoir 1 direct
		}
		
		if(hasBeenPressed && this.isClose(player) && count < countDialogs() - 1){ //countDialogs a deux cases vides à la fin
			displayBubble(g, count);
			talking = true;
		} else {
			hasBeenPressed = false;
			count = 0;
			talking = false;
			//System.out.println(countDialogs());
		}
		
	}
	
	public boolean isClose(Player player){
		
		return (Math.sqrt((player.getX() - x) * (player.getX() - x)
				+ (player.getY() - y) * (player.getY() - y)) <= 100) ;
		
	}
	
	public void displayBubble(Graphics g, int i) throws ParserConfigurationException, SAXException, IOException
	{
		g.setColor(Color.black);
		g.fillRect(0, Launcher.HEIGHT - 200, Launcher.WIDTH - 1, Launcher.HEIGHT - 301);
		g.setColor(Color.white);
		Font fonte = new Font("TimesRoman ",Font.PLAIN,20);
		g.setFont(fonte);	
		g.drawRect(0, Launcher.HEIGHT - 200, Launcher.WIDTH - 1, Launcher.HEIGHT - 301);
		
		
		//part a partir du 1 car 0 est vide
		g.drawString(recupereDialogue(i), 10, 320);
		
	}
	/*
	public String displayText() throws ParserConfigurationException, SAXException, IOException{
		
		File fXmlFile = new File(this.path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		
		doc.getDocumentElement().normalize();
		NodeList author = doc.getElementsByTagName("body");
		// author.getLength(); -- utliser pour compte conversations entrée
		Node nNode = author.item(0);
		String from = nNode.getTextContent();
		return from;
		
	}*/
	
	public String printNode() throws ParserConfigurationException, SAXException, IOException{
		
		try{
			File fXmlFile = new File(this.path);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = dBuilder.parse(fXmlFile);
		
			if(doc.getChildNodes() != null){
				return printNote(doc.getChildNodes());
			}else{
				return ("pas de noeuds a lister");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		return ("ca n'a pas marché");
	}
	
	//LOOPS THROUGH ALL THE DiALOGS
	public String printNote(NodeList nodeList){
		
		Node tempNode = nodeList.item(0);
		/*String string = tempNode.getTextContent();
		if(tempNode.hasChildNodes())
			string = string + "\n" + printNote(tempNode.getChildNodes());
		return string;*/
		return (tempNode.hasChildNodes()?tempNode.getTextContent() + printNote(tempNode.getChildNodes()):tempNode.getTextContent()); //+\n
	}
	
	
	public String recupereDialogue(int i) throws ParserConfigurationException, SAXException, IOException{
//		System.out.println(printNode());
		String s = printNode();
		String[] allDialogs = s.split("\n");
//		System.out.println(allDialogs[2] + "WHATEVER");
		return allDialogs[i];
				
	}
	
	public int countDialogs() throws ParserConfigurationException, SAXException, IOException{
		String s = printNode();
		String[] allDialogs = s.split("\n+");
		
		return allDialogs.length;
	}
/*
	public String[] sentencesCounting(String path){
		String[] tokens = new String[4];
		tokens[0] = "Bonjour"; 
		tokens[1] = "                      Bonjour A"; 
		tokens[2] = "                        Bonjour B"; 
		tokens[3] =  "                                              Bonjour C"; 
		return tokens;
	}
	*/
	
	
	
	
	//ARTIFICIAL INTELLIGENCE
	
	public int chooseRandomDirection(){
		Random r = new Random();
		int[] randDirections = new int[3]; //don't need more
		randDirections[0] = 0;
		randDirections[1] = 1;
		randDirections[2] = -1;
		
		int randChoice = r.nextInt(3);
		return randDirections[randChoice];
	}
	//move in that dir
	
	public void setXDirection(int dir){
		xDirection = dir;
	}
	public void setYDirection(int dir){
		yDirection = dir;
	}
	
	//in run meth, mov and then wait
	
	public void move()
	{
		
		if(xDirection > 0){ //moving right
			int tx = (int) (x + xDirection + bounds.x + bounds.width) / Tile.TILEWIDTH; //gives the x coordinate of tile we are trying to move into
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){ //first checking upper right corner then lower right corner of the box. if it's not solid, then we are good to move
				x += xDirection;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		} else  if(xDirection < 0) { //moving left
			int tx = (int) (x + xDirection + bounds.x) / Tile.TILEWIDTH; //gives the x coordinate of tile we are trying to move into
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){ //first checking upper right corner then lower right corner of the box. if it's not solid, then we are good to move
				x += xDirection;
			}else{
			
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH -  bounds.x;
			}
		}
		
		//faire tous les cas x < 0 et y > 0. ...
		
		if(yDirection < 0) {//going up
			int ty = (int) (y + yDirection + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)){
				y += yDirection;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		} else if(yDirection > 0){ //going down
			int ty = (int) (y + yDirection + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)){
				y += yDirection;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
		
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}

	@Override
	public void run() {


		try{
			while(true){
				if(!resting){
					if(shouldSetRandomDir){
						setXDirection(chooseRandomDirection());
						setYDirection(chooseRandomDirection());
						shouldSetRandomDir = false;
					} 
				
					long start = System.currentTimeMillis();
					long end = start + 1 * 1000; // 1 seconde de move
					while(System.currentTimeMillis() < end){
						if(!talking) {
							move();
							Thread.sleep(10);
						} else {
							//ils ne bougent plus quand ils parlent
						}
					}
					resting = true;
				}else{
					Thread.sleep(3000); //3secs
					shouldSetRandomDir = true;
					resting = false;
				}
			}
		}catch(Exception e){
				System.err.println((e.getMessage()));
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
