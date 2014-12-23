import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapesJPanel2D extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(new GradientPaint(5, 30, Color.BLUE, 35, 100,
				Color.YELLOW, false));
		g2d.fill(new Ellipse2D.Double(5, 30, 65, 100));

		g2d.setStroke(new BasicStroke(1.9f));
		g2d.draw(new Rectangle2D.Double(80, 30, 65, 100));
		
		
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		ShapesJPanel2D shapesJPanel2D = new ShapesJPanel2D();
		jFrame.add(shapesJPanel2D);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400, 400);
		jFrame.setVisible(true);
	}

}
