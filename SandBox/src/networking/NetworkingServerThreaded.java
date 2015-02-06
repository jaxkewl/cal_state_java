package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.w3c.dom.css.Counter;

import datastructures.linkedlists.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir
 */
public class NetworkingServerThreaded {
	ArrayList<Socket> connectionList = new ArrayList<Socket>();

	String clientText;

	/**
	 * @param args
	 *            the command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		NetworkingServerThreaded myapp = new NetworkingServerThreaded();
		myapp.myServer();
	}

	// this class represents all the clients the server has started.
	private class MyClient implements Runnable {
		Socket con = new Socket();

		ObjectInputStream input;
		ObjectOutputStream output;

		private int counter = 0;

		public MyClient(Socket con) {
			System.out.println("connected with client on port "
					+ con.getLocalPort());
			this.con = con;
		}

		@Override
		public void run() {
			// we've forked to this thread, lets get all the I/O
			try {

				input = new ObjectInputStream(con.getInputStream());

				output = new ObjectOutputStream(con.getOutputStream());
				output.writeObject("hello from the server "
						+ con.getLocalPort());
				output.flush();

				listenForInputs();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void listenForInputs() {

			while (true) {
				// listen for inputs from the client here
				try {
					System.out.println("listening for input...");
					// read input and output it to the console
					clientText = (String) input.readObject();

					System.out.println("Client: " + con.getLocalPort()
							+ " has written: " + clientText);

					Random sleepTimer = new Random();
					Thread.sleep(sleepTimer.nextInt(8000));

					// every now and then write something out to the clients
					counter++;
					output.writeObject(counter + " hello from the server "
							+ con.getLocalPort());
					output.flush();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SocketException e) {
					System.out.println("client on " + con.getLocalPort()
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

	public void myServer() throws IOException {

		// how many connections? for now let's try 2

		for (int i = 0; i < 2; i++) {
			String str = "waiting for connection on #" + i;
			System.out.println(str);
			ServerSocket server = new ServerSocket(12345 + i, 100);
			Socket tempSocket = server.accept();

			// keep track of the sockets
			connectionList.add(tempSocket);

			System.out.println("Connected to Client");

			// create an object of your threaded class
			ExecutorService thread = Executors.newFixedThreadPool(2);
			thread.execute(new MyClient(tempSocket));
		}
		System.out.println("all clients have connected");

	}
}
