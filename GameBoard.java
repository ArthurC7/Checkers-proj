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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel{

	private int squareSize;
	private static final int SQUARE_SIZE = 8;
	private double moveLength;
	private int boardSize;
	//private JPanel checkers;
	
	private static SquareIcon[][] board;
	
	public GameBoard(int size){
		//checkers = new JPanel();
		boardSize = size;
		moveLength = Math.sqrt((squareSize*squareSize)+(squareSize*squareSize));
		board = new SquareIcon[SQUARE_SIZE][SQUARE_SIZE];
		super.setSize(300,300);
		super.setLayout(new GridLayout(8,8, 2, 2));
	}
	
	public double getMoveLength(){
		return moveLength;
	}
	
	
	
	public void makeBoard(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i % 2 == 0 && j % 2 == 0){
					SquareIcon icon = new SquareIcon(37, 0, 0, "Black");
					JLabel label = new JLabel(icon);
					MouseListener m = new MouseActions(icon, label);
					label.addMouseListener(m);
					
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
	
	public void printOddRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		int columnNumber = 0;
		
		for(int i = 0; i < 7; i+=2){
			board [rowNumber][i] = new SquareIcon(squareSize, columnOffset, rowOffset, "Black");
			columnOffset+=squareSize;
			board [rowNumber][i + 1] = new SquareIcon(squareSize, columnOffset, rowOffset, "Red");
			columnOffset+=squareSize;
		}
		
	}
	
	public void printEvenRow(int rowOffset, int rowNumber){
		int columnOffset = 0;
		
		for(int i = 0; i < 7; i+=2){
			board [rowNumber][i] = new SquareIcon(squareSize, columnOffset, rowOffset, "Red");
			columnOffset+=squareSize;
			board [rowNumber][i + 1] = new SquareIcon(squareSize, columnOffset, rowOffset, "Black");
			columnOffset+=squareSize;
		}
	}
	
	public JPanel getBoard(){
		JPanel panel = new JPanel();
		for(SquareIcon[] boardY : board){
			for(SquareIcon i : boardY){
				JLabel label = new JLabel(i);
				//label.setBounds(i.getX(), i.getY(), i.getIconHeight(), i.getIconHeight());
				panel.add(label);
				//System.out.println("Label added");
			}
		}
		return panel;
	}
	
	public static void main(String[] args){
		GameBoard b = new GameBoard(300);
		b.makeBoard();
		
		
		JFrame frame = new JFrame();
		JButton load = new JButton("Load");
		load.setBounds(350, 0, 50, 50);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		//frame.add(load);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = c.NORTHEAST;
		frame.add(b);
		//frame.add(load, c);
		//frame.setSize(500, 500);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
