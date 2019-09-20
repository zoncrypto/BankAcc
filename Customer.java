package bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private int afm;
	private List<Account> accounts;
	
	
	/**
	 * @param name
	 * @param afm
	 */
	public Customer(String name, int afm) {
		this.name = name;
		this.afm = afm;
		accounts = new ArrayList<Account>();
	}
	public String getName() {
		return name;
	}
	public int getAfm() {
		return afm;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", afm=" + afm + ", accounts=" + accounts + "]";
	}
}
