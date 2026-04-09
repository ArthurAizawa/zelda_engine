package zelda_engine;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public final int WIDTH = 200;
	public final int HEIGHT = 120;
	public final int SCALE = 0;
	public Game()
	{
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		frame = new JFrame();
		
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
