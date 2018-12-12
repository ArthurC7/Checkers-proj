
public class BoardPosition {

	private int x;
	private int y;
	private boolean hasPiece;
	private CheckerPiece piece;
	
	public BoardPosition(int a, int b) {
		x = a;
		y = b;
		hasPiece = false;
	}
	
	public void addPiece(CheckerPiece piece){
		if(hasPiece){
			this.piece = piece;
			hasPiece = true;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void removePiece(){
		hasPiece = false;
	}
	
	public CheckerPiece getCheckerPiece(){
		if(!hasPiece){
			throw new UnsupportedOperationException();
		}
		return piece;
	}
	
	public boolean hasPiece(){
		return hasPiece;
	}
}
