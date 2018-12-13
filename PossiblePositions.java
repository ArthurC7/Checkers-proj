import java.util.ArrayList;

public class PossiblePositions{
	
	ArrayList<BoardPosition> piecesToRemove;
	private int moveToX;
	private int moveToY;
	private int moveFromX;
	private int moveFromY;
	private boolean isJump;
	
	public PossiblePositions(int x1, int y1, int x2, int y2){
		moveFromX = x1;
		moveFromY = y1;
		moveToX = x2;
		moveToY = y2;
		piecesToRemove = new ArrayList<BoardPosition>();
		isJump = false;
	}
	
	public void removePieceAt(BoardPosition take){
		piecesToRemove.add(take);
	}
	
	public ArrayList<BoardPosition> getPiecesToRemove(){
		return (ArrayList<BoardPosition>) piecesToRemove.clone();
	}
	
	public int getToX(){
		return moveToX;
	}
	
	public int getToY(){
		return moveToY;
	}
	
	public int getFromX(){
		return moveFromX;
	}
	
	public int getFromY(){
		return moveFromY;
	}
	
	public void makeJump(){
		isJump = true; 
	}
	
	public boolean isJump(){
		return isJump;
	}
}
