package de.oc.tictactoe.game;

import java.io.PrintStream;
import java.util.HashMap;

import de.oc.tictactoe.abstracts.Printerface;
import de.oc.tictactoe.enums.Coordinate;
import static de.oc.tictactoe.enums.Coordinate.*;

public class Printer implements Printerface{

	private HashMap<Coordinate, Field> fields;
	//FIXME TRENNE ZEILEN
	public void printBoard(HashMap<Coordinate, Field> fields){
		this.fields = fields;
		print(A1);
		print("	");
		print(A2);
		print("	");
		print(A3);
		print("\n");
		print(B1);
		print("	");
		print(B2);
		print("	");
		print(B3);
		print("\n");
		print(C1);
		print("	");
		print(C2);
		print("	");
		print(C3);
		print("\n\n");
		
	}
	
	private void print(Coordinate coordinate){
		Field field = fields.get(coordinate);
		field.print(this);
	}
	
	public void print(String text){
		PrintStream printstream = System.out;
		printstream.print(text);
	}
	
}
