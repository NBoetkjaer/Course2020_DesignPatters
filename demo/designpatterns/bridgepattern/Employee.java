package demo.designpatterns.bridgepattern;

public class Employee {

	private String name;
	private double baseSalary;
	private Role role;

	public Employee(String name, double salary) {
		this.name = name;
		this.baseSalary = salary;
		this.role = new AssociateRole();
	}

	public double getSalary() {
		return role.getEffectiveSalary(baseSalary);
	}

	public void print() {
		System.out.printf("%s, %s, %.2f\n", name, role.getRoleName(), role.getEffectiveSalary(baseSalary));
	}

	public void promote() {
		String currentRoleName = role.getRoleName();
		if (currentRoleName != "Director") {
			if (currentRoleName == "Associate")
				role = new ManagerRole();
			else
				role = new DirectorRole();
		}
	}
}
