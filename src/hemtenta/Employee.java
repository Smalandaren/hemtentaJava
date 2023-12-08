package hemtenta;

public class Employee {

	
	public static double basepay;
	
	
	public Employee(int basepay) {
		
	}

	
	static double calc(int money) {
		double pay = money * (Math.pow(1.05 , (EmployeeMath.year - 2023)));
		return pay;
	}
	

}
