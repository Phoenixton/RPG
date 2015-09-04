package Utils;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, enter, inv;
	private boolean enterIsPressed = false;
	
	//constructor
	
	public KeyManager(){
		
		keys = new boolean[256];
		
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_Z];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_Q];
		right = keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_ENTER];
		inv = keys[KeyEvent.VK_UP];
	}


	//because of native keylistener :

	public void keyPressed(KeyEvent e){
		
		keys[e.getKeyCode()] = true; //the e of the keyEvent
		System.out.println("pressed !");
	}
	
	public void keyReleased(KeyEvent e){
		
		keys[e.getKeyCode()] = false;
		
	}
	
	public void keyTyped(KeyEvent e){
		
		
	}
	
}
