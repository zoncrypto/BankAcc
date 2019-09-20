package bank;

public class DraftCheck extends Transaction {
	private String memo;

	/**
	 * @param amount
	 * @param memo
	 */
	public DraftCheck(double amount, Customer customer, String memo) {
		super(amount, customer);
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "DraftCheck [memo=" + memo + ", toString()=" + super.toString() + "]";
	}
}
