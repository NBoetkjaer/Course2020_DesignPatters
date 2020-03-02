package demo.designpatterns.statepattern;

// State class, represents an account in its "normal" state.
class NormalState extends State
{
    // Constructor, receives the Account object that this state is associated with.
    public NormalState(Account acc) {
    	super(acc);
    }

    // Deposits, and then determines whether to change the state of the account.
    @Override
    public State doDeposit(double amount) {
    	
        theAccount.setBalance(theAccount.getBalance() + amount);

        if (theAccount.getBalance() >= VIP_THRESHOLD) {
            return new VipState(theAccount);
        }
        else {
            return this;
        }
    }

    // Withdraws, and then determines whether to change the state of the account.
    @Override
    public State doWithdraw(double amount) {
    	
		theAccount.setBalance(theAccount.getBalance() - amount);

        if (theAccount.getBalance() < 0) {
            return new OverdrawnState(theAccount);
        }
        else {
            return this;
        }
    }
}
