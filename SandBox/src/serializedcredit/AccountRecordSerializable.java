package serializedcredit;

import java.io.Serializable;

public class AccountRecordSerializable implements Serializable {

	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public AccountRecordSerializable(int acct, String first, String last,
			double bal) {

		account = acct;
		firstName = first;
		lastName = last;
		balance = bal;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
