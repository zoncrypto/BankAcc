package bank;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<Integer, Customer> customers;
	private Map<Integer, Account> accounts;
	
	public Bank() {
		customers = new HashMap<Integer, Customer>();
		accounts = new HashMap<Integer, Account>();
	}
	
	public void registerCustomer(String name, int afm) {
		if(!customers.containsKey(afm)) {
			customers.put(afm, new Customer(name, afm));
		}
	}
	
	public void createCheckingAccount(int accNumber, int afm) {
		if(!accounts.containsKey(accNumber)) {
			if(customers.containsKey(afm)) {
				Customer cust = customers.get(afm);
				accounts.put(accNumber, new CheckingAccount(accNumber, cust));
			}
		}
	}
	
	public void createSavingsAccount(int accNumber, int afm) {
		if(!accounts.containsKey(accNumber)) {
			if(customers.containsKey(afm)) {
				Customer cust = customers.get(afm);
				accounts.put(accNumber, new SavingsAccount(accNumber, cust));
			}
		}
	}
	
	public void addSecondaryOwner(int accNumber, int afm) {
		if(accounts.containsKey(accNumber)) {
			if(customers.containsKey(afm)) {
				Customer customer = customers.get(afm);
				Account account = accounts.get(accNumber);
				account.setSecondaryOwner(customer);
			}
		}
	}
	
	public void withdraw(double amount, int accNumber, int afm) {
		Account account = accounts.get(accNumber);
		Customer customer = customers.get(afm);
		account.withdraw(amount, customer);
	}
	
	public void deposit(double amount, int accNumber, int afm) {
		Account account = accounts.get(accNumber);
		Customer customer = customers.get(afm);
		account.deposit(amount, customer);
	}
	
	public void transfer(double amount, int accNumberFrom, int accNumberTo, int afm) {
		Account accountFrom = accounts.get(accNumberFrom);
		Account accountTo = accounts.get(accNumberTo);
		Customer customer = customers.get(afm);
		accountFrom.transfer(amount, customer, accountTo);
	}
	
	public void draftCheck(double amount, int accNumber, String memo, int afm) {
		Account account = accounts.get(accNumber);
		Customer customer = customers.get(afm);
		if (account instanceof CheckingAccount) { 
			((CheckingAccount)account).draftCheck(amount, memo, customer);
		}
	}
	
	public void buyCOD(double amount, int accNumber, Date start, Date finish, double rate, int afm) {
		Account account = accounts.get(accNumber);
		Customer customer = customers.get(afm);
		if (account instanceof SavingsAccount) { 
			((SavingsAccount)account).buyCOD(amount, customer, start, finish, rate);
		}
	}
	
	
	// YOU MAY USE THE FOLLOWING METHODS FOR INFORMAL VERIFICATION
	public void printCustomersReport() {
		Collection<Customer> cust = customers.values();
		for(Customer customer : cust) {
			System.out.println(customer);
		}
	}
	
	public void printAccountsReport() {
		Collection<Account> acc = accounts.values();
		for(Account account : acc) {
			System.out.println(account);
		}
	}
	
	public void printTransactionsReport(int accNumber) {
		Collection<Account> acc = accounts.values();
		for(Account account : acc) {
			if(account.getAccNumber() == accNumber)
				System.out.println(account);
		}
	}

}
