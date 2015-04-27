package de.oc.tictactoe.enums;


public enum Coordinate {
	A1(1,1),A2(1,2),A3(1,3),
	B1(2,1),B2(2,2),B3(2,3),
	C1(3,1),C2(3,2),C3(3,3);
	
	private int x,y;
	
	private Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
