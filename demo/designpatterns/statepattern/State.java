package demo.designpatterns.statepattern;

public abstract class State {
	
	// VIP accounts (balance >= £2000) get a bonus of £10 on each deposit.
	protected static final double VIP_THRESHOLD = 2000;
	protected static final double VIP_BONUS = 10;

	// Back-reference to the Account object, so we can inspect its current balance.
	protected Account theAccount;

	// Constructor.
	public State(Account acc) {
		theAccount = acc;
	}

	// Abstract method, to determine the state of an account after a deposit.
	public abstract State doDeposit(double amount);

	// Abstract method, to determine the state of an account after a withdrawal.
	public abstract State doWithdraw(double amount);
}