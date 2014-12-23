package paint;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

	private int pointCount = 0;

	private Point[] points = new Point[1000];

	public PaintPanel() {

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent event) {
				if (pointCount < points.length) {

					points[pointCount] = event.getPoint();
					++pointCount;
					repaint();
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw all points in the array
		for (int i = 0; i < pointCount; i++) {
			g.fillOval(points[i].x, points[i].y, 4, 4);
		}
	}

	public static void main(String[] args) {

		JFrame application = new JFrame("a simple paint program");

		PaintPanel paintPanel = new PaintPanel();
		application.add(paintPanel, BorderLayout.CENTER);
		application.add(new JLabel("Drag the mouse"), BorderLayout.SOUTH);

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 400);
		application.setVisible(true);

	}
}
