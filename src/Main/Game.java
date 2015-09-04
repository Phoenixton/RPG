package Main;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import Assets.Assets;
import GameStateManager.GameState;
import GameStateManager.MenuState;
import GameStateManager.SettingsState;
import GameStateManager.State;
import Utils.GameCamera;
import Utils.Handler;
import Utils.KeyManager;

public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	//states -- Declarer tous les states que l'on a 
	
	private State gameState; //we declare them as a State but we can initialize them at whatever we want
	private State menuState;
	private State settingsState;
	
	//Input
	private KeyManager keyManager;
	//
	
	//camera
	private GameCamera gameCamera;
	//
	
	//handler
	
	private Handler handler;
	
	public Game(String title,int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() throws IOException{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); //add a keyListener
		Assets.init();
		
		handler = new Handler(this); //this = game object
		gameCamera = new GameCamera(handler, 0,0); //add this (game because we are in game class) because added it to the GameCamera constructor
		
		gameState = new GameState(handler); // we can do this cause Extends.
		menuState = new MenuState(handler); //referring this to this game class
		settingsState = new SettingsState(handler);
		State.setState(gameState); //le code est dans class GameState
		//ICI ^
	}

	private void tick(){
		
		keyManager.tick();
		//update
		if(State.getState() != null) 
			State.getState().tick();
		
		//used to have x and y to make things move
		
		
		
	}
	/*both are part of game loop*/
	private void render() {
		//affiche
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics(); //g = grphics object
		
		//Clear Screen
		
		g.clearRect(0, 0, width, height);
		
		//Draw here
		
		if(State.getState() != null) 
			State.getState().render(g);
		//End Drawing
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		// A CAUSE DE L INVENTAIRE, TRY AND CATCH. ET plus bas, un throw
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//temp fps
		int fps = 60;
		double timePerTick = 1000000000 / fps; //nano seconds --> 1 sec hehe
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		//end
		while(running) { //game loop
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
	}
	
	//getter pour la classe Player pour acceder au KeyManager
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	/*
	public void setWidth(int width){
		this.width = width;
	}
	*/
	public int getHeight(){
		return height;
	}
	
	public synchronized void start() {
		
		if (running) return; //safety
		running = true;
		thread = new Thread(this); // this = game class
		thread.start();
		
	}
	public synchronized void stop() {
		
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}