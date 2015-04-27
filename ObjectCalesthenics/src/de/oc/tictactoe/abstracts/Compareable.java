package de.oc.tictactoe.abstracts;

public interface Compareable {
	public default void equals(Compareable compareable, Runnable ifTrue, Runnable ifFalse){
		if(this.equals(compareable)){
			ifTrue.run();
			return;
		}
		ifFalse.run();
	}
}
