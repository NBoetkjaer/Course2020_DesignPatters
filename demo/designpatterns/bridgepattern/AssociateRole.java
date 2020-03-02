package demo.designpatterns.bridgepattern;

public class AssociateRole implements Role {
	
	public double getEffectiveSalary(double baseSalary) {
		return baseSalary;
	}

	public String getRoleName() {
		return "Associate";
	}
}