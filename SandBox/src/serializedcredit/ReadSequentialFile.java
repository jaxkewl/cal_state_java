package serializedcredit;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSequentialFile {

	private ObjectInputStream input;

	public void openFile() {
		try {
			input = new ObjectInputStream(new FileInputStream(
					"./src/serializedcredit/clients.ser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readRecords() {
		AccountRecordSerializable record;
		System.out.printf("%-10s %-12s %-12s %10s\n", "Account", "First Name",
				"Last Name", "Balance");
		try {
			while (true) {
				record = (AccountRecordSerializable) input.readObject();
				System.out.printf("%-10s %-12s %-12s %10s\n",
						record.getAccount(), record.getFirstName(),
						record.getLastName(), record.getBalance());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException exc) {
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeFile() {
		try {
			if (null != input) {
				input.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadSequentialFile application = new ReadSequentialFile();
		application.openFile();
		application.readRecords();
		application.closeFile();
	}
}
