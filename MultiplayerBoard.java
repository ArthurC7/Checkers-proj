import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MultiplayerBoard {
	
	private GameBoard b;
	
	public MultiplayerBoard(){
		b = new GameBoard(300);
		b.makeBoard();
		
		JFrame frame = new JFrame();
		frame.setSize(350, 400);
		JButton surrenderButton = new JButton("Surrender");
		
		surrenderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null, "Would you like to surrender?");
                if(i==0){
                	JOptionPane.showMessageDialog(null, "You have lost!");
                	frame.dispose();
                }
			}
			
		});
		
		frame.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent w){
				int i=JOptionPane.showConfirmDialog(null, "Would you like to surrender?");
                if(i==0){
                	JOptionPane.showMessageDialog(null, "You have lost!");
                	frame.dispose();
                }
			}
		});
		
		
		frame.add(surrenderButton);
		frame.add(b);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
