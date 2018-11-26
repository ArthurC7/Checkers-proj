import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.Position;

public class CheckerAlgorithm {

	private ArrayList<CheckerPiece> redPieces;
	private ArrayList<CheckerPiece> blackPieces;
	private BoardPosition[][] gameboard;
	private HashMap<BoardPosition, CheckerPiece> pieceLoc;
	
	public enum colorPiece{
		RED, BLACK, NONE;
	}
	
	public CheckerAlgorithm(){
		redPieces = new ArrayList<CheckerPiece>();
		blackPieces = new ArrayList<CheckerPiece>();
		gameboard = new BoardPosition[8][8];
	}
	
	public void InvertBoard() {
		
	}
	
	public void movePiece(BoardPosition position) {
		if(position.isTaken() == false) {
			return;
		}
	}
	
	public void possibleMoves(CheckerPiece piece) {
		BoardPosition pos = piece.getPosition();
		int xPos = pos.getX();
		//changePosition
		//check to see if there is a piece in the way
	}
}
