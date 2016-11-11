package com.tictac2;

import java.io.Serializable;

public class Context implements Serializable {

    private static final long serialVersionUID = 510l;
    
    private boolean gameover = false;
    private String  turn = "x"; // X, Y N 

    public Context(String turn) {
		super();
		this.turn = turn;
	}
	public boolean isGameover() {
		return gameover;
	}
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
	@Override
	public String toString() {
		return "Context [gameover=" + gameover + ", turn=" + turn + "]";
	}
    

}
