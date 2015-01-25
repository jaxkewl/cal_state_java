package credit;

public enum MenuOption {
	ZERO_BALANCE(1), CREDIT_BALANCE(2), DEBIT_BALANCE(3), END(4);

	private int value;
	
	private MenuOption(int valueOption) {
		value = valueOption;
	}
	
	public int getValue(){
		return value;
	}
}
