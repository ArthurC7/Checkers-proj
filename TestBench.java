import static org.junit.Assert.*;

import java.lang.reflect.Method;

import javax.swing.JFrame;

import org.junit.Test;

public class TestBench {

	@Test
	public void invokeTest() {
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
	
	@Test
	public void GameBoardTest(){
		JFrame frame = new JFrame();
		GameBoard b = new GameBoard(300);
		b.makeBoard();
		frame.add(b);
		frame.setVisible(true);
	}

}
