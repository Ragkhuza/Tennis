package miniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import miniTennis.Game2.Controller;

public class Racket {
	int x = 150;
	static final int Y = 480;
	static int WIDTH = 100;
	static final int HEIGHT = 10;
	int xa = 1;
	int ya = 1;
	int z = 0;
	boolean greatWidth = false;
	private Game2 game2;
	public Controller control;

	public Racket(Game2 game2) {
		this.game2 = game2;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH - game2.getScore2(), HEIGHT);
	}

	public void rightKey(int xa) {
		System.out.println(this.x);
		if (this.x + xa > game2.getWidth() - WIDTH)  {
			greatWidth = true;
		} else {
			greatWidth = false;
		}
		
		if (this.x < game2.getWidth() && greatWidth != true) {
			this.x = this.x + xa + game2.getBounced2();
			}
		else {
			this.x = game2.getWidth() - WIDTH + game2.getBounced2();
		}
		}

	public void leftKey(int xa) {
		if (this.x > 0) {
			this.x = this.x - xa - game2.getBounced2() * 2;
		} else if (this.x - xa > 0) {
			this.x = 0;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH - game2.getScore2(), HEIGHT);
	}

	public int getTopY() {
		return Y;
	}

	public void printRackX() {
		System.out.println(game2.getWidth());
		System.out.println(x);
	}

	public void racketReset() {
		x = 150;
		WIDTH = 100;
	}

	public int getWidthMinScreen() {
		return WIDTH -= game2.getScore2();
	}

}