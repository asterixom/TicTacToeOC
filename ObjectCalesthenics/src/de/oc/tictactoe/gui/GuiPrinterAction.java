package de.oc.tictactoe.gui;

import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JButton;

import de.oc.tictactoe.enums.Coordinate;

public class GuiPrinterAction {

	public static void setListener(ActionListener listener, TreeMap<Coordinate, JButton> buttons){
		for(Coordinate coordinate : Coordinate.values()){
			JButton button = buttons.get(coordinate);
			removeAllListeners(button);
			button.addActionListener(listener);
		}
	}
	private static void removeAllListeners(JButton button){
		for(ActionListener listener : button.getActionListeners()){
			button.removeActionListener(listener);
		}
	}
	
}
