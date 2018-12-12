import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class PlayRPS implements Runnable{
	
	private RPSChoices c1;
	private JFrame frame;

	public PlayRPS(){
		frame = new JFrame("Player 1");
		frame.setLayout(new FlowLayout());
		
		
		JButton rButton = new JButton("Rock");
		rButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				c1 = RPSChoices.ROCK;
			}
			
		});
		JButton pButton = new JButton("Paper");
		pButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				c1 = RPSChoices.PAPER;
			}
			
		});
		JButton sButton = new JButton("Scissors");
		sButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				c1 = RPSChoices.SCISSORS;
			}
			
		});
		
		frame.add(rButton);
		frame.add(pButton);
		frame.add(sButton);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public RPSChoices getChoice(){
		return c1;
	}

	@Override
	public void run() {
		
		
	}
	
	public static void main(String[] args){
		PlayRPS r = new PlayRPS();
	}
}
