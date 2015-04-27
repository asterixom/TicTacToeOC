package de.oc.tictactoe;

import java.util.ArrayList;

import de.oc.tictactoe.game.Field;
import de.oc.tictactoe.game.FieldSet;

public class WinChecker {

	private ArrayList<FieldSet> fieldSets;
	
	public WinChecker(){
		fieldSets = new ArrayList<>();
	}

	public void createFieldSet(Field... fieldSet) {
		fieldSets.add(new FieldSet(fieldSet));
	}
	
	public void hasWon(Runnable ifWon){
		for(FieldSet fieldSet : fieldSets){
			fieldSet.hasWon(ifWon);
		}
	}
	
}
