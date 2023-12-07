package hemtenta;

public class Employee {

	
	public Employee(int basepay) {
		
	}
	
	static double main() {
		double pay = EmployeeMath.basepay1 * (Math.pow(1.05 , (EmployeeMath.year - 2023)));
		return pay;
	}
	

}
