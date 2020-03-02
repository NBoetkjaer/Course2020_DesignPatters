package solution.designpatterns.bridgepattern;

public class AssociateRole implements Role {
	
	public double getEffectiveSalary(double baseSalary) {
		return baseSalary;
	}
}