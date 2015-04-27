package de.oc.tictactoe.abstracts;

public class Comparator {

	private static boolean gleich;

	public static void equals(Runnable ifTrue, Compareable... compareables) {
		if (compareables == null||compareables.length < 2)
			return;
		Compareable compareable = compareables[0];
		gleich = true;
		for (int i = 1; i < compareables.length; i++) {
			compareable.equals(compareables[i], () -> {
			}, () -> gleich = false);
		}
		if (gleich) {
			ifTrue.run();
		}
	}

}
