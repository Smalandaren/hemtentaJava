package hemtenta;

public class Employee {

	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	//Räknar ut lönen för de olika åren för grupp 1 och 2
	static double calc(int money) {
		double pay = money * (Math.pow(1.05 , (EmployeeMath.year - 2023)));
		return pay;
	}
	

}
