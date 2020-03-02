package demo.designpatterns.statepattern;

//State class, represents an account in its "overdrawn" state.
public class OverdrawnState extends State {
	
	// Constructor, receives the Account object that this state is associated with.
	public OverdrawnState(Account acc) {
		super(acc);
	}

	// Deposits, and then determines whether to change the state of the account.
	@Override
	public State doDeposit(double amount) {
		
		theAccount.setBalance(theAccount.getBalance() + amount);

		if (theAccount.getBalance() >= VIP_THRESHOLD) {
			return new VipState(theAccount);
		} else if (theAccount.getBalance() >= 0) {
			return new NormalState(theAccount);
		} else {
			return this;
		}
	}

	// Does a withdrawal (in fact, it prevents the withdrawal because the account is overdrawn).
	@Override
	public State doWithdraw(double amount) {
		System.out.printf("Insufficient funds to withdraw %.2f\n", amount);
		return this;
	}
}