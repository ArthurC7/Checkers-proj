
public class GameBoard {

	private double squareSize;
	private static final int SQUARE_SIZE = 8;
	private double moveLength;
	
	public GameBoard(int size){
		squareSize = size/8;
		moveLength = Math.sqrt((squareSize*squareSize)+(squareSize*squareSize));
	}
	
	public double getMoveLength(){
		return moveLength;
	}
	
	public void makeBoard(){
		
	}
	
}
