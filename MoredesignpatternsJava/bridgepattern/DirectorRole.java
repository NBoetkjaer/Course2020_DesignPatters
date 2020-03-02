package solution.designpatterns.bridgepattern;

public class DirectorRole implements Role {

	public double getEffectiveSalary(double baseSalary) {
		return baseSalary * 1.5;
	}
}