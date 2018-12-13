import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Large JPanel that will display the game board and all the pieces 
 * on top of it. Done entirely with the Swing libraries, with most 
 * visual assets being displayed as JLabels
 * @author XBlad
 *
 */
public class GameBoard extends JPanel implements Runnable{

	private int squareSize;
	private static final int SQUARE_SIZE = 8;
	private double moveLength;
	private int boardSize;
	//private JPanel checkers;
	private CheckerAlgorithm data;
	
	private static SquareIcon[][] board;
	
	/**
	 * Constructor which will initialize some settings of the JPanel 
	 * @param size
	 */
	public GameBoard(int size){
		data = new CheckerAlgorithm();
		boardSize = size;
		moveLength = Math.sqrt((squareSize*squareSize)+(squareSize*squareSize));
		board = new SquareIcon[SQUARE_SIZE][SQUARE_SIZE];
		super.setSize(300,300);
		super.setLayout(new GridLayout(8,8, 2, 2));
	}
	
	public double getMoveLength(){
		return moveLength;
	}
	
	
	/**
	 * Initializes the board by making SquareIcons and then displaying them 
	 * using JLabel. The many for loops are used to make sure the squares are 
	 * the right color. 
	 */
	public void makeBoard(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i % 2 == 0 && j % 2 == 0){
					Icon icon = new SquareIcon(37, 0, 0, "Black");
					JLabel label = new JLabel(icon);
					
					super.add(label);
					
				}
				else if(i % 2 == 0 && j % 2 != 0){
					SquareIcon icon = new SquareIcon(37, 0, 0, "Red");
					JLabel label = new JLabel(icon);
					/*
					label.addMouseListener(new MouseAdapter(){
						public void MouseClicked(MouseEvent e){
							System.out.println("Color change");
							icon.changeColor("Blue");
							label.repaint();
							checkers.repaint();
						}
					});
					*/
					super.add(label);
				}
				else if(i % 2 != 0 && j % 2 == 0){
					SquareIcon icon = new SquareIcon(37, 0, 0, "Red");
					JLabel label = new JLabel(icon);
					/*
					label.addMouseListener(new MouseAdapter(){
						public void MouseClicked(MouseEvent e){
							System.out.println("Color change");
							icon.changeColor("Blue");
							label.repaint();
							checkers.repaint();
						}
					});
					*/
					super.add(label);
				}
				else{
					SquareIcon icon = new SquareIcon(37, 0, 0, "Black");
					JLabel label = new JLabel(icon);
					/*
					label.addMouseListener(new MouseAdapter(){
						//System.out.println("Color change");
						public void MouseClicked(MouseEvent e){
							icon.changeColor("Blue");
							label.repaint();
							checkers.repaint();
						}
					});
					*/
					super.add(label);
				}
			}
		}
		
		//MouseListener m = new MouseActions(board);
		//super.addMouseListener(m);
	}
	
	/**
	 * Everytime a move is made, the JPanel is updated with the information from
	 * CheckerAlgorithm, by accessing the BoardPosition[][] located within it 
	 */
	public void update(){
		BoardPosition[][] pieces = data.getBoardData();
		for(BoardPosition[] p1 : pieces){
			for(BoardPosition p2 : p1){
				if(p2.hasPiece()){
					Icon i = new CheckerIcon(squareSize - 2, 0, 0, p2.getCheckerPiece().getColor());
					JLabel label = new JLabel(i);
					super.add(label);
				}
			}
		}
		//To be added later: remove a piece implementation, or just move the piece
		super.repaint();
	}
	
	/**
	 * Taking the data from CheckerAlgorithm, selecting a piece on the board
	 * will make it such that all possible moves to make are highlighted in blue. 
	 */
	public void displayMoves(){
		//Implement MouseListener for each Icon to return which its position
		//for x and y
		int x = 0;
		int y = 0;
		ArrayList<PossiblePositions> p = data.getPossibleMoves(x, y);
		for(PossiblePositions p1 : p){
			SquareIcon s = board[p1.getToX()][p1.getToY()];
			//Change squares that can be moved to from their own color to blue
		}
	}
	
	/**
	 * Being given a move to make, this method just passes it on CheckerAlgorithm. 
	 * Later functionality may be added later. 
	 * @param p The position to move the piece to. 
	 */
	public void moveChosen(PossiblePositions p){
		data.movePiece(p);
	}
	


	@Override
	public void run() {
		while(true){
			System.out.println("GameBoard running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
