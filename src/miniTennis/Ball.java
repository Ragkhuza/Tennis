package miniTennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import miniTennis.Game2.Controller;

public class Ball {
	static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	int z = 0;
	int speed = 1;
	int counter = 0;
	int score = 0;
	private Game2 game;
	public Controller control;

	public Ball(Game2 game) {
		this.game = game;
	}

	// If hits the wall change direction
	void move() {
		boolean change = true;
		if (x + xa < 0)
			xa = speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -speed;
		
		else if (y + y < 0)
			ya = speed;
		
		else if (y + ya > game.getHeight() - DIAMETER)
			ya = -speed;
		
		else if (y + ya > game.getHeight() - DIAMETER - 10)
			game.gameOver();
		
		else if (collision()) {
			ya = -1 - speed;
			y = game.rect.getTopY() - DIAMETER;
			speed++;
			counter++;
			score++;
			
			if(counter == 2) {
				speed -= 1;
				counter = 0;
			}
		}
		else if(speed >= 10) {
			speed -= 1;
		}
		else if (score >= 100){
			game.gameWon();
		}
		else {
			change = false;
		}
				
		if(change)
			Sound.BALL.play();
		
		x = x + xa;
		y = y + ya;
		
		//System.out.println(change);
		//System.out.println("bounced = " + bounced);
		//System.out.println("ya = " + ya);
		//System.out.println("xa = " + xa);
	}

	private boolean collision() {
		return game.rect.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getScore() {
		return score;
	}

	public void Reset() {
		speed = 1;
		
	}

	public void ballReset() {
		x = 1;
		y = 1;
		xa = 1;
		ya = 1;
		speed = 1;
		score = 0;
		counter = 0;
		
	}
}