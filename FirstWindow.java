package PingPongGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstWindow implements ActionListener {
	JButton button;
	JFrame frame;
	JLabel label;

	FirstWindow() {
		button = new JButton();
		frame = new JFrame();
		ImageIcon image = new ImageIcon("C:\\Users\\deel\\Downloads\\logo-removebg-preview.png");
		ImageIcon image2 = new ImageIcon("C:\\Users\\deel\\Downloads\\logo2-removebg-preview.png");
		label = new JLabel();

		button.setBounds(130, 300, 200, 50);
		button.setText("Play Game");
		button.setFont(new Font("8514oemRegular", Font.BOLD, 25));
		button.setFocusable(false);
		button.addActionListener(this);
		button.setBackground(Color.LIGHT_GRAY);
		button.setForeground(Color.green);

		label.setIcon(image2);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		frame.setVisible(true);
		frame.setSize(480, 480);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(image.getImage());
		frame.setTitle("Ping Pong Game");
		frame.getContentPane().setBackground(Color.white);
		frame.add(button);
		frame.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			frame.dispose();
			new GameFrame();
		}
	}
}
