package de.oc.tictactoe.game;

import de.oc.tictactoe.abstracts.Comparator;

public class FieldSet {

	private Field[] fields;
	
	public FieldSet(Field... fields){
		this.fields = fields;
	}
	
	public void hasWon(Runnable ifWon){
		Comparator.equals(ifWon, fields);
	}
	
}
