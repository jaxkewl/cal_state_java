package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir
 */
public class NetworkingServerThreaded {
	Socket con;
	ObjectInputStream input;
	ObjectOutputStream output;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		NetworkingServerThreaded myapp = new NetworkingServerThreaded();
		myapp.myServer();
	}

	public void myServer() {
		try {
			String str = "waiting to read";
			ServerSocket server = new ServerSocket(5234, 100);
			con = server.accept();
			System.out.println("Connected to Client");

			// steps to create multi threaded server

			// create an object of your threaded class
			NetworkingClientThreaded client = new NetworkingClientThreaded();
			ExecutorService thread = Executors.newFixedThreadPool(2);
			
			

			output = new ObjectOutputStream(con.getOutputStream());
			input = new ObjectInputStream(con.getInputStream());
			while (true) {
				str = (String) input.readObject();
				if (str != null)
					System.out.println(str);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			try {
				input.close();
				output.close();
				con.close();

			} catch (IOException e) {

			}
		}
	}
}
