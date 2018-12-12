
public class CheckerPiece {

	private static final int POSITION_VALUE = 2;
	private static final int KING_AT_BLACK = 7;
	private static final int KING_AT_RED = 0;
	
	private boolean isKing;
	String color;
	private int oppositeEnd;
	
	public CheckerPiece(String color) {
		this.color = color;
		isKing = false;
		if(color.equals("Black")){
			oppositeEnd = KING_AT_BLACK;
		}
		else{
			oppositeEnd = KING_AT_RED;
		}
	}
	
	public boolean isKing(){
		return isKing;
	}
	
	public String getColor(){
		return color;
	}
	
	public void kingMe(){
		isKing = true;
	}
}
