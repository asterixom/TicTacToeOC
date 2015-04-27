package de.oc.tictactoe.game;
import java.util.HashMap;

import de.oc.tictactoe.WinChecker;
import de.oc.tictactoe.enums.Coordinate;
import de.oc.tictactoe.enums.Symbol;
import de.oc.tictactoe.exceptions.AlreadySet;
import de.oc.tictactoe.exceptions.NotSet;
public class Board {
	private HashMap<Coordinate,Field> fields;
	public Board(WinChecker winChecker){
		fields = new HashMap<>();
		for(Coordinate coordinate : Coordinate.values()){
			fields.put(coordinate, new Field());
		}
		BoardHelper.create(winChecker, this);
	}
	public void printBoard(Printer printer){
		printer.printBoard(fields);
	}
	public void createSet(WinChecker winChecker, Coordinate... keys){
		Field[] fieldSet = new Field[keys.length];
		for(int i=0;i<keys.length;i++){
			 fieldSet[i] = fields.get(keys[i]);
		}
		winChecker.createFieldSet(fieldSet);
	}
	public void setField(Coordinate coordinate, Symbol symbol) throws AlreadySet{
		Field field = fields.get(coordinate);
		field.setSymbol(symbol);
	}
	public void gameOver(Runnable ifOver){
		try{
			checkOver();
		} catch(NotSet e){
			return;//game still running!
		}
		ifOver.run();
	}
	private void checkOver() throws NotSet {
		for(Field field : fields.values()){
			field.gameOver();
		}
	}
}