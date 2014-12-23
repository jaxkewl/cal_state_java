package jslider;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class OvalPanel extends JPanel {
	private int diameter = 10;

	@Override
	public void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		arg0.fillOval(10, 10, diameter, diameter);
	}

	public void setDiameter(int diameter) {
		this.diameter = (diameter >= 0 ? diameter : 10);
		repaint();
	}

	public Dimension getPreferedSize() {
		return new Dimension(200, 200);
	}

	public Dimension getMinSize() {
		return getPreferedSize();
	}
}
