package de.oc.tictactoe.game;

import static de.oc.tictactoe.enums.Coordinate.*;
import de.oc.tictactoe.WinChecker;

public class BoardHelper {
	public static void create(WinChecker winChecker,Board board){
		board.createSet(winChecker, A1,A2,A3);
		board.createSet(winChecker, B1,B2,B3);
		board.createSet(winChecker, C1,C2,C3);
		board.createSet(winChecker, A1,B1,C1);
		board.createSet(winChecker, A2,B2,C2);
		board.createSet(winChecker, A3,B3,C3);
		board.createSet(winChecker, A1,B2,C3);
		board.createSet(winChecker, A3,B2,C1);
	}
}
