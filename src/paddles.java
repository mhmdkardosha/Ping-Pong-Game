package PingPongGame;

import java.awt.*;
import java.awt.event.*;

public class paddles extends Rectangle {
	int id;
	int yvelocity;
	int speed = 10;

	paddles(int x, int y, int paddleswidth, int paddleslength, int id) {
		super(x, y, paddleswidth, paddleslength);
		this.id = id;

	}

	public void keypressed(KeyEvent e) {
		switch (id) {
			case 1:
				if (e.getKeyCode() == KeyEvent.VK_W) {
					yvelocity = (-speed);
					move();
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					yvelocity = speed;
					move();
				}
				break;
			case 2:
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					yvelocity = (-speed);
					move();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					yvelocity = speed;
					move();
				}
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
			case 1:
				if (e.getKeyCode() == KeyEvent.VK_W) {
					yvelocity = 0;
					move();
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					yvelocity = 0;
					move();
				}
				break;
			case 2:
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					yvelocity = 0;
					move();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					yvelocity = 0;
					move();
				}
				break;
		}
	}

	public void move() {
		y = y + yvelocity;
	}

	public void draw(Graphics g) {
		if (id == 1)
			g.setColor(new Color(230, 44, 60));
		else
			g.setColor(Color.green);

		g.fillRect(x, y, width, height);
	}

}
