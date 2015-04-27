package de.oc.tictactoe.players;

import javax.swing.JOptionPane;

import de.oc.tictactoe.enums.Coordinate;
import de.oc.tictactoe.exceptions.AlreadySet;

public class PlayerHelper {

	public static void endGame(){
		if(JOptionPane.showConfirmDialog(null, "Spiel beenden?","Spiel beenden?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	public static void set(Coordinate coordinate,Player player){
		try {
			player.selectField(coordinate);
		} catch (AlreadySet e) {
			JOptionPane.showMessageDialog(null, "Feld bereits besetzt!");
			coordinate = player.ask();
			set(coordinate, player);
		} catch (NullPointerException e){
			//if AlreadySet do nothing here, it will ask again.
		}
	}
}
