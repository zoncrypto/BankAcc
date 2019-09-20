package bank;

import java.util.Date;

public class Transaction {
	private Date date;
	private double amount;
	private Customer customer;
	
	/**
	 * @param amount
	 * @param customer 
	 */
	public Transaction(double amount, Customer customer) {
		this.amount = amount;
		this.customer = customer;
		date = new Date();
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", amount=" + amount + ", customer=" + customer + "]";
	}
}
