package ButtonEventHandler;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class ButtonFrame extends JFrame {

	private JButton plainButton;
	private JButton fancyButton;

	public ButtonFrame() {
		super("Testing Button Frame");

		setLayout(new FlowLayout());

		plainButton = new JButton("Plain Button");
		add(plainButton);

		Icon bug1 = new ImageIcon(getClass().getResource(
				"/ButtonEventHandler/res/bug1.GIF"));
		Icon bug2 = new ImageIcon(getClass().getResource(
				"/ButtonEventHandler/res/bug2.GIF"));
		fancyButton = new JButton("Fancy Button", bug1);
		fancyButton.setRolloverIcon(bug2);
		add(fancyButton);

		// now add the event handler to the event source
		ButtonEventHandler buttonEventHandler = new ButtonEventHandler();
		plainButton.addActionListener(buttonEventHandler);
		fancyButton.addActionListener(buttonEventHandler);

	}

	// create the class to handle the events.
	private class ButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String message = "You pressed " + e.getActionCommand();

			if (e.getSource() == plainButton) {
				message += ": Action specifically done for plain button";
			} else if (e.getSource() == fancyButton) {
				message += ": Action specifically done for fancy button";
			}

			JOptionPane.showMessageDialog(ButtonFrame.this, message);
		}
	}
}
