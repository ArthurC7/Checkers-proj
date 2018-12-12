import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class CheckerIcon implements Icon{

	private int x;
	private int y;
	private int width;
	private String color;
	private boolean isKing;
	
	
	public CheckerIcon(int width, int x, int y, String color){
		this.x = x;
		this.y = y; 
		this.width = width;
		this.color = color;
		isKing = false;
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void kingMe(){
		isKing = true;
	}
	
	public boolean isKing(){
		return isKing;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double square = new Ellipse2D.Double(this.x, this.y, width, width);
		if(color.equals("Red")) g2.setColor(Color.RED);
		else g2.setColor(Color.BLACK);
		g2.fill(square);
	}
}
