package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir
 */
public class NetworkingServer {
	Socket con;
	ObjectInputStream input;
	ObjectOutputStream output;
	ServerSocket server;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		NetworkingServer myapp = new NetworkingServer();
		myapp.myServer();
	}

	public void myServer() {
		try {
			String str = "waiting to read";
			server = new ServerSocket(12345, 100);
			System.out.println("Waiting for clients...");
			con = server.accept();
			System.out.println("Connected to Client");
			output = new ObjectOutputStream(con.getOutputStream());
			input = new ObjectInputStream(con.getInputStream());
			while (true) {
				str = (String) input.readObject();
				if (str != null)
					System.out.println(str);
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Ending connection...");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Class Not found...");
		} finally {
			try {
				server.close();
				input.close();
				output.close();
				con.close();

			} catch (IOException e) {

			}
		}
	}
}
