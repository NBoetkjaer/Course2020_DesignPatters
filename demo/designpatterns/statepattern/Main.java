package demo.designpatterns.statepattern;

public class Main {

	public static void main(String[] args) {

		Account myAccount = new Account("Leon");

		myAccount.deposit(100);
		myAccount.withdraw(150);
		myAccount.withdraw(25);
		myAccount.deposit(300);
		myAccount.deposit(4000);
		myAccount.deposit(100);
		myAccount.withdraw(3500);
		myAccount.deposit(2000);
	}
}
