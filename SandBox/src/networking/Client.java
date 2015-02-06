package networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.xml.ws.Endpoint;

public class Client extends JFrame {

	private JTextField enterField;
	private JLabel displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String chatServer;
	private Socket client;
	private int portNum = 12345;

	public Client(String host) {
		// TODO Auto-generated constructor stub
		super("Client");

		chatServer = host;

		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendData(e.getActionCommand());
				enterField.setText(""); // clears out the text box to be ready
										// for next statement
			}
		});

		add(enterField, BorderLayout.NORTH);

		displayArea = new JLabel();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(500, 350);
		setVisible(true);
	}

	public void runClient() {

		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (EOFException exc) {
			displayMessage("\nClient terminated connection");
		}

		catch (IOException e) {
			System.out.println("Connection closed");
		} finally {
			closeConnection();
		}

	}

	private void closeConnection() {

		displayMessage("\nClosing Connection");
		setTextFieldEditable(false);

		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setTextFieldEditable(boolean b) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				enterField.setEditable(b);
			}
		});

	}

	private void displayMessage(String string) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayArea.setText(string);
			}
		});
	}

	private void processConnection() throws IOException {
		setTextFieldEditable(true);
		do {

			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				displayMessage("\nUknown object type received");
			}

		} while (!message.equals("SERVER>>> TERMINATE"));

	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();

		input = new ObjectInputStream(client.getInputStream());
		displayMessage("\nGot I/O  streams\n");
	}

	private void connectToServer() throws IOException {
		displayMessage("Attempting connection\n");

		client = new Socket(InetAddress.getByName(chatServer), portNum);

		// display connection information
		displayMessage("Connected to "
				+ client.getInetAddress().getHostAddress() + " on port: " + portNum);
	}

	protected void sendData(String actionCommand) {
		try {
			output.writeObject("CLIENT>>> " + actionCommand);
			output.flush();
			displayMessage("\nCLIENT>>> " + actionCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			displayArea.setText("\nError writing object");
		}

	}

	public static void main(String[] args) {
		Client application;

		if (0 == args.length) {
			application = new Client("127.0.0.1"); // connect to local host
		} else {
			application = new Client(args[0]);
		}
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
	}

}
