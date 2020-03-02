package demo.designpatterns.statepattern;

public class Account {
	// Customer name,current balance, and current state.
	private String name;
	private double balance;
	private State state;

	// Constructor, sets name, sets balance to 0, and sets state to "NormalState".
	public Account(String n) {
		name = n;
		balance = 0.0;
		state = new NormalState(this);
	}

	// Deposits money into account. Behaviour depends on the current state of the account.
	public void deposit(double amount) {
		System.out.printf("For %s, depositing: %.2f. Initial state: %s\n", name, amount, state.getClass().getSimpleName());
		state = state.doDeposit(amount);
		System.out.printf("New balance: %.2f. New state: %s\n\n", balance, state.getClass().getSimpleName());
	}

	// Withdraws money from account. Behaviour depends on the current state of the account.
	public void withdraw(double amount) {
		System.out.printf("For %s, withdrawing: %.2f. Initial state: %s\n", name, amount, state.getClass().getSimpleName());
		state = state.doWithdraw(amount);
		System.out.printf("New balance: %.2f. New state: %s\n\n", balance, state.getClass().getSimpleName());
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}