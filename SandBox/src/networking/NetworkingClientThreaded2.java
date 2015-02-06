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
public class NetworkingClientThreaded2 {
	int counter = 0;
	ObjectInputStream input;
	ObjectOutputStream output;
	Socket client;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("running client app");
		NetworkingClientThreaded2 myapp = new NetworkingClientThreaded2();
	}

	public NetworkingClientThreaded2() {

		try {
			System.out.println("attempting to connect");
			client = new Socket("127.0.0.1", 12346);
			System.out.println("Connected to server on port "
					+ client.getPort());

			output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject("Bart Simpson : This is from Client "
					+ client.getLocalPort());
			output.flush();

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
			System.out.println("listening for input...");
			// listen for inputs from the client here

			try {
				// read input and output it to the console
				serverText = (String) input.readObject();

				System.out.println("Server has written: " + serverText);
				Random sleepTimer = new Random();
				Thread.sleep(sleepTimer.nextInt(10000));

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
