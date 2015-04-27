package de.oc.tictactoe;

import javax.swing.JOptionPane;

import de.oc.tictactoe.enums.Symbol;
import de.oc.tictactoe.game.Board;
import de.oc.tictactoe.game.Printer;
import de.oc.tictactoe.gui.GuiPlayer;
import de.oc.tictactoe.gui.GuiPrinter;
import de.oc.tictactoe.players.Player;
import de.oc.tictactoe.players.Players;
import de.oc.tictactoe.players.Turn;

public class Main {

	private volatile boolean gameRunning;

	public Main() {
		//initNoGui();
		init();
	}

	private void init(){
		GuiPrinter printer = new GuiPrinter();
		WinChecker winChecker = new WinChecker();
		Board board = new Board(winChecker);
		Turn turn = new Turn();
		turn.addBoard(board);
		Players players = new Players();
		Player player = new GuiPlayer(Symbol.O,board,printer);
		Player player2 = new GuiPlayer(Symbol.X,board,printer);
		players.addPlayer(player);
		players.addPlayer(player2);
		gameRunning=true;
		while(gameRunning){
			board.printBoard(printer);
			players.nextPlayer(board, turn);
			winChecker.hasWon(()->wonGame(board, printer));
			board.gameOver(()->gameOver(board,printer));
		}
		System.out.println("done!");
		System.exit(0);
	}
	
	@SuppressWarnings("unused")
	private void initNoGui() {
		Printer printer = new Printer();
		WinChecker winChecker = new WinChecker();
		Board board = new Board(winChecker);
		Turn turn = new Turn();
		turn.addBoard(board);
		Players players = new Players();
		Player player = new Player(Symbol.O,board);
		Player player2 = new Player(Symbol.X,board);
		players.addPlayer(player);
		players.addPlayer(player2);
		gameRunning=true;
		while(gameRunning){
			board.printBoard(printer);
			players.nextPlayer(board, turn);
			winChecker.hasWon(()->wonGame(board, printer));
			board.gameOver(()->gameOver(board,printer));
		}
		System.out.println("done!");
	}

	private void gameOver(Board board, Printer printer) {
		if (gameRunning) {
			board.printBoard(printer);
			JOptionPane.showMessageDialog(null, "Spiel beendet.");
		}
		gameRunning = false;
	}

	public void wonGame(Board board, Printer printer) {
		gameRunning = false;
		board.printBoard(printer);
		JOptionPane.showMessageDialog(null, "Du hast gewonnen!!");
	}

	public static void main(String[] args) {
		new Main();
	}
}
