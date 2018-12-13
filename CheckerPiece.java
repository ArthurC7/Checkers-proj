
public class CheckerPiece {

	private static final int POSITION_VALUE = 2;
	private static final int KING_AT_BLACK = 7;
	private static final int KING_AT_RED = 0;
	
	private boolean isKing;
	PieceColor color;
	private int oppositeEnd;
	
	public CheckerPiece(PieceColor color) {
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
	
	public PieceColor getColor(){
		return color;
	}
	
	public void setKing(){
		isKing = true;
	}
	
	public int getKingPosition(){
		return oppositeEnd;
	}
	
	public boolean equals(CheckerPiece other){
		if(other == null){
			return false;
		}
		if(isKing != other.isKing){
			return false;
		}
		if(color != other.getColor()){
			return false;
		}
		if(oppositeEnd != other.getKingPosition()){
			return false;
		}
		return true;
	}
}



