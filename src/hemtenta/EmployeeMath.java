package hemtenta;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeMath {
	
	static int yearTotal;
	static int basepay1;
	static int basepay2;
	static int year = 2023;
	
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Idiotlöneprogram");
		
		Label label1 = new Label("Lön grupp 1");
		label1.setBounds(0, 50, 100, 30);
		f.add(label1);
		
		Label label2 = new Label("Lön grupp 2");
		label2.setBounds(0, 100, 100, 30);
		f.add(label2);
		
		Label label3 = new Label("Totallön");
		label3.setBounds(0, 150, 100, 30);
		f.add(label3);
		
		
		TextField payField1 = new TextField();
		payField1.setBounds(100, 50, 250, 30);
		f.add(payField1);
		
		TextField payField2 = new TextField();
		payField2.setBounds(100, 100, 250, 30);
		f.add(payField2);
		
		TextField totalPayField = new TextField();
		totalPayField.setBounds(100, 150, 250, 30);
		f.add(totalPayField);
		
		
		String[] yearList = {"2023", "2024", "2025", "2026", "2027", "2028"};
		
		JComboBox yearDropDown = new JComboBox(yearList);
		yearDropDown.setBounds(100, 200, 200, 30);
		f.add(yearDropDown);
		
		
		Button btn = new Button("Knapp");
		btn.setBounds(100, 250, 150, 50);	
		f.add(btn);
		
		Label invis = new Label();
		f.add(invis);
		
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.out.println(yearDropDown.getSelectedItem());
				
				Scanner sc = new Scanner(System.in);
				
				basepay1 = sc.nextInt();
				
				basepay2 = sc.nextInt();
				
				yearTotal = sc.nextInt();
				
				year = sc.nextInt();
				
				System.out.println(ABCDE.calc(basepay1));
				System.out.println(FG.calc(basepay2));
				System.out.println(HIJ.calc());
				
			}
		});
			
			
		

	}

}
