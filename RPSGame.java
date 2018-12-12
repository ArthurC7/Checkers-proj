import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RPSGame {

	
	
	public int RPSPlay(RPSChoices one, RPSChoices two){
		if((one == RPSChoices.PAPER) && (two == RPSChoices.SCISSORS)){
			return 2;
		}
		else if((one == RPSChoices.ROCK) && (two == RPSChoices.SCISSORS)){
			return 1;
		}
		else if((one == RPSChoices.SCISSORS) && (two == RPSChoices.PAPER)){
			return 1;
		}
		else if((one == RPSChoices.SCISSORS) && (two == RPSChoices.ROCK)){
			return 2;
		}
		else if((one == RPSChoices.PAPER) && (two == RPSChoices.ROCK)){
			return 1;
		}
		else if((one == RPSChoices.ROCK) && (two == RPSChoices.PAPER)){
			return 2;
		}
		else{
			return 0;
		}
	}
	
	public static void main(String[] args){
		
		JOptionPane.showMessageDialog(null, "You have won!");
		JFrame frame = new JFrame("Ouch");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
}
