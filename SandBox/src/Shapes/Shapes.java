package Shapes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Shapes extends JPanel {

	int userChoice;

	public Shapes(int userChoice) {
		this.userChoice = userChoice;
	}

	public void paintComponent(Graphics g) {

		// call the parent method
		super.paintComponent(g);

		for (int i = 0; i < 10; i++) {

			switch (userChoice) {

			case 1:
				g.setColor(Color.green);
				g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);

				break;

			case 2:
				g.setColor(Color.ORANGE);
				g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;

			}
		}
	}
}
