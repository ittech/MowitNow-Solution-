package mowItNow;

public class Grille {

	private int[][] T;

	public Grille(int x, int y) {

		T = new int[x][y];

	}

	public boolean isEmpty(int x, int y) {

		if (T[x - 1][y - 1] == 1)
			return false;
		else
			return true;

	}

	public void fill(int x, int y) {

		T[x - 1][y - 1] = 1;
	}

	public Position getUpperRightPosition() {

		return new Position(T.length, T[1].length);

	}

}
