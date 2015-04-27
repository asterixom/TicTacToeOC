package de.oc.tictactoe.players;

import java.util.ArrayList;

import de.oc.tictactoe.game.Board;

public class Players {

	private ArrayList<Player> players;
	
	public Players(){
		players = new ArrayList<>();
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void nextPlayer(Board board, Turn turn){
		turn.nextPlayer(board, players);
	}
	
}
