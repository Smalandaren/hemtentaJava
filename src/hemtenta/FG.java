package hemtenta;

public class FG extends Employee{

	public FG(int basepay) {
		super(basepay);
		
	}

	static int basepay = EmployeeMath.basepay1;
	
	static double main() {
		double pay = basepay * (Math.pow(1.05 , (EmployeeMath.year - 2023)));
		return pay;
	}
}
