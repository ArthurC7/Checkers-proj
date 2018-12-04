import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JFrame{

	private int squareSize;
	private static final int SQUARE_SIZE = 8;
	private double moveLength;
	private int boardSize;
	
	private SquareIcon[][] board;
	
	public GameBoard(int size){
		super.setSize(size, size);
		boardSize = size;
		squareSize = size/8;
		moveLength = Math.sqrt((squareSize*squareSize)+(squareSize*squareSize));
		board = new SquareIcon[SQUARE_SIZE][SQUARE_SIZE];
	}
	
	public double getMoveLength(){
		return moveLength;
	}
	
	public void makeBoard(){
		int rowOffset = 0;
		
		for(int j = 0; j < 7; j+=2){
			printOddRow(rowOffset, j);
			rowOffset+=squareSize;
			printEvenRow(rowOffset, j+1);
			rowOffset+=squareSize;
		}
		
		for(SquareIcon[] boardY : board){
			for(SquareIcon i : boardY){
				JLabel label = new JLabel(i);
				label.setBounds(i.getX(), i.getY(), i.getIconHeight(), i.getIconHeight());
				super.add(label);
				System.out.println("Label added");
			}
		}
		super.setSize(boardSize, boardSize);
	}
	
	public void printOddRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		int columnNumber = 0;
		
		for(int i = 0; i < 7; i+=2){
			board [rowNumber][i] = new SquareIcon(squareSize, rowOffset, columnOffset, "Black");
			columnOffset+=squareSize;
			columnNumber++;
			board [rowNumber][i + 1] = new SquareIcon(squareSize, rowOffset, columnOffset, "Red");
			columnOffset+=squareSize;
		}
		
	}
	
	public void printEvenRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		
		for(int i = 0; i < 7; i+=2){
			board [rowNumber][i] = new SquareIcon(squareSize, rowOffset, columnOffset, "Red");
			columnOffset+=squareSize;
			board [rowNumber][i + 1] = new SquareIcon(squareSize, rowOffset, columnOffset, "Black");
			columnOffset+=squareSize;
		}
	}
	
	public static void main(String[] args){
		GameBoard b = new GameBoard(300);
		b.makeBoard();
		
		b.setVisible(true);
	}
}
