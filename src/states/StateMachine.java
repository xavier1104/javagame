package states;

import object.Player;

public class StateMachine {
	State state;
	public StateMachine(Player player) {
		// TODO Auto-generated constructor stub
		setState(new IdleState(player));
	}
	
	public void setState(State state) {
		this.state = state;
		this.state.enterState();
	}
	
	public State getState() {
		return state;
	}
	
	public void update() {
		state.update();
	}
}
