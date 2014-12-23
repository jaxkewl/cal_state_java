package LabelFrame;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelFrame extends JFrame {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	public LabelFrame() {
		super("Testing JLabel");

		setLayout(new FlowLayout());

		label1 = new JLabel("label with text");
		label1.setToolTipText("this is label1 tool tip");
		add(label1);

		System.out.println(getClass().getName());
		
		Icon bugIcon = new ImageIcon(getClass().getResource(
				"/LabelFrame/res/bug1.jpg"));
		label2 = new JLabel("Label2 with text and icon", bugIcon,
				SwingConstants.LEFT);
		label2.setToolTipText("this is label2 tool tip");
		add(label2);

		label3 = new JLabel();
		label3.setText("Label 3 with icon and text at bottom");
		label3.setIcon(bugIcon);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("this is label3 tool tip");
		add(label3);

	}

}
