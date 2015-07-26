package mowItNow;

public class Position {

	int x;
	int y;
	String d;

	public Position(int x, int y, String direction) {

		this.x = x;
		this.y = y;
		this.d = direction;

	}

	public Position(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public String getDir() {

		return d;

	}

	public void setX(int x) {

		this.x = x;

	}

	public void setY(int y) {

		this.y = y;

	}

	public void setDir(String direction) {

		this.d = direction;

	}

}
