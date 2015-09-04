package GameStateManager;
import java.awt.Graphics;

import Utils.Handler;

public abstract class State {

	//could be in a separate class GAME STATE MANAGER
		private static State currentState = null;
		
		public static void setState(State state){
			currentState = state;
		}
		
		public static State getState() {
			return currentState;
		}


		//CLASS --ABSTRACT

		protected Handler handler;
		
		public State(Handler handler){
			this.handler = handler; //any class that extends State must have game -- now handler
		}

		public abstract void tick();
		
		public abstract void render(Graphics g);
		
}
