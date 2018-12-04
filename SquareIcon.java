import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class SquareIcon implements Icon {
	
	private int x;
	private int y;
	private int width;
	private String color;
	
	
	public SquareIcon(int width, int x, int y, String color){
		this.x = x;
		this.y = y; 
		this.width = width;
		this.color = color;
	}
	
	public void changeColor(String newColor){
		color = newColor;
	}

	public int getIconHeight() {
		return width;
	}

	public int getIconWidth() {
		return width;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double square = new Rectangle2D.Double(this.x, this.y, width, width);
		if(color.equals("Red")) g2.setColor(Color.RED);
		else if(color.equals("Black")) g2.setColor(Color.BLACK);
		else g2.setColor(Color.BLUE);
		g2.fill(square);
	}

}
