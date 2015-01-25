package credit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditInquiry {
	private MenuOption accountType;
	private Scanner input;
	private final static MenuOption[] CHOICES_MENU_OPTIONS = {
			MenuOption.ZERO_BALANCE, MenuOption.CREDIT_BALANCE,
			MenuOption.DEBIT_BALANCE, MenuOption.END };

	private void readRecords() {
		AccountRecord record = new AccountRecord();

		try {
			input = new Scanner(new File("clients.txt"));

			while (input.hasNext()) {
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());

				if (shouldDisplay(record.getBalance())) {
					System.out.printf("%d %s, %s %f", record.getAccount(),
							record.getLastName(), record.getFirstName(),
							record.getBalance());
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != input) {
				input.close();
			}
		}
	}

	private boolean shouldDisplay(double balance) {

		if ((accountType == MenuOption.CREDIT_BALANCE) && balance < 0) {
			return true;
		} else if (accountType == MenuOption.DEBIT_BALANCE && balance < 0) {
			return true;
		} else if (accountType == MenuOption.ZERO_BALANCE && balance < 0) {
			return true;
		}

		return false;
	}
}
