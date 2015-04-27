package de.oc.tictactoe.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.oc.tictactoe.enums.Coordinate;
import de.oc.tictactoe.game.Field;
import de.oc.tictactoe.game.Printer;
public class GuiPrinter extends Printer{
	public TreeMap<Coordinate, JButton> buttons;
	public GuiPrinter(){
		buttons = new TreeMap<>();
		JFrame frame = new JFrame("Tic-Tac-Toe");
		GridLayout grid = new GridLayout(3,3);
		frame.setLayout(grid);
		for(Coordinate coordinate : Coordinate.values()){
			JButton button = new JButton("NONE");
			String command = coordinate.toString();
			button.setActionCommand(command);
			buttons.put(coordinate, button);
			frame.add(button);
		}
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void printBoard(HashMap<Coordinate, Field> fields) {
		super.printBoard(fields);
		for(Entry<Coordinate, Field> entry : fields.entrySet()){
			Coordinate coordinate = entry.getKey();
			Field field = entry.getValue();
			JButton button = buttons.get(coordinate);
			field.print((s)->button.setText(s));
		}
		
	}
	public void setListener(ActionListener listener){
		GuiPrinterAction.setListener(listener,buttons);
	}
}