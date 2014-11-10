package Shapes;

import java.awt.peer.PanelPeer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class ShapesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// get input from user
		String inputString = JOptionPane
				.showInputDialog("1 for rectangles, 2 for ovals");
		int choice = Integer.parseInt(inputString);

		Shapes panel = new Shapes(choice);

		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(300, 300);

		application.setVisible(true);

	}

}
