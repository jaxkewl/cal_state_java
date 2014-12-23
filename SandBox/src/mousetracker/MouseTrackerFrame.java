package mousetracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame {

	private JLabel statusBar;
	private JPanel mousePanel;

	public MouseTrackerFrame() {

		super("Demonstrating Mouse Events");

		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);

		statusBar = new JLabel("Mouse moved outside Panel");
		add(statusBar, BorderLayout.SOUTH);

		MouseHandler mouseHandler = new MouseHandler();
		mousePanel.addMouseListener(mouseHandler);
		mousePanel.addMouseMotionListener(mouseHandler);

	}

	private class MouseHandler implements MouseMotionListener, MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String output = " mouse clicked at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			String output = " mouse entered at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

			int width = mousePanel.getWidth();
			int height = mousePanel.getHeight();

			// change the color depending on where the mouse entered the panel
			int mouseWidth = e.getX();
			int mouseHeight = e.getY();

			int halfWidth = width / 2;
			int halfHeight = height / 2;

			// quadrant 1
			if (mouseWidth <= halfWidth && mouseHeight <= halfHeight) {
				mousePanel.setBackground(Color.RED);
			} else if (mouseWidth > halfWidth && mouseHeight < halfHeight) {
				mousePanel.setBackground(Color.BLUE);
			} else if (mouseWidth <= halfWidth && mouseHeight > halfHeight) {
				mousePanel.setBackground(Color.BLACK);
			} else if (mouseWidth > halfWidth && mouseHeight > halfHeight) {
				mousePanel.setBackground(Color.YELLOW);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			String output = " mouse exited at " + e.getX() + " " + e.getY();
			statusBar.setText(output);
			mousePanel.setBackground(Color.WHITE);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			String output = " mouse pressed at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			String output = " mouse released at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			String output = " mouse dragged at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			String output = " mouse moved at " + e.getX() + " " + e.getY();
			statusBar.setText(output);

			int width = mousePanel.getWidth();
			int height = mousePanel.getHeight();

			// change the color depending on where the mouse entered the panel
			int mouseWidth = e.getX();
			int mouseHeight = e.getY();

			int halfWidth = width / 2;
			int halfHeight = height / 2;

			// quadrant 1
			if (mouseWidth <= halfWidth && mouseHeight <= halfHeight) {
				mousePanel.setBackground(Color.RED);
			} else if (mouseWidth > halfWidth && mouseHeight < halfHeight) {
				mousePanel.setBackground(Color.BLUE);
			} else if (mouseWidth <= halfWidth && mouseHeight > halfHeight) {
				mousePanel.setBackground(Color.BLACK);
			} else if (mouseWidth > halfWidth && mouseHeight > halfHeight) {
				mousePanel.setBackground(Color.YELLOW);
			}			
			
		}

	}

}
