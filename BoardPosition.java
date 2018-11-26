
public class BoardPosition {

	private int x;
	private int y;
	boolean taken;
	
	public BoardPosition(int a, int b) {
		x = a;
		y = b;
		taken = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void takeSpace() {
		taken = true;
	}
	
	public void freeSpace() {
		taken = false;
	}
	
	public boolean isTaken() {
		return taken;
	}
}
