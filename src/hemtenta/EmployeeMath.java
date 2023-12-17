package hemtenta;
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
		
		
		String[] yearList = {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
		
		JComboBox yearDropDown = new JComboBox(yearList);
		yearDropDown.setBounds(100, 200, 200, 30);
		f.add(yearDropDown);
		
		
		Button btn = new Button("Räkna ut");
		btn.setBounds(100, 250, 150, 50);	
		f.add(btn);
		
		
		JTextArea resultField = new JTextArea();
		resultField.setBounds(100, 350, 300, 200);
		resultField.setEditable(false);
		f.add(resultField);
		
		
		
		
		TextField normalLunchIn = new TextField();
		normalLunchIn.setBounds(550, 50, 250, 30);
		f.add(normalLunchIn);
		
		TextField luxLunchIn = new TextField();
		luxLunchIn.setBounds(550, 100, 250, 30);
		f.add(luxLunchIn);
		
		
		Button calcLunch = new Button("Räkna ut");
		calcLunch.setBounds(550, 150, 150, 50);
		f.add(calcLunch);
		
		
		JTextArea lunchOut = new JTextArea();
		lunchOut.setBounds(550, 230, 250, 150);
		f.add(lunchOut);
		
		
		Label normalLunchText = new Label("Vanliga luncher/år");
		normalLunchText.setBounds(440, 50, 120, 30);
		f.add(normalLunchText);
		
		Label luxLunchText = new Label("Lyxiga luncher/år");
		luxLunchText.setBounds(440, 100, 120, 30);
		f.add(luxLunchText);
		
		
		
		
		Label invis = new Label();
		f.add(invis);
		
		f.setSize(1000, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
				basepay1 = Integer.valueOf(payField1.getText());
				}catch(Exception NumberFormatException) {resultField.setText("Inga bokstäver tack");return;}
				
				try {
				basepay2 = Integer.valueOf(payField2.getText());
				}catch(Exception NumberFormatException) {resultField.setText("Inga bokstäver tack");return;}
				
				try {
				yearTotal = Integer.valueOf(totalPayField.getText());
				}catch(Exception NumberFormatException) {resultField.setText("Inga bokstäver tack");return;}
				
				year = Integer.valueOf((String) yearDropDown.getSelectedItem());
				
				resultField.setText(String.valueOf((int)ABCDE.calc(basepay1)) + " Kr per månad för grupp 1\n");
				resultField.setText(resultField.getText() + String.valueOf((int)FG.calc(basepay2)) + " Kr per månad för grupp 2\n");
				resultField.setText(resultField.getText() + String.valueOf((int)HIJ.calc()) + " Kr per månad för grupp 3");
			}
		});
		
		
		calcLunch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
				int normalLunches = Integer.valueOf(normalLunchIn.getText());
				int luxLunches = Integer.valueOf(luxLunchIn.getText());
				int yearCost = normalLunches * 75 + luxLunches * 125;
				
				lunchOut.setText("Per år: " + (yearCost) + "kr\n"
								+ "Per månad: " + ((yearCost)/12) + "kr\n"
								+ "Per vecka: " + ((yearCost)/52) + "kr\n");
				} catch(Exception NumberFormatException) {
					lunchOut.setText("Siffror tack");
					return;
				}
			}
		});
		
	}

}
