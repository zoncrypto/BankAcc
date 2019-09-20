package bank;

import java.util.Date;

public class BuyCOD extends Transaction {
	private Date start;
	private Date finish;
	private double rate;

	/**
	 * @param amount
	 * @param customer
	 * @param start
	 * @param finish
	 * @param amount
	 * @param rate
	 */
	public BuyCOD(double amount, Customer customer, Date start, Date finish, double rate) {
		super(amount, customer);
		this.start = start;
		this.finish = finish;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "BuyCOD [start=" + start + ", finish=" + finish + ", rate=" + rate + ", toString()=" + super.toString() + "]";
	}
	
	
}
