package CheckBox;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {

	private JTextField textField;
	private JCheckBox boldBox;
	private JCheckBox italicsBox;

	public CheckBoxFrame() {

		super("Check Box Frame");
		setLayout(new FlowLayout());

		textField = new JTextField("Watch the font style change", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);

		boldBox = new JCheckBox("Bold");
		add(boldBox);

		italicsBox = new JCheckBox("Italics");
		add(italicsBox);

		CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
		boldBox.addItemListener(checkBoxHandler);
		italicsBox.addItemListener(checkBoxHandler);

	}

	// now we need to create the even handler
	private class CheckBoxHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {

			Font font = null;
			int size = 14;

			if (boldBox.isSelected() && italicsBox.isSelected()) {
				font = new Font("Serif", Font.BOLD + Font.ITALIC, size);
			} else if (italicsBox.isSelected()) {
				font = new Font("Serif", Font.ITALIC, size);
			} else if (boldBox.isSelected()) {
				font = new Font("Serif", Font.BOLD, size);
			} else {
				font = new Font("Serif", Font.PLAIN, size);
			}
			textField.setFont(font);
		}

	}

}
