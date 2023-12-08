package hemtenta;
import java.util.*;

public class EmployeeMath {
	
	static int yearTotal;
	static int basepay1;
	static int basepay2;
	static int year = 2023;
	
	public EmployeeMath() {
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hur mycket tjänar grupp 1 i månaden?");
		basepay1 = sc.nextInt();
		
		System.out.println("Hur mycket tjänar grupp 2 i månaden?");
		basepay2 = sc.nextInt();
		
		System.out.println("Hur mycket tjänas totalt på 1 år?");
		yearTotal = sc.nextInt();
		
		System.out.println("Vilket år undrar du om?");
		year = sc.nextInt();
		
		System.out.println(ABCDE.calc(basepay1));
		System.out.println(FG.calc(basepay2));
		System.out.println(HIJ.calc());

	}

}
