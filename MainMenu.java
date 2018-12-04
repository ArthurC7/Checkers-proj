import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;

import javax.swing.JButton;

public class MainMenu {
	
	private double width;
	private double height;
	
	public MainMenu(double frameWidth, double frameHeight){
		width = frameWidth;
		height = frameHeight; 
		
		
		
		JButton option1 = new JButton("Practice");
		JButton option2 = new JButton("Multiplayer");
		JButton option3 = new JButton("Exit");
	}
	
	public void paintTitle(Graphics g){
		Font title = new Font("Comic Sans", Font.PLAIN, 20);
		g.setFont(title);
		g.drawString("Checkers", 180, 180);
	}
}
