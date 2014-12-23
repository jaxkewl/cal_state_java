package menustuff;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Erase extends JFrame {

	private JTextField textField;
	private JButton button;
	private JCheckBox checkBox;
	private JRadioButton triRadioButton;
	private JRadioButton rectRadioButton;

	private ButtonGroup myButtons;

	public Erase() {
		super("Martin Hong Lab 8 GUI tests");

		setLayout(new FlowLayout());

		// add text field
		textField = new JTextField("Something will appear in this!", 15);
		add(textField);

		// add button
		button = new JButton("Square");
		add(button);

		// add checkbox
		checkBox = new JCheckBox("Circle");
		add(checkBox);

		// add radio buttons
		triRadioButton = new JRadioButton("Triangle");
		rectRadioButton = new JRadioButton("Rectangle");
		myButtons = new ButtonGroup();
		myButtons.add(triRadioButton);
		myButtons.add(rectRadioButton);
		add(triRadioButton);
		add(rectRadioButton);

		// add listener to objects
		MyEventListener myEventListener = new MyEventListener();
		button.addActionListener(myEventListener);
		checkBox.addActionListener(myEventListener);
		triRadioButton.addActionListener(myEventListener);
		rectRadioButton.addActionListener(myEventListener);
		textField.addActionListener(myEventListener);
	}

	public static void main(String[] args) {

		Erase lab8 = new Erase();
		lab8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lab8.setSize(400, 500);
		lab8.setVisible(true);
	}

	private class MyEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button) {
				textField.setText("Square");
			} else if (e.getSource() == checkBox) {
				// display if the check box is checked
				if (checkBox.isSelected()) {
					textField.setText("Circle Checked");
				} else {
					textField.setText("Circle Unchecked");
				}
			} else if (e.getSource() == triRadioButton) {
				textField.setText("Triangle");
			} else if (e.getSource() == rectRadioButton) {
				textField.setText("Rectangle");
			} else if (e.getSource() == textField) {
				textField.setText("Something will appear in this!");
			}

		}

	}
}
