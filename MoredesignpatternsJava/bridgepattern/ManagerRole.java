package solution.designpatterns.bridgepattern;

public class ManagerRole implements Role {
	
	public double getEffectiveSalary(double baseSalary) {
		return baseSalary * 1.2;
	}
}
