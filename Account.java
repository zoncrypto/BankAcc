package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	private int accNumber;
	private Date opened;
	private Customer primaryOwner;
	private Customer secondaryOwner;
	private double balance;
	private List<Transaction> transactions;
	/**
	 * @param accNumber
	 * @param primaryOwner
	 */
	public Account(int accNumber, Customer primaryHolder) {
		this.accNumber = accNumber;
		this.primaryOwner = primaryHolder;
		opened = new Date();
		secondaryOwner = null;
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}
	public int getAccNumber() {
		return accNumber;
	}
	public Date getOpened() {
		return opened;
	}
	public Customer getPrimaryOwner() {
		return primaryOwner;
	}
	public Customer getSecondaryOwner() {
		return secondaryOwner;
	}
	public double getBalance() {
		return balance;
	}
	public void setSecondaryOwner(Customer secondaryOwner) {
		this.secondaryOwner = secondaryOwner;
	}
	
	public void withdraw(double amount, Customer customer) {
		if(amount <= balance && isOwner(customer)) {
			balance -= amount;
			transactions.add(new Withdrawal(amount, customer));
		}
	}
	
	public void deposit(double amount, Customer customer) {
		balance += amount;
		transactions.add(new Deposit(amount, customer));
	}
	
	public void transfer(double amount, Customer customer, Account to) {
		if(amount <= balance && to.isOwner(customer) && isOwner(customer)) {
			balance -= amount;
			to.receiveTransfer(amount);			
			transactions.add(new Transfer(amount, this, to, customer));
		}
	}
	
	private void receiveTransfer(double amount) {
		balance += amount;		
	}
	
	protected void reduceBalance(double amount) {
		if (amount <= balance) {
			balance -= amount;
		}
	}
	
	public boolean isOwner(Customer customer) {
		return customer.equals(primaryOwner) || customer.equals(secondaryOwner);
	}
	
	protected void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", opened=" + opened + ", primaryOwner=" + primaryOwner + ", secondaryOwner=" + secondaryOwner + ", balance=" + balance + "]";
	}
	
	
	
	
	

}
