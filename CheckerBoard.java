import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CheckerBoard {
	
	private String path;
	private GameBoard b;
	
	public CheckerBoard(){
		b = new GameBoard(300);
		b.makeBoard();
		
		
		JFrame frame = new JFrame();
		frame.setSize(350, 400);
		JButton saveButton = new JButton("Save");
		JButton loadButton = new JButton("Load");
		JButton surrenderButton = new JButton("Surrender");
		loadButton.setBounds(0, 0, 50, 50);
		
		frame.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent w){
				int i=JOptionPane.showConfirmDialog(null, "Would you like to exit?");
                if(i==0){
                	frame.dispose();
                }
			}
		});
		
		surrenderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(null, "Would you like to surrender?");
                if(i==0){
                	JOptionPane.showMessageDialog(null, "You have lost!");
                	frame.dispose();
                }
			}
			
		});
		
		/*
		JFileChooser fChooser = new JFileChooser();
		File f = fChooser.getSelectedFile();
		path = f.getAbsolutePath();
		*/
		
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String name = JOptionPane.showInputDialog("Please enter a name");
					FileOutputStream fileStream = new FileOutputStream(name);
					ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
					objectStream.writeObject(b);
					objectStream.close();
					fileStream.close();
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
			
		});
		
		loadButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String name = JOptionPane.showInputDialog("Enter the name of the state to load");
					FileInputStream file = new FileInputStream (name); 
					ObjectInputStream in = new ObjectInputStream(file);  
					b = (GameBoard)in.readObject(); 

					in.close(); 
					file.close(); 
					b.repaint();
				}
				catch (Exception e2){
					e2.printStackTrace();
				}
			}
			
		});

		
		frame.add(saveButton);
		frame.add(loadButton);
		frame.add(surrenderButton);
		frame.add(b);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
