package PingPongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable {

	final int GAME_WIDTH = 1000;
	final int GAME_LENGTH = (int) (GAME_WIDTH * (5.0 / 9.0)); // 5.0/9.0 (standard table size)
	final Dimension ScreenSize = new Dimension(GAME_WIDTH, GAME_LENGTH);
	final int BallDiameter = 20;
	final int paddlesWidth = 30;
	final int paddleslength = 120;
	Thread gamethread;
	Random random;
	Image image;
	Graphics g;
	paddles pd1;
	paddles pd2;
	Ball b;
	Score s;

	GamePanel() {
		newpaddles();
		newball();
		s = new Score(GAME_WIDTH, GAME_LENGTH);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(ScreenSize);
		gamethread = new Thread(this);
		gamethread.start();

	}

	public void newpaddles() {
		pd1 = new paddles(0, (GAME_LENGTH / 2) - (paddleslength / 2), paddlesWidth, paddleslength, 1);
		pd2 = new paddles(GAME_WIDTH - paddlesWidth, (GAME_LENGTH / 2) - (paddleslength / 2), paddlesWidth,
				paddleslength, 2);
	}

	public void newball() {
		random = new Random();
		b = new Ball(GAME_WIDTH / 2 - BallDiameter / 2, random.nextInt(GAME_LENGTH - BallDiameter), BallDiameter,
				BallDiameter);
	}

	public void run() {

		// Game loop we brought from google
		long LastTime = System.nanoTime();
		double fps = 100.0;
		double ns = 1000000000 / fps;
		double delta = 0;
		while (true) {
			long CurrentTime = System.nanoTime();
			delta += ((CurrentTime - LastTime) / ns);
			LastTime = CurrentTime;
			if (delta >= 1) {
				move();
				CheckCollisions();
				repaint();
				delta--;
			}

		}
	}

	public void move() {
		pd1.move();
		pd2.move();
		b.move();
	}

	public void paint(Graphics g) {
		image = createImage(GAME_WIDTH, GAME_LENGTH);
		this.g = image.getGraphics();
		draw(this.g);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) {

		pd1.draw(g);
		pd2.draw(g);
		b.draw(g);
		s.draw(g);
	}

	public void CheckCollisions() {

		// for paddles
		if (pd1.y <= 0)
			pd1.y = 0;
		if (pd1.y >= (GAME_LENGTH - paddleslength))
			pd1.y = (GAME_LENGTH - paddleslength);
		if (pd2.y <= 0)
			pd2.y = 0;
		if (pd2.y >= (GAME_LENGTH - paddleslength))
			pd2.y = (GAME_LENGTH - paddleslength);

		// for ball
		if (b.y <= 0)
			b.setYdiriction(-b.yvelocity);
		if (b.y >= GAME_LENGTH - BallDiameter)
			b.setYdiriction(-b.yvelocity);

		// for ball intersecting with paddle
		if (b.intersects(pd1)) {
			b.xvelocity = (-b.xvelocity);
			b.xvelocity++;
			if (b.yvelocity > 0)
				b.yvelocity++;
			else if (b.yvelocity < 0)
				b.yvelocity--;
			b.setXdiriction(b.xvelocity);
			b.setYdiriction(b.yvelocity);
		}

		if (b.intersects(pd2)) {
			b.xvelocity = Math.abs(b.xvelocity);
			b.xvelocity++;
			if (b.yvelocity > 0)
				b.yvelocity++;
			else if (b.yvelocity < 0)
				b.yvelocity--;
			b.setXdiriction(-b.xvelocity);
			b.setYdiriction(b.yvelocity);
		}

		// giving scores and make a new ball
		if (b.x < 0) {
			s.player2++;
			newball();
		} else if (b.x > (GAME_WIDTH - BallDiameter)) {
			s.player1++;
			newball();
		}
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			pd1.keypressed(e);
			pd2.keypressed(e);
		}

		public void keyReleased(KeyEvent e) {
			pd1.keyReleased(e);
			pd2.keyReleased(e);
		}
	}
}
