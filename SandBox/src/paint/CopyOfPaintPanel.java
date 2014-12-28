package paint;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class CopyOfPaintPanel extends JPanel implements Runnable {

	private int pointCount = 0;

	private Point[] points = new Point[1000];

	public CopyOfPaintPanel() {

		MouseAdapter mAdapter = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				if (pointCount < points.length) {

					points[pointCount] = event.getPoint();
					++pointCount;
					repaint();
				}
			}
		};

		addMouseMotionListener(mAdapter);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw all points in the array
		for (int i = 0; i < pointCount; i++) {
			g.fillOval(points[i].x, points[i].y, 4, 4);
		}
	}

	private void setupFrame() {
		JFrame application = new JFrame("a simple paint program");

		CopyOfPaintPanel paintPanel = new CopyOfPaintPanel();
		application.add(paintPanel, BorderLayout.CENTER);
		application.add(new JLabel("Drag the mouse"), BorderLayout.SOUTH);

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 400);
		application.setVisible(true);
	}

	public static void main(String[] args) {
		CopyOfPaintPanel pp = new CopyOfPaintPanel();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(pp);
	}

	@Override
	public void run() {
		setupFrame();
	}
}
