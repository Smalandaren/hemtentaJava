package hemtenta;

public class HIJ extends Employee{

	public HIJ(int basepay) {
		super(basepay);
		
	}

	
	
	static double main() {
		double pay = ((EmployeeMath.yearTotal - (EmployeeMath.basepay1 * 12 * 5) - (EmployeeMath.basepay2 * 12 * 2))/3)/12;
		return pay;
	}

}
