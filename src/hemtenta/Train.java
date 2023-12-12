package hemtenta;

import java.util.*;

public class Train {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Seat one = new FirstClass(1, "a");
		Seat two = new FirstClass(2, "b");
		Seat three = new Seat(3, "c");
		Seat four = new Seat(4, "d");
		Seat five = new Seat(5, "");
		Seat six = new Seat(6, "");
		Seat seven = new Seat(7, "");
		Seat eight = new Seat(8, "");
		Seat nine = new Seat(9, "");
		Seat ten = new Seat(10, "");
		
		Seat[] SeatList = {one, two, three, four, five, six, seven, eight, nine, ten};
		
		System.out.println("Vad heter du?");
		String inputName = in.nextLine();
		
		System.out.println("Var vill du sitta? Plats 1-2 är första klass, 3-10 är bordplats");
		int inputNumber = Integer.valueOf(in.nextLine());
		
		
		for(Seat x : SeatList) {
			if (x.number == inputNumber) {
				if(x.name.equals("")) {
					x.name = inputName;
					System.out.println("Du sitter på plats " + x.number + " som är " + x.special);
				} else {
					System.out.println("Den platsen är bokad");
				}
			}
		}
	}

}
