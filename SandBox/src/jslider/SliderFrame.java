package jslider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {

	private JSlider diameterJSlider;
	private OvalPanel myPanel;

	public SliderFrame() {
		super("My Slider Frame");

		myPanel = new OvalPanel();
		myPanel.setBackground(Color.YELLOW);

		diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		diameterJSlider.setMajorTickSpacing(10);
		diameterJSlider.setPaintTicks(true);

		diameterJSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				myPanel.setDiameter(diameterJSlider.getValue());

			}
		});

		add(diameterJSlider,BorderLayout.NORTH);
		add(myPanel,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SliderFrame sliderFrame = new SliderFrame();
		sliderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sliderFrame.setSize(300, 300);
		sliderFrame.setVisible(true);

	}
}
