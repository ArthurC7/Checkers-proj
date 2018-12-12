import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Tester {
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Blah");
		final JButton btn = new JButton("Close");

		btn.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
		    Window w = SwingUtilities.getWindowAncestor(btn);

		    if (w != null) {
		      w.setVisible(false);
		    }
		  }
		});
		
		frame.add(btn);
		frame.pack();
		frame.setVisible(true);
	}
}
