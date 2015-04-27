package de.oc.tictactoe.game;

import de.oc.tictactoe.abstracts.Compareable;
import de.oc.tictactoe.abstracts.Printerface;
import de.oc.tictactoe.enums.Symbol;
import de.oc.tictactoe.exceptions.AlreadySet;
import de.oc.tictactoe.exceptions.NotSet;

public class Field implements Compareable {
	
	private Symbol symbol;

	public Field() {
		this(Symbol.$);
	}
	public Field(Symbol symbol) {
		this.symbol = symbol;
	}
	public void equals(Compareable field, Runnable ifTrue, Runnable ifFalse) {
		if(symbol==Symbol.$ || !(field instanceof Field)){
			ifFalse.run();
			return;
		}
		if (((Field)field).symbol == symbol) {
			ifTrue.run();
			return;
		}
		ifFalse.run();
	}
	//FIXME KEINE SETTER!
	public void setSymbol(Symbol symbol) throws AlreadySet{
		if(this.symbol!=Symbol.$){
			throw new AlreadySet();
		}
		this.symbol = symbol;
	}
	public void print(Printerface printer){
		String text = symbol.toString();
		printer.print(text);
	}
	public void gameOver() throws NotSet {
		if(symbol==Symbol.$){
			throw new NotSet();
		}
	}
}