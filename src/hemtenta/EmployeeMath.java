package hemtenta;
import java.util.*;

public class EmployeeMath {
	
	static int yearTotal;
	static int year = 2023;
	
	public EmployeeMath() {
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hur mycket tjänar grupp 1 i månaden?");
		ABCDE.basepay = sc.nextInt();
		
		System.out.println("Hur mycket tjänar grupp 2 i månaden?");
		FG.basepay = sc.nextInt();
		
		System.out.println("Hur mycket tjänas totalt på 1 år?");
		yearTotal = sc.nextInt();
		
		System.out.println(ABCDE.main());
		System.out.println(FG.main());
		System.out.println(HIJ.main());

	}

}
