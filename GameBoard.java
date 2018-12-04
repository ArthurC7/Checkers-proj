import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel{

	private int squareSize;
	private static final int SQUARE_SIZE = 8;
	private double moveLength;
	private int boardSize;
	
	private SquareIcon[][] board;
	
	public GameBoard(int size){
		boardSize = size;
		squareSize = size/8;
		moveLength = Math.sqrt((squareSize*squareSize)+(squareSize*squareSize));
		board = new SquareIcon[8][8];
	}
	
	public double getMoveLength(){
		return moveLength;
	}
	
	public void makeBoard(){
		int rowOffset = 0;
		
		for(int j = 0; j < 7; j++){
			printOddRow(rowOffset, j);
			rowOffset+=squareSize;
			j++;
			printEvenRow(rowOffset, j);
			rowOffset+=squareSize;
		}
		
		for(SquareIcon[] boardY : board){
			for(SquareIcon i : boardY){
				super.add(new JLabel(i));
			}
		}
		super.setSize(boardSize, boardSize);
	}
	
	public void printOddRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		int columnNumber = 0;
		
		for(int i = 0; i < 4; i++){
			board [rowNumber][i + columnNumber] = new SquareIcon(squareSize, columnOffset, rowOffset, "Black");
			columnOffset+=squareSize;
			columnNumber++;
			board [rowNumber][i + columnNumber] = new SquareIcon(squareSize, columnOffset, rowOffset, "Red");
			columnOffset+=squareSize;
		}
		
	}
	
	public void printEvenRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		int columnNumber = 0;
		
		for(int i = 0; i < 4; i++){
			board [rowNumber][i + columnNumber] = new SquareIcon(squareSize, columnOffset, rowOffset, "Red");
			columnOffset+=squareSize;
			columnNumber++;
			board [rowNumber][i + columnNumber] = new SquareIcon(squareSize, columnOffset, rowOffset, "Black");
			columnOffset+=squareSize;
		}
	}
	
	public static void main(String[] args){
		GameBoard b = new GameBoard(300);
		b.makeBoard();
		
		JFrame frame = new JFrame();
		frame.add(b);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
