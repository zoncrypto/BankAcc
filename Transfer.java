package bank;

public class Transfer extends Transaction {
	private Account from;
	private Account to;

	public Transfer(double amount, Account from, Account to, Customer customer) {
		super(amount, customer);
		this.from = from;
		this.to = to;
	}

	public Account getFrom() {
		return from;
	}

	public Account getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "Transfer [from=" + from + ", to=" + to + ", toString()=" + super.toString() + "]";
	}
	
	
}
