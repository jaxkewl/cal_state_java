package networking;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ServerUDP extends JFrame {

	private JTextArea displayArea;
	private DatagramSocket socket;

	public ServerUDP() {
		super("Server UDP");

		displayArea = new JTextArea();
		add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);

		try {
			socket = new DatagramSocket(5000);
		} catch (SocketException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void waitForPackets() {
		while (true) {

			byte[] data = new byte[100];
			DatagramPacket receivePacket = new DatagramPacket(data, data.length);
			try {
				socket.receive(receivePacket);

				displayMessage("\nPacket received: "
						+ "\nFrom Host: "
						+ receivePacket.getAddress()
						+ "\nHost port: "
						+ receivePacket.getPort()
						+ "\nLength: "
						+ receivePacket.getLength()
						+ "\nContaining:\n\t "
						+ new String(receivePacket.getData(), 0,
								receivePacket.getLength()));
				sendPacketToClient(receivePacket);

			} catch (IOException e) {

				displayMessage(e + "\n");
				e.printStackTrace();
			}

		}

	}

	private void sendPacketToClient(DatagramPacket receivePacket)
			throws IOException {
		displayMessage("\n\nEcho data to client...");

		DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(),
				receivePacket.getLength(), receivePacket.getAddress(),
				receivePacket.getPort());

		socket.send(sendPacket);
		displayMessage("Packet sent\n");

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
		// TODO Auto-generated method stub
		ServerUDP serverUDP = new ServerUDP();
		serverUDP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverUDP.waitForPackets();
	}

}
