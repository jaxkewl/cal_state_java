package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir
 */
public class NetworkingClientThreaded implements Runnable {

	ObjectInputStream input;
	ObjectOutputStream output;
	Socket client;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		NetworkingClientThreaded myapp = new NetworkingClientThreaded();
	}


	@Override
	public void run() {
		try {
			client = new Socket("127.0.0.1", 5234);
			System.out.println("Connected to server");
			input = new ObjectInputStream(client.getInputStream());
			output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject("This is from Client");
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
	
	
	
	
}
