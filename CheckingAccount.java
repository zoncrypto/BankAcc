package bank;

public class CheckingAccount extends Account{

	public CheckingAccount(int accNumber, Customer primaryHolder) {
		super(accNumber, primaryHolder);
	}
	
	public void draftCheck(double amount, String memo, Customer customer) {
		reduceBalance(amount);
		addTransaction(new DraftCheck(amount,customer, memo));
	}
}
