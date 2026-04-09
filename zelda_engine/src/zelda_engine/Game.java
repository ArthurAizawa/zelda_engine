package zelda_engine;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning;
	public final int WIDTH = 160;
	public final int HEIGHT = 120;
	
	public final int SCALE = 3;//MULTIPLICADOR PARA PADRONIZAR A DIMENSAO DA JANELA
	public Game()
	{
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		
	}
	
	public void initFrame() {
		frame = new JFrame("ZELDA INGINE");

		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
		
	}
	
	public synchronized void stop() {
		
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start();
	}
	
	@Override
	public void run() {
		//GAME LOOPING
		long lastTime = System.nanoTime(); //GUARDA A ULTIMA EXECUCAO DO LOOP
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks; //DURACAO DE CADA TICK
		double delta = 0; //CONTROLADOR
		int frames = 0;
		double timer = System.currentTimeMillis(); 
		while(isRunning) {
			long now = System.nanoTime(); //QUANTO PASSOU DESDE O ULTIMO TICK
			delta += (now - lastTime) / ns; 
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			//CONTADOR DE FPS
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		} 
	}

	private void render() {
		// TODO Auto-generated method stub
		
	}

	private void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
