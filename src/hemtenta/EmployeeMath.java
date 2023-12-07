package hemtenta;
import java.util.*;

public class EmployeeMath {
	
	static int basepay1;
	static int basepay2;
	static int yearTotal;
	static int year = 2023;
	
	public EmployeeMath() {
		int basepay1 = 55000;
		int basepay2 = 40000;
		int yearTotal = 6000000;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hur mycket tjänar grupp 1 i månaden?");
		basepay1 = sc.nextInt();
		
		System.out.println("Hur mycket tjänar grupp 2 i månaden?");
		basepay2 = sc.nextInt();
		
		System.out.println("Hur mycket tjänas totalt på 1 år?");
		yearTotal = sc.nextInt();
		
		System.out.println(ABCDE.main());
		System.out.println(FG.main());
		System.out.println(HIJ.main());

	}

}
