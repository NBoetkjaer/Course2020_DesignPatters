package demo.designpatterns.bridgepattern;

public class Main {

	public static void main(String[] args) {

		Employee emp1 = new Employee("John Smith", 10000.0);

		System.out.printf("Employee salary is %.2f, full details:\n", emp1.getSalary());
		emp1.print();

		emp1.promote();
		System.out.printf("\nAfter promotion, employee salary is %.2f, full details:\n", emp1.getSalary());
		emp1.print();

		emp1.promote();
		System.out.printf("\nAfter ANOTHER!!! promotion, employee salary is %.2f, full details:\n", emp1.getSalary());
		emp1.print();
	}

}
