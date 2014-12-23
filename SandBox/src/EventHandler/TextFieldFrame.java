package EventHandler;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame {

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JPasswordField passwordField;

	public TextFieldFrame() {

		super("Here is my text field");
		setLayout(new FlowLayout());

		// text 1
		textField1 = new JTextField(5);
		textField1.setToolTipText("this is text field 1 tool tip");
		add(textField1);

		// text2
		textField2 = new JTextField(
				"this is a text field, the width is determined by how much is in the text box");
		textField2.setToolTipText("text field 2 tool tip");
		add(textField2);

		// text 3
		textField3 = new JTextField("Uneditable Text Field", 30);
		textField3.setEditable(false);
		add(textField3);

		// password field
		passwordField = new JPasswordField("Hidden Text");
		passwordField.setToolTipText("password tool tip");
		add(passwordField);

		// now we need to add the even handler to each component
		TextFieldHandler handler = new TextFieldHandler();

		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);

	}

	private class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String output = "";

			Object eventType = event.getSource();

			if (eventType == textField1) {
				
				output = "textField1 " + event.getActionCommand();
			} else if (eventType == textField2) {
				output = "textField2 " + event.getActionCommand();
			} else if (eventType == textField3) {
				output = "textField3 " + event.getActionCommand();
			} else if (eventType == passwordField) {
				output = "passwordfield " + event.getActionCommand();
			}

			JOptionPane.showMessageDialog(TextFieldFrame.this, output);
			JOptionPane.showMessageDialog(null, output);
		}

	}

}
