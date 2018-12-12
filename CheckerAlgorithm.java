import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.Position;

public class CheckerAlgorithm implements Serializable{
	
	private static final int PIECE_COUNT = 12;

	private ArrayList<CheckerPiece> redPieces;
	private ArrayList<CheckerPiece> blackPieces;
	private int redPieceCount;
	private int blackPieceCount;
	private BoardPosition[][] gameboard;
	
	public enum colorPiece{
		RED, BLACK, NONE;
	}
	
	public CheckerAlgorithm(){
		redPieces = new ArrayList<CheckerPiece>();
		blackPieces = new ArrayList<CheckerPiece>();
		redPieceCount = PIECE_COUNT;
		blackPieceCount = PIECE_COUNT;
		gameboard = new BoardPosition[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				gameboard[i][j] = new BoardPosition(i, j);
			}
		}
		
		initializeEvenRow(0, "Black");
		initializeOddRow(1, "Black");
		initializeEvenRow(2, "Black");
		initializeOddRow(5, "Red");
		initializeEvenRow(7, "Red");
		initializeOddRow(7, "Red");
	}
	
	private void initializeEvenRow(int row, String color){
		for(int i = 0; i < 7 ; i += 2){
			BoardPosition position = gameboard[row][i];
			position.addPiece(new CheckerPiece(color));
		}
	}
	
	private void initializeOddRow(int row, String color){
		for(int i = 1; i < 8; i += 2){
			BoardPosition position = gameboard[row][i];
			position.addPiece(new CheckerPiece(color));
		}
	}
	
	public void InvertBoard() {
		
	}
	
	public void movePiece(ArrayList<PossiblePositions> moves, int x, int y) {
		for(PossiblePositions p : moves){
			if()
		}
	}
	
	public void possibleMoves(int x, int y) {
		ArrayList<PossiblePositions> movesToMake = new ArrayList<PossiblePositions>();
		BoardPosition pos = gameboard[x][y];
		int xPos = pos.getX();
		int yPos = pos.getY();
		//changePosition
		//check to see if there is a piece in the way
		
		CheckerPiece piece = pos.getCheckerPiece();
		
		if(!piece.isKing()){
			if(xPos == 0){
				int currentX = xPos;
				int currentY = yPos;
				
				
				BoardPosition position = gameboard[currentX + 1][currentY + 1];
				
				if(!position.hasPiece()){
					PossiblePositions move1 = new PossiblePositions(position.getX(), position.getY());
					movesToMake.add(move1);
				}
				
				boolean validMove = true;
				
				
				while(validMove){
					BoardPosition checkPos = gameboard[currentX + 1][currentY + 1];	
					if(position.hasPiece() & !position.getCheckerPiece().getColor().equals(piece.getColor())){
						BoardPosition jumpPos = gameboard[currentX + 2][currentY + 2];
						if(!jumpPos.hasPiece()){
							PossiblePositions posChecks = new PossiblePositions(currentX + 2, currentY + 2);
							posChecks.removePieceAt(checkPos);
							movesToMake.add(posChecks);
						}
					}
					else{
						validMove = false;
					}
				}
				
				
			}
			else if(xPos == 7){
				
			}
			else{
				
			}
		}
	}
}
