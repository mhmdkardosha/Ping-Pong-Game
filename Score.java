package PingPongGame;

import java.awt.*;

public class Score {

	int GAME_LENGTH, GAMEWIDTH;
	int player1 = 0, player2 = 0;

	Score(int gameWidth, int gameLength) {
		GAME_LENGTH = gameLength;
		GAMEWIDTH = gameWidth;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// to draw a dashed line (searched from web)
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0));

		g2d.drawLine((GAMEWIDTH / 2), 0, (GAMEWIDTH / 2), GAME_LENGTH);
		g2d.setColor(new Color(230, 44, 60));
		g2d.setFont(new Font("Consolas", Font.PLAIN, 50));
		g2d.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAMEWIDTH / 2) - 80, 40);
		g2d.setColor(Color.green);
		g2d.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAMEWIDTH / 2) + 25, 40);
	}
}
