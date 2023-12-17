package hemtenta;

//Använda hemsidor: w3schools

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Train {
	
	//Skapar objekt för alla platser (skulle använda loop om det var fler men lättare att göra på här med få)
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
	
	//Skapar en array med alla platser i för att kunna loopa genom
	static Seat[] seatList = {one, two, three, four, five, six, seven, eight, nine, ten};
	
	//int för att hålla reda på vilken sträcka man har vald
	static int stretchInt = 0;
	
	
	//Uppdaterar bokningslistan
	static String setBookedListString() {
		String bookedListString = "";
		
		for(Seat x : seatList) {
			bookedListString = bookedListString + "Plats " + x.number + " : " + x.name[stretchInt] + "\n";
		}
		
		return bookedListString;
		
	}

	
	public static void main(String[] args) {

		//Namn för slumpmässig påfyllning av vagnen
		String[] randomNames = {"Isak", "Mae", "Carl", "Felicia", "Theodor", "Hampus", "Sofia", "Anders", "Påven", "Obama"};
		
		
		//GUI shit
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
		
		//Array för DDmenyn för de olika sträckorna
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
		
		//Sätter alla platser i dropdpwnmanyn
		for(Seat x : seatList) {
			seatDropDown.addItem(x.number + " " + x.special);
		}
		
		//Uppdaterar bokningslistan (kommer bara ha tomma platser atm)
		bookedList.setText(setBookedListString());
		
		//Bokningsknappen
		book.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//Tar namnet från namnrutan
				String inputName = nameIn.getText();
				
				//Tar platsnumret från valet i DDmenyin (ja klyddigt men det var bästa sättet jag kom på)
				//(index skulle inte funka eftersom jag tar bort bokade från menyn)
				try {
					String selectionInput = (String) seatDropDown.getSelectedItem();
					String[] parts = selectionInput.split(" ");
					int seatNumber = Integer.valueOf(parts[0]);
					
					//Om en ledig plats på sträckan passar med den valda platsen, sätt det namnet på platsen
					for(Seat x : seatList) {
						if (x.number == seatNumber) {
								x.name[stretchInt] = inputName;
						}
					}
				} catch(Exception NullPointerException){return;} //Om det inte finns några platser gör inget
				
				
				//Uppdaterar DDmenyn för platsval
				seatDropDown.removeAllItems();
				for(Seat x : seatList) {
					if(x.name[stretchInt].equals("")) {
						seatDropDown.addItem(x.number + " " + x.special);
					}
				}
				
				bookedList.setText(setBookedListString());
				
			}
		});
		
		//Fyll vagnen-knapp
		bookRandom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//Loopar genom tomma platser och sätter namn från randomnamn-listan på platserna
				int nameNumber = 0;
				for(Seat x : seatList) {
					if(x.name[stretchInt].equals("")) {
						x.name[stretchInt] = randomNames[nameNumber];
						nameNumber++;
						bookedList.setText(setBookedListString());	
					}
				}
				//Tömmer lediga platser DDmenyn
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
		
		//Idiotlabel som behövdes för att det sista jag lägger in tar upp hela fönstret
		Label invis = new Label();
		f.add(invis);
		
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
