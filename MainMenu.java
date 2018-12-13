import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Displays all the possible actions to take with this program. 
 * Will display the single player practice option, the multiplayer option, and
 * the exit feature. 
 * @author XBlad
 *
 */
public class MainMenu {
	
	private int width;
	private int height;
	private JFrame frame;
	
	/**
	 * Initializes all features of the Frame listed above. WindowListeners are added to prevent
	 * accidental exit of the program, which is implemented in other instances of JFrame for 
	 * this program. 
	 * @param frameWidth The width the frame will be.
	 * @param frameHeight The height the frame will be. 
	 */
	public MainMenu(int frameWidth, int frameHeight){
		width = frameWidth;
		height = frameHeight; 
		
		frame = new JFrame("Checkers");
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent w){
				int i=JOptionPane.showConfirmDialog(null, "Would you like to exit?");
                if(i==0){
                	System.exit(0);
                }
			}
		});
		
		JButton option1 = new JButton("Practice");
		JButton option2 = new JButton("Multiplayer");
		JButton option3 = new JButton("Exit");
		
		
		option1.setSize(50, 25);
		option2.setSize(new Dimension(40, 20));
		option3.setSize(40, 20);
		JLabel title = new JLabel("Checkers");
		title.setFont(new Font("Serif", Font.BOLD, 50));
		
		option1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				new CheckerBoard();
			}
			
		});
		option2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		option3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null, "Would you like to exit?");
                if(i==0){
                	System.exit(0);
                }
			}
			
		});
		
		frame.add(title);
		frame.add(option1);
		frame.add(option2);
		frame.add(option3);
		
	}
	
	/**
	 * Returns the JFrame that was made at the instantiation of the object
	 * @return The JFrame encapsulated in the program, to prevent usage of extending 
	 * 
	 */
	public JFrame makeFrame(){
		frame.setVisible(true);
		return frame;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		/*
		JFrame frame = new MainMenu(300,300).makeFrame();
		frame.setVisible(true);
		*/
		
		MainMenu menu = new MainMenu(300,300);
		try {
            Class c = menu.getClass();
            Method m = c.getDeclaredMethod("makeFrame");
            m.invoke(menu, null);
         }
         catch (Throwable e) {
            System.err.println(e);
         }
	}
}
