
public class CheckerPiece {

	private static final int POSITION_VALUE = 2;
	
	// true will be red, false will be black
	private boolean hasPiece;
	private boolean color;
	private boolean isKing;
	BoardPosition position;
	boolean otherColor;
	
	public CheckerPiece(boolean color, BoardPosition position, boolean otherColor) {
		this.color = color;
		this.position = position;
		isKing = false;
		this.otherColor = otherColor;
	}
	
	public void move(BoardPosition position) {
		this.position = position;
	}
	
	public BoardPosition getPosition() {
		return position;
	}
}
