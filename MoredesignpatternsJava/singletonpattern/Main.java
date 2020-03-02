package solution.designpatterns.singletonpattern;

public class Main {

	public static void main(String[] args)
	{
		DatabaseConnection d1 = DatabaseConnection.getInstance();
		d1.someQuery();
		
		DatabaseConnection d2 = DatabaseConnection.getInstance();
		d2.someQuery();
		
		System.out.println("Is d1 same object as d2? " + (d1 == d2)); 
	}
}
