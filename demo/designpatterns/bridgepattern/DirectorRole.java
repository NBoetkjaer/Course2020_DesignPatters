package demo.designpatterns.bridgepattern;

public class DirectorRole implements Role {

	public double getEffectiveSalary(double baseSalary) {
		return baseSalary * 1.5;
	}

	public String getRoleName() {
		return "Director";
	}
}