import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadServerFile extends JFrame {

	private JTextField enterField;
	private JEditorPane contentsArea;

	// setup the GUI
	public ReadServerFile() {
		// TODO Auto-generated constructor stub
		super("Simple Web Browser");

		enterField = new JTextField("Enter a URL here");
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getThePage(e.getActionCommand());

			}
		});

		add(enterField, BorderLayout.NORTH);

		contentsArea = new JEditorPane();
		contentsArea.setEditable(false);
		contentsArea.setBackground(Color.GRAY);
		contentsArea.addHyperlinkListener(new HyperlinkListener() {

			// if user clicked hyperlink, go to specified page
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

					getThePage(e.getURL().toString());
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane(contentsArea);
		// scrollPane.add(contentsArea);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
	}

	protected void getThePage(String actionCommand) {
		// TODO Auto-generated method stub

		try {
			contentsArea.setPage(actionCommand);
			enterField.setText(actionCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Error retrieving specified URL");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadServerFile application = new ReadServerFile();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
