package de.oc.tictactoe.players;

import java.util.ArrayList;
import java.util.HashMap;

import de.oc.tictactoe.game.Board;

public class Turn {
	
	private HashMap<Board, Integer> currentPlayers;
	
	
	public Turn(){
		currentPlayers = new HashMap<>();
	}
	
	public void addBoard(Board board){
		currentPlayers.put(board, -1);
	}
	
	public void nextPlayer(Board board,ArrayList<Player> players){
		Integer currentPlayer = currentPlayers.get(board)+1;
		if(currentPlayer>=players.size()){
			currentPlayer%=players.size();
		}
		currentPlayers.put(board, currentPlayer);
		Player player = players.get(currentPlayer);
		player.yourTurn();
	}
	
}
