package networking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClientUDP extends JFrame {

	private JTextField enterField;
	private JTextArea displayArea;
	private DatagramSocket socket;

	public ClientUDP() {
		super("Client UDP");

		enterField = new JTextField();
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
							
				String message = e.getActionCommand();
				displayArea.append("\nSending packets containing: " + message
						+ "\n");
				byte[] data = message.getBytes();
				try {
					DatagramPacket sendPacket = new DatagramPacket(data,
							data.length, InetAddress.getLocalHost(), 5000);

					socket.send(sendPacket);
					displayArea.append("Packet Sent\n");
					displayArea
							.setCaretPosition(displayArea.getText().length());
					enterField.setText("");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(500, 400);
		setVisible(true);

		try {
			socket = new DatagramSocket();

		} catch (SocketException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
	}

	public void waitForPackets() {
		while (true) {
			byte[] data = new byte[100];
			DatagramPacket receivedPacket = new DatagramPacket(data,
					data.length);
			try {
				socket.receive(receivedPacket);

				displayMessage("\nPacket received: "
						+ "\nFrom host "
						+ receivedPacket.getAddress()
						+ " \nHost Port: "
						+ receivedPacket.getPort()
						+ " \nLength: "
						+ receivedPacket.getLength()
						+ "\nContaining:\n\t"
						+ new String(receivedPacket.getData(), 0,
								receivedPacket.getLength()));

			} catch (IOException e) {
				displayMessage(e + "\n");
				e.printStackTrace();
			}

		}
	}

	private void displayMessage(String string) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayArea.append(string);
			}
		});

	}

	public static void main(String[] args) {
		ClientUDP application = new ClientUDP();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();

	}

}
