package hemtenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Translator {

	public static void main(String[] args) {
		
		//GUI shit
		
		JFrame f = new JFrame("Translator");
		
		TextField input = new TextField();
		input.setBounds(50, 50, 200, 30);
		f.add(input);
		
		Label fromLabel = new Label("Från");
		fromLabel.setBounds(50, 100, 200, 20);
		f.add(fromLabel);
		
		//Array som används till dropdownmenyn
		String[] languages = {"Svenska", "Engelska", "Spanska", "Italienska"};
		
		JComboBox languageInDD = new JComboBox(languages);
		languageInDD.setBounds(50, 120, 200, 30);
		f.add(languageInDD);
		
		
		Label toLabel = new Label("Till");
		toLabel.setBounds(50, 180, 200, 20);
		f.add(toLabel);
		
		JComboBox languageOutDD = new JComboBox(languages);
		languageOutDD.setBounds(50, 200, 200, 30);
		f.add(languageOutDD);
		
		
		Button translateButton = new Button("Översätt");
		translateButton.setBounds(50, 260, 200, 50);
		f.add(translateButton);
		
		
		JTextArea outputField = new JTextArea();
		outputField.setBounds(50, 340, 200, 30);
		f.add(outputField);
		
		
		//Listor med orden på de olika språken där indexen representerar ordet
		String[] swedish = {"Katt", "Hund", "Fisk", "Fågel", "Dator", "Soptunna", "Träd", "Gren", "Pelikan", "Fiskmås"};
		String[] english = {"Cat", "Dog", "Fish", "Bird", "Computer", "Trash can", "Tree", "Branch", "Pelican", "Seagull"};
		String[] spanish = {"Gato", "Perro", "Pez", "Pájaro", "Computadora", "Basura", "Árbol", "Rama", "Pelícano", "Gaviota"};
		String[] italian = {"Gatto", "Cane", "Pescare", "Uccello", "Computer", "Pattumiera", "Albero", "Ramo", "Pellicano", "Gabbiano"};
		
		//Lista med listorna för att kunna byta mellan språken
		String[][] languageList = {swedish, english, spanish, italian};
		
		
		translateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (input.getText().equals("")) {return;}
				
				//Indexvariabler för de olika språken
				int inputLanguage = languageInDD.getSelectedIndex();
				int outputLanguage = languageOutDD.getSelectedIndex();
				
				
				String inputWord = input.getText();
				inputWord = inputWord.substring(0, 1).toUpperCase() + inputWord.substring(1).toLowerCase();
				
				//Håller reda på vilket ord man är på och om ordet hittats
				int wordIndex = 0;
				boolean found = false;
				
				//Loopar genom inputspråkets ord och ser om inputordet finns i inputspråkets ord
				for (String x : languageList[inputLanguage]) {
					if (x.equals(inputWord)) {
						//Sätter outputen till ordet med index wordIndex i listan med index outputLanguage i listan languageList
						outputField.setText(languageList[outputLanguage][wordIndex]);
						found = true;
					}
					wordIndex++;
					
				}
				
				//Om ordet inte fanns i inputspråkets lista
				if (!found) {
					outputField.setText("Ordet hittades inte");
				}
			}
		});
		
		
		Label invis = new Label();
		f.add(invis);
		
		f.setSize(400, 600);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
