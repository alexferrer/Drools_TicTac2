package com.tictac2;

public class Cell {
	static final long serialVersionUID = 1L;

	private int row;
	private int col;
	private String player;
	private int value;

	
	public Cell(int row, int col, String player, int value) {
		super();
		this.row = row;
		this.col = col;
		this.player = player;
		this.value = value;
	}

	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		this.player = "n";
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ", col=" + col + ", player=" + player + ", value=" + value + "]";
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	


}
