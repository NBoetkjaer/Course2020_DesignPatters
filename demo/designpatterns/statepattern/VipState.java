package demo.designpatterns.statepattern;

// State class, represents an account in its "VIP" state.
public class VipState extends State {
	
	// Constructor, receives the Account object that this state is associated with.
	public VipState(Account acc) {
		super(acc);
	}

	// Deposits, and then determines whether to change the state of the account.
	@Override
	public State doDeposit(double amount) {
		theAccount.setBalance(theAccount.getBalance() + amount + VIP_BONUS);
		System.out.printf("Adding a VIP bonus of %.2f\n", VIP_BONUS);
		return this;
	}

	// Withdraws, and then determines whether to change the state of the account.
	@Override
	public State doWithdraw(double amount) {
		
		theAccount.setBalance(theAccount.getBalance() - amount);

		if (theAccount.getBalance() < 0) {
			return new OverdrawnState(theAccount);
		} else if (theAccount.getBalance() < VIP_THRESHOLD) {
			return new NormalState(theAccount);
		} else {
			return this;
		}
	}
}