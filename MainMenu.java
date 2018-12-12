import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainMenu {
	
	private int width;
	private int height;
	private JFrame frame;
	
	public MainMenu(int frameWidth, int frameHeight){
		width = frameWidth;
		height = frameHeight; 
		
		frame = new JFrame("Checkers");
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JButton option1 = new JButton("Practice");
		JButton option2 = new JButton("Multiplayer");
		JButton option3 = new JButton("Exit");
		option3.setSize(40, 20);
		option3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null, "Would you like to exit?");
                if(i==0){
                	System.exit(0);
                }
			}
			
		});
		option1.setSize(new Dimension(40, 20));
		option2.setSize(new Dimension(40, 20));
		JLabel title = new JLabel("Checkers");
		title.setBounds(0, 0, 100, 50);
		
		frame.add(title);
		frame.add(option1);
		frame.add(option2);
		frame.add(option3);
		
	}
	
	public void paintTitle(Graphics g){
		Font title = new Font("Comic Sans", Font.PLAIN, 20);
		g.setFont(title);
		g.drawString("Checkers", 180, 180);
	}
	
	public JFrame makeFrame(){
		
		return frame;
	}
	
	public static void main(String[] args){
		JFrame frame = new MainMenu(300,300).makeFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
