import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.Position;

/**
 * This class calculates where to initialize pieces on the board
 * calculates the moves of a give piece on the board, and will update
 * GameBoard based on its data
 *
 */
public class CheckerAlgorithm implements Serializable, Cloneable{
	
	private static final int PIECE_COUNT = 12;

	//private ArrayList<CheckerPiece> redPieces;
	//private ArrayList<CheckerPiece> blackPieces;
	private int redPieceCount;
	private int blackPieceCount;
	private BoardPosition[][] gameboard;
	
	/**
	 * Constructor for objects of CheckerAlgorithm; initializes
	 * the counts for both black and red pieces to 12 and then assigns 
	 * a x and y-coordinate for each BoardPosition. Initializing even 
	 * and odd rows are there to establish starting positions of the pieces . 
	 */
	public CheckerAlgorithm(){
		//redPieces = new ArrayList<CheckerPiece>();
		//blackPieces = new ArrayList<CheckerPiece>();
		redPieceCount = PIECE_COUNT;
		blackPieceCount = PIECE_COUNT;
		gameboard = new BoardPosition[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				gameboard[i][j] = new BoardPosition(i, j);
			}
		}
		
		initializeEvenRow(0, PieceColor.BLACK);
		initializeOddRow(1, PieceColor.BLACK);
		initializeEvenRow(2, PieceColor.BLACK);
		initializeOddRow(5, PieceColor.RED);
		initializeEvenRow(7, PieceColor.RED);
		initializeOddRow(7, PieceColor.RED);
	}
	
	public synchronized static CheckerAlgorithm getInstance(){
		CheckerAlgorithm instance = new CheckerAlgorithm();
		return instance;
	}
	
	/**
	 * This is a helper function such that it initializes even rows 
	 * of the standard game board. See constructor for more information
	 * @param row The row of the game board
	 * @param color The color of the piece to color
	 */
	private void initializeEvenRow(int row, PieceColor color){
		for(int i = 0; i < 7 ; i += 2){
			BoardPosition position = gameboard[row][i];
			position.addPiece(new CheckerPiece(color));
		}
	}
	
	/**
	 * This is a helper function such that it initializes odd rows 
	 * of the standard game board. See constructor for more information
	 * @param row The row of the game board
	 * @param color The color of the piece to color
	 */
	private void initializeOddRow(int row, PieceColor color){
		for(int i = 1; i < 8; i += 2){
			BoardPosition position = gameboard[row][i];
			position.addPiece(new CheckerPiece(color));
		}
	}
	
	
	/**
	 * Unfinished. The purpose of this method is for the multiplayer function 
	 * such that after every successful move, the board on the other end is updated with the
	 * board that is calculated through this function. It should look like being on 
	 * the other side of the board if done right. 
	 * @return
	 */
	public CheckerAlgorithm invertBoard() {
		return this;
	}
	
	/**
	 * Given a place to move, the PossiblePositions has been selected and 
	 * will then move the selected to its position. Should it have jumped any 
	 * pieces, those will also be removed here as well. 
	 * @param move Contains location of where to move next and what positions to remove 
	 * pieces at
	 */
	public void movePiece(PossiblePositions move) {
		CheckerPiece piece = gameboard[move.getFromX()][move.getFromY()].getCheckerPiece();
		BoardPosition here = gameboard[move.getFromX()][move.getFromY()];
		here.removePiece();
		BoardPosition moveTo = gameboard[move.getToX()][move.getToY()];
		moveTo.addPiece(piece);
		for(BoardPosition p : move.getPiecesToRemove()){
			p.removePiece();
		}
		
	}
	
	/**
	 * Currently unfinished. Calculates all legal moves when selecting a piece at the position.
	 * @param x The x-position of the game board of which to check the piece for.
	 * @param y The x-position of the game board of which to check the piece for.
	 * @return The ArrayList containing all possible moves to make 
	 */
	public ArrayList<PossiblePositions> getPossibleMoves(int x, int y) {
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
					PossiblePositions move1 = new PossiblePositions(currentX, currentY, position.getX(), position.getY());
					movesToMake.add(move1);
				}
				
				boolean validMove = true;
				
				
				while(validMove){
					BoardPosition checkPos = gameboard[currentX + 1][currentY + 1];	
					if(position.hasPiece() & !position.getCheckerPiece().getColor().equals(piece.getColor())){
						BoardPosition jumpPos = gameboard[currentX + 2][currentY + 2];
						if(!jumpPos.hasPiece()){
							PossiblePositions posChecks = new PossiblePositions(currentX, currentY, currentX + 2, currentY + 2);
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
		return movesToMake;
	}
	
	/**
	 * Accessor function to check number of red pieces
	 * @return The number of red pieces
	 */
	public int getRedPieces(){
		return redPieceCount;
	}
	
	/**
	 * Accessor function to check number of black pieces
	 * @return The number of black pieces
	 */
	public int getBlackPieces(){
		return blackPieceCount;
	}
	
	/**
	 * Accessor function to return the data of the 2-D array
	 * of BoardPosition
	 * @return All data of BoardPosition
	 */
	public BoardPosition[][] getBoardData(){
		return gameboard;
	}
	
	/**
	 * Checkers for the win condition, based on
	 * which number of pieces are at 0.
	 * @return Black if red piece count is 0, vice versa for 
	 * black piece count, reuturns NONE in all other cases, which
	 * means keep playing 
	 */
	public PieceColor checkWin(){
		if(redPieceCount == 0){
			return PieceColor.BLACK;
		}
		else if(blackPieceCount == 0){
			return PieceColor.RED;
		}
		else{
			return PieceColor.NONE;
		}
	}
	
	/*
	public boolean equals(CheckerAlgorithm other){
		if(redPieceCount != other.getRedPieces()){
			return false;
		}
		if(blackPieceCount != other.getBlackPieces()){
			return false;
		}
		for(BoardPosition[] p1 : other.getBoardData()){
			for(BoardPosition p2 : p1){
				
			}
		}
		
		return true;
	}
	*/
}
