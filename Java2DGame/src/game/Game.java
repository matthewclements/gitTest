package game;

import graphics.Sprite;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	// background
	// private BufferedImage bckgrnd = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//	private Graphics2D g;
	Image bg = Toolkit.getDefaultToolkit().createImage("Resources/Backgrounds/citybg.jpg");

	public boolean run = false;

	private JFrame window;
	
	private Sprite player = new Sprite();

	public Game() {

		// setMinimumSize(new Dimension(WIDTH,HEIGHT));
		// setMaximumSize(new Dimension(WIDTH,HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		window = new JFrame("Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

	public void run() {

		// want to update the game 60 times per second
		double updateFreq = 1000000000.0 / 60.0; // 1 Billion to account for
													// using nanoTimer
		long startTime = System.nanoTime();

		init();

		while (run) {
			long timer = System.nanoTime();
			if ((timer - startTime) >= updateFreq) {
				startTime = System.nanoTime();
				update();

			}
		}
	}

	public void init() {

	}

	public void update() {
		// Draw Background
		Graphics bgObj = getGraphics();
		bgObj.drawImage(bg, 0, 0, null);
		bgObj.dispose();
	}

	public static void main(String[] args) {
		new Game().start();
	}

	public synchronized void start() {
		run = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		run = false;
	}

}
