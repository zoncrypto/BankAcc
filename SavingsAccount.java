package bank;

import java.util.Date;

public class SavingsAccount extends Account{

	public SavingsAccount(int accNumber, Customer primaryHolder) {
		super(accNumber, primaryHolder);
	}
	
	public void buyCOD(double amount, Customer customer, Date start, Date finish, double rate) {
		reduceBalance(amount);
		addTransaction(new BuyCOD(amount, customer, start, finish, rate));
	}
	
	

}
