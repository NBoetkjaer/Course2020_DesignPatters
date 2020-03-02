package solution.designpatterns.bridgepattern;

import java.util.HashMap;

public class Employee {

	private String name;
	private double baseSalary;
	private Role role;
	
	HashMap<Class<? extends Role>, Class<? extends Role>> promotionMap;

	// Initializer block, for common construction code.
	{
		promotionMap = new HashMap<>();

		promotionMap.put(AssociateRole.class, ManagerRole.class);
		promotionMap.put(ManagerRole.class, DirectorRole.class);
		promotionMap.put(DirectorRole.class, null);
	}
	
	
	public Employee(String name, double salary) {
		this.name = name;
		this.baseSalary = salary;
		this.role = new AssociateRole();
	}

	public double getSalary() {
		return role.getEffectiveSalary(baseSalary);
	}

	public void print() {
		System.out.printf("%s, %.2f\n", name, role.getEffectiveSalary(baseSalary));
	}

	public void promote() {
		Class<? extends Role> currentRole = role.getClass();
		
		if (!promotionMap.containsKey(currentRole)) {
			System.out.println("Unknown role");
		}
		else {
			Class<? extends Role> futureRole = promotionMap.get(currentRole);
			if (futureRole == null) {
				System.out.println("Attempt to promote a director");
			}
			else {
				try {
					role = futureRole.newInstance();
				}
				catch (IllegalAccessException ex) {
					System.out.println("Promotion denied.");
				}
				catch (InstantiationException ex) {
					System.out.println("Promotion denied.");
				}
			}
		}
	}
}
