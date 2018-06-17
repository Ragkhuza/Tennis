package miniTennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game2 extends JPanel {

	public Game2() {
		KeyListener board = new Controller();
		addKeyListener(board);
		setFocusable(true);
		
		Sound.BACK.loop();
	}

	Ball ball = new Ball(this);
	Racket rect = new Racket(this);

	private void move() {
		ball.move();
		// rect.printRackX();
	}

	public int getBounced2() {
		return ball.getSpeed() + 1;
	}

	public int getScore2() {
		return ball.getScore();
	}
	
	public void gameStart() {
		JOptionPane.showMessageDialog(null, "Start");
	}
	
	public void gameReset() {
		ball.ballReset();
		rect.racketReset();
	}
	
	public void gameWon() {
		JOptionPane.showMessageDialog(null, "Congratulations you won!");
		System.exit(ABORT);
	}
		
	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(null, "Your score is " + ball.score);
		gameReset();
		Sound.BACK.loop();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		rect.paint(g2d);

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(ball.getScore()), 10, 30);

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game2 game = new Game2();
		frame.add(game);
		frame.setSize(400, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.gameStart();

		/*
		 * set score screen JLabel lblNewLabel = new JLabel("123");
		 * lblNewLabel.setBounds(58, 50, 126, 37); frame.add(lblNewLabel);
		 */

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public class Controller implements KeyListener {
		boolean isPressed = false;
		boolean isReleased = false;
		static final int COUNTER = 1;

		public Controller() {
		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (KeyEvent.getKeyText(e.getKeyCode()) == "Left") {
				// System.out.println("You are pressing Left!");
				//isPressed = true;
				rect.leftKey(15);

			} else if (KeyEvent.getKeyText(e.getKeyCode()) == "Right") {
				// System.out.println("You are pressing Right!");
				//isPressed = true;
				rect.rightKey(15);
				
			} else if (KeyEvent.getKeyText(e.getKeyCode()) == "Up") {
				// System.out.println("You are pressing Right!");
				//ball.Reset();

			} else {
				isPressed = false;
			}
			// ball.setYa(2);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//isReleased = true;
			/*
			 * isReleased = true; while (isPressed == false && isReleased ==
			 * true) { if (KeyEvent.getKeyText(e.getKeyCode()) == "Down") {
			 * System.out.println("You are pressing DOWN!"); isReleased = false;
			 * } }
			 */
			// ball.setYa(2);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		public int getCounter() {
			return COUNTER;
		}

		public boolean getIsPressed() {
			return isPressed;
		}

		public boolean isReleased() {
			return isReleased;
		}
	}
}