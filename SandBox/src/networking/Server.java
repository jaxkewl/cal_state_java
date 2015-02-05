package networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {

	private JTextField enterField;
	private JLabel displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private int counter = 1;
	private int portNum = 1234;

	public Server() {
		super("Server");

		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendData(e.getActionCommand());
				enterField.setText("");
			}
		});

		add(enterField, BorderLayout.NORTH);
		displayArea = new JLabel();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(500, 350);
		setVisible(true);
	}

	public void runServer() {

		try {

			// create a server on port 1234 with 100 queuable connections
			server = new ServerSocket(portNum, 100);

			while (true) {
				try {
					waitForConnection();
					getStreams();
					processConnection();
				} catch (EOFException exc) {
					displayMessage("\nServer terminated connection");
				} finally {
					closeConnection();
					counter++;
				}
			}

		} catch (IOException e) {
			//
			System.out.println("Conection closed!");
			// e.printStackTrace();
		}

	}

	private void waitForConnection() throws IOException {
		// TODO Auto-generated method stub
		displayMessage("Waiting for connection...\n");
		connection = server.accept();
		displayMessage("Connection " + counter + " received from: "
				+ connection.getInetAddress().getHostName() + " on port: " + portNum);

	}

	private void getStreams() throws IOException {
		// TODO Auto-generated method stub
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();

		input = new ObjectInputStream(connection.getInputStream());

		displayMessage("\nGot I/O streams\n");
	}

	private void processConnection() throws IOException {
		// TODO Auto-generated method stub
		String message = "Connection successful";
		sendData(message);

		setTextFieldEditable(true);

		do {

			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (!message.equals("CLIENT>>> TERMINATE"));
	}

	private void closeConnection() {

		displayMessage("\n Terminating connection");
		setTextFieldEditable(false); // disable enterField
		try {
			output.close(); // close output stream
			input.close();
			connection.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void sendData(String actionCommand) {
		// TODO Auto-generated method stub
		try {
			output.writeObject("SERVER>>> " + actionCommand);
			output.flush();
			displayMessage("\nSERVER>>> " + actionCommand);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void displayMessage(String string) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				displayArea.setText(string);
			}
		});

	}

	private void setTextFieldEditable(boolean b) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				enterField.setEditable(b);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server application = new Server();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer();
	}

}
