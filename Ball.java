package PingPongGame;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

	int xvelocity, yvelocity, firstspeed = 3;
	Random random;

	Ball(int x, int y, int WIDTH, int HEIGHT) {
		super(x, y, WIDTH, HEIGHT);
		random = new Random();
		int xdirection = random.nextInt(2);
		int ydirection = random.nextInt(2);
		if (xdirection == 0) {
			xdirection--;
		}
		setXdiriction(xdirection * firstspeed);
		if (ydirection == 0)
			ydirection--;
		setYdiriction(ydirection * firstspeed);

	}

	public void move() {
		y += yvelocity;
		x += xvelocity;
	}

	public void setXdiriction(int randomXdirection) {
		xvelocity = randomXdirection;
	}

	public void setYdiriction(int randomYdirection) {
		yvelocity = randomYdirection;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}
}
