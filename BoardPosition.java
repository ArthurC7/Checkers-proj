
/**
 * Keeps track of the elements of a position in the game
 * board, from its x and y position on the board, to whether
 * a piece is located on top of it, and will store the piece 
 * it has if necessary. 
 * @author XBlad
 *
 */
public class BoardPosition {

	private int x;
	private int y;
	private boolean hasPiece;
	private CheckerPiece piece;
	
	/**
	 * Constructor for objects of BoardPosition
	 * @param a The x-coordinate of the position
	 * @param b The y-coordinate of the position
	 */
	public BoardPosition(int a, int b) {
		x = a;
		y = b;
		hasPiece = false;
	}
	
	/**
	 * Adds a piece to this given position, but only
	 *  if it is not already occupied. 
	 * @param piece
	 */
	public void addPiece(CheckerPiece piece){
		if(hasPiece){
			this.piece = piece;
			hasPiece = true;
		}
	}
	
	/**
	 * Accessor method to return the x position
	 * @return The x-coordinate of the position
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Accessor method to return the y position
	 * @return The y-coordinate of the position
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Removes a piece at the BoardPosition by just 
	 * setting the hasPiece flag to false, since the addPiece
	 *  method will rewrite the CheckerPiece object
	 */
	public void removePiece(){
		hasPiece = false;
	}
	
	/**
	 * Returns the current checker piece it has, if it does. If not, 
	 * it throws an exception
	 * @return
	 */
	public CheckerPiece getCheckerPiece(){
		if(!hasPiece){
			throw new UnsupportedOperationException();
		}
		return piece;
	}
	
	/*
	 * Simple accessor method to tell if the method has a piece associated 
	 * with it or not. 
	 */
	public boolean hasPiece(){
		return hasPiece;
	}
}
