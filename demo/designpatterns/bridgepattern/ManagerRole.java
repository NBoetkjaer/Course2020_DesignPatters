package demo.designpatterns.bridgepattern;

public class ManagerRole implements Role {
	
	public double getEffectiveSalary(double baseSalary) {
		return baseSalary * 1.2;
	}

	public String getRoleName() {
		return "Manager";
	}
}
