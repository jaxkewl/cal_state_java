import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleSwingAnimation implements Runnable {

	private static final Dimension SIZE = new Dimension(600, 600);

	private void createAndShowUI() {
		JFrame frame = new JFrame();
		frame.add(new AnimationPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SimpleSwingAnimation sa = new SimpleSwingAnimation();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(sa);
	}

	@Override
	public void run() {
		createAndShowUI();
	}
}

@SuppressWarnings("serial")
class AnimationPanel extends JPanel {
	private static final int RADIUS = 20;
	private static final int TIMER_DELAY = 200;
	private int xPos = 0;
	private int yPos = 0;

	public AnimationPanel() {
		setBackground(Color.blue);
		Timer timer = new Timer(TIMER_DELAY,
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						xPos+=3;
						yPos+=3;
						repaint();
					}
				});
		timer.start();
	}

	@Override
	// override a Swing JComponent's paintComponent, not the paint method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // again to repaint the screen

		// set antialiasing rendering hints to smooth out the circle
		// this is not necessary but makes for prettier animation
		//Graphics2D g2 = (Graphics2D) g;
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		//		RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.red);
		g.fillOval(xPos - RADIUS, yPos - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}
}