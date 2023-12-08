package hemtenta;

public class HIJ extends Employee{

	public HIJ() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static double calc() {
		double pay = (((EmployeeMath.yearTotal - (EmployeeMath.basepay1 * 12 * 5) - (EmployeeMath.basepay2 * 12 * 2))/3)/12) * (Math.pow(1.05 , (EmployeeMath.year - 2023)));
		return pay;
	}

}
