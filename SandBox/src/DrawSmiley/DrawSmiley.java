package DrawSmiley;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


public class DrawSmiley extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DrawSmiley dSmiley = new DrawSmiley();
		
		JFrame applicationFrame = new JFrame();
		
		applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applicationFrame.add(dSmiley);
		applicationFrame.setSize(430,450);
		applicationFrame.setVisible(true);
		
	}

	public void paintComponent(Graphics g) {
		
		//call parent class
		super.paintComponent(g);
		
		//first draw yellow circle
		g.setColor(Color.yellow);
		g.fillOval(125, 125, 200, 200);
		
		
		//eyes
		g.setColor(Color.BLACK);
		g.fillOval(175, 200, 20, 20);
		g.fillOval(250, 200, 20, 20);
		
		
		//smile
		g.setColor(Color.BLACK);
		g.fillOval(200, 245, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(200, 235, 50, 50);
	}
	
}
