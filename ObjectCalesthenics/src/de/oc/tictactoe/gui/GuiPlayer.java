package de.oc.tictactoe.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import de.oc.tictactoe.enums.Coordinate;
import de.oc.tictactoe.enums.Symbol;
import de.oc.tictactoe.exceptions.AlreadySet;
import de.oc.tictactoe.game.Board;
import de.oc.tictactoe.players.Player;

public class GuiPlayer extends Player implements ActionListener{
	
	private GuiPrinter printer;
	
	public GuiPlayer(Symbol symbol, Board board, GuiPrinter printer) {
		super(symbol, board);
		this.printer = printer;
	}

	@Override
	public synchronized void yourTurn() {
		printer.setListener(this);
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Es geht weiter!!");
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		Coordinate coordinate = Coordinate.valueOf(command);
		try {
			super.selectField(coordinate);
			this.notify();
		} catch (AlreadySet e1) {
			JOptionPane.showMessageDialog(null, "Feld bereits besetzt.");
		}
	}
}