package PingPongGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

	GamePanel panel ;

	GameFrame() {
		panel = new GamePanel();
		ImageIcon img = new ImageIcon("C:\\Users\\deel\\Downloads\\logo-removebg-preview.png");
		this.add(panel);
		this.setTitle("Ping Pong Game");
		this.setIconImage(img.getImage());
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}

}
