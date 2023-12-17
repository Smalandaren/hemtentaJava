package hemtenta;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Train {
	
	
	static Seat one = new FirstClass(1);
	static Seat two = new FirstClass(2);
	static Seat three = new Seat(3);
	static Seat four = new Seat(4);
	static Seat five = new Seat(5);
	static Seat six = new Seat(6);
	static Seat seven = new Seat(7);
	static Seat eight = new Seat(8);
	static Seat nine = new Seat(9);
	static Seat ten = new Seat(10);
	
	static Seat[] seatList = {one, two, three, four, five, six, seven, eight, nine, ten};
	
	static int stretchInt = 0;
	
	
	static String setBookedListString() {
		String bookedListString = "";
		
		for(Seat x : seatList) {
			bookedListString = bookedListString + "Plats " + x.number + " : " + x.name[stretchInt] + "\n";
		}
		
		return bookedListString;
		
		
	}

	public static void main(String[] args) {

		String[] randomNames = {"Isak", "Mae", "Carl", "Felicia", "Theodor", "Hampus", "Sofia", "Anders", "Påven", "Obama"};
		
		
		
		JFrame f = new JFrame();
		
		
		Label nameLabel = new Label("Namn");
		nameLabel.setBounds(5, 50, 40, 20);
		f.add(nameLabel);
		
		TextField nameIn = new TextField();
		nameIn.setBounds(50, 50, 200, 20);
		f.add(nameIn);
		
		Label seatDDLabel = new Label("Plats");
		seatDDLabel.setBounds(5, 155, 40, 20);
		f.add(seatDDLabel);
		
		
		String[] stretchList = {"Malmö - Nässjö", "Nässjö - Linköping", "Linköping - Stockholm"};
		
		JComboBox stretchDD = new JComboBox(stretchList);
		stretchDD.setBounds(50, 100, 200, 30);
		f.add(stretchDD);
		
		
		JComboBox seatDropDown = new JComboBox();
		seatDropDown.setBounds(50, 150, 200, 30);
		f.add(seatDropDown);
		
		Button book = new Button("Boka");
		book.setBounds(50, 200, 200, 50);
		f.add(book);
		
		Button bookRandom = new Button("Fyll vagn");
		bookRandom.setBounds(50, 270, 200, 50);
		f.add(bookRandom);
		
		JTextArea bookedList = new JTextArea();
		bookedList.setBounds(50, 350, 300, 160);
		f.add(bookedList);
		
		
		for(Seat x : seatList) {
			seatDropDown.addItem(x.number + " " + x.special);
		}
		
		
		bookedList.setText(setBookedListString());
		
		
		book.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String inputName = nameIn.getText();
				String selectionInput = (String) seatDropDown.getSelectedItem();
				String[] parts = selectionInput.split(" ");
				int seatNumber = Integer.valueOf(parts[0]);
				
				for(Seat x : seatList) {
					if (x.number == seatNumber) {
							x.name[stretchInt] = inputName;
					}
				}
				
				seatDropDown.removeAllItems();
				
				for(Seat x : seatList) {
					if(x.name[stretchInt].equals("")) {
						seatDropDown.addItem(x.number + " " + x.special);
					}
				}
				
				bookedList.setText(setBookedListString());
				
			}
		});
		
		
		bookRandom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int nameNumber = 0;
				for(Seat x : seatList) {
					if(x.name[stretchInt].equals("")) {
						x.name[stretchInt] = randomNames[nameNumber];
						nameNumber++;
						bookedList.setText(setBookedListString());	
					}
				}
				seatDropDown.removeAllItems();
				
			}
		});
		
		stretchDD.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//Uppdaterar vilken sträcka man kollar
				stretchInt = stretchDD.getSelectedIndex();
				
				//Uppdaterar passagerarlistan
				bookedList.setText(setBookedListString());
				
				//Uppdaterar seatdropdownen
				seatDropDown.removeAllItems();
				for(Seat x : seatList) {
					if(x.name[stretchInt].equals("")) {
						seatDropDown.addItem(x.number + " " + x.special);
					}
				}
			}
		});
		
		
		Label invis = new Label();
		f.add(invis);
		
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
