package serializedcredit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CreateSequentialFile {

	private ObjectOutputStream output;

	public void openFile() {

		try {
			output = new ObjectOutputStream(new FileOutputStream("./src/serializedcredit/clients.ser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addRecords() {
		AccountRecordSerializable record;
		int accountNumber = 0;
		String firstName;
		String lastName;
		double balance;

		Scanner input = new Scanner(System.in);
		System.out
				.println("To terminate input, type the end of file indicator when are prompted to input. On Unix/Linux/Mac OS type <ctrl>d then press enter. On windows type <ctrl>z then press enter");
		System.out
				.println("Enter account number(>0), first name, last name and balance:");

		while (input.hasNext()) {
			accountNumber = input.nextInt();
			firstName = input.next();
			lastName = input.next();
			balance = input.nextDouble();

			if (accountNumber > 0) {
				record = new AccountRecordSerializable(accountNumber,
						firstName, lastName, balance);
				try {
					output.writeObject(record);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}

	public void closeFile() {
		if (null != output) {
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CreateSequentialFile application = new CreateSequentialFile();
		application.openFile();
		application.addRecords();
		application.closeFile();
	}
}
