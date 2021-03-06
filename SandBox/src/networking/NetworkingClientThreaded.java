package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir
 */
public class NetworkingClientThreaded {

	ObjectInputStream input;
	ObjectOutputStream output;
	Socket client;
	int counter = 0;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("running client app");
		NetworkingClientThreaded myapp = new NetworkingClientThreaded();
	}

	public NetworkingClientThreaded() {

		try {
			System.out.println("attempting to connect");
			client = new Socket("127.0.0.1", 12345);
			System.out.println("Connected to server on port "
					+ client.getPort());

			// make sure to setup the output stream first because the server is
			// waiting for it.
			// if we setup the input stream first, then both the server and
			// client are both waiting.
			output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject("Homer Simpson : This is from Client "
					+ client.getLocalPort());
			output.flush();

			// now setup the input stream.
			input = new ObjectInputStream(client.getInputStream());

			listenForInputs();
		} catch (IOException e) {
		} finally {
			try {
				input.close();
				output.close();
				client.close();

			} catch (IOException e) {
			}
		}

	}

	private void listenForInputs() {
		String serverText;

		while (true) {
			// listen for inputs from the client here
			try {
				System.out.println("listening for input...");
				// read input and output it to the console
				serverText = (String) input.readObject();

				System.out.println("Server has written: " + serverText);
				Random sleepTimer = new Random();
				Thread.sleep(sleepTimer.nextInt(9000));

				// every now and then write something out to the clients
				
				counter++;
				output.writeObject(counter + " hello from the server "
						+ client.getLocalPort());
				output.flush();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SocketException e) {
				System.out.println("client on " + client.getPort()
						+ " disconnected");
				System.exit(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}

}
