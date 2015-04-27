package de.oc.tictactoe.players;

import javax.swing.JOptionPane;

import de.oc.tictactoe.enums.Coordinate;
import de.oc.tictactoe.enums.Symbol;
import de.oc.tictactoe.exceptions.AlreadySet;
import de.oc.tictactoe.game.Board;

public class Player {
	private Symbol symbol;
	private Board board = null;

	public Player(Symbol symbol, Board board) {
		this.symbol = symbol;
		this.board = board;
	}

	public void selectField(Coordinate coordinate) throws AlreadySet {
		if (board == null)
			return;
		board.setField(coordinate, symbol);
	}
	
	public void yourTurn() {
		// System.out.println("Player "+symbol+"'s turn!");
		Coordinate coordinate = null;
			coordinate = ask();
			PlayerHelper.set(coordinate,this);
	}

	public Coordinate ask() {
		try {
			return Coordinate.valueOf(JOptionPane.showInputDialog("Player "+ symbol));
		} catch (IllegalArgumentException e) {
			return null;
		} catch(NullPointerException e){
			endGame();
			return null;
		}
	}
	
	private void endGame(){
		PlayerHelper.endGame();
	}
}
