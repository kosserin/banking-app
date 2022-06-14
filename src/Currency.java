import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Currency extends JFrame {
	Currency(String valuta, Long prvoStanje, Long drugoStanje) {
		 this.getContentPane().setBackground(new Color(60, 27, 60)); 
		 this.getContentPane().setLayout(null);
		 this.setSize(420, 420);
		 this.setResizable(false);
		 this.setTitle("Promena valute");
		 Korisnik kor = new Korisnik();
		 kor.setTrenutnaValuta(valuta);
		 kor.setPrvoStanje(prvoStanje);
		 kor.setDrugoStanje(drugoStanje);
		 
		 String[] currency = {"EUR", "RSD", "USD"};
		 
		 JLabel amountLabel = new JLabel();
		 amountLabel.setText("Trenutna valuta je: " + kor.getCurrency());
		 amountLabel.setVisible(true);
		 amountLabel.setBounds(130, 40, 200, 30);
		 amountLabel.setForeground(new Color(230, 230, 230));
		 amountLabel.setFont(new Font(null, Font.PLAIN, 15));
		 this.add(amountLabel);
		 
		 JLabel welcomeLabel = new JLabel("Odaberite zeljenu valutu:");
		 welcomeLabel.setVisible(true);
		 welcomeLabel.setBounds(130, 70, 200, 30);
		 welcomeLabel.setForeground(new Color(230, 230, 230));
		 welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));
		 this.add(welcomeLabel);

		 JComboBox combobox = new JComboBox(currency);
		 combobox.setBounds(110, 100, 200, 30);
		 this.add(combobox);
		 
		 JButton convertBtn = new JButton("Convert");
		 convertBtn.setVisible(true);
		 convertBtn.setBounds(110, 250, 200, 30);
		 convertBtn.setBackground(new Color(230, 230, 230));
		 convertBtn.setFocusable(false);
		 convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountLabel.setText("Trenutna valuta je: " + combobox.getSelectedItem());
				Long firstValue = kor.getFirstValue();
				Long secondValue = kor.getSecondValue();
				String newCurrency = (String) combobox.getSelectedItem();
				if(combobox.getSelectedItem() == "EUR" && kor.getCurrency() == "RSD") {
					Long newFirst = (Long) (firstValue / 117);
					Long newSecond = (Long) (secondValue / 117);
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if(combobox.getSelectedItem() == "RSD" && kor.getCurrency() == "EUR") {
					Long newFirst = (Long) (firstValue * 117);
					Long newSecond = (Long) (secondValue * 117);
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if((combobox.getSelectedItem() == "RSD" && kor.getCurrency() == "RSD") || (combobox.getSelectedItem() == "EUR" && kor.getCurrency() == "EUR") || (combobox.getSelectedItem() == "USD" && kor.getCurrency() == "USD")) {
					Long newFirst = (Long) (firstValue);
					Long newSecond = (Long) (secondValue);
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if(combobox.getSelectedItem() == "USD" && kor.getCurrency() == "RSD") {
					Long newFirst = (Long) (firstValue / 110);
					Long newSecond = (Long) (secondValue / 110);
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if(combobox.getSelectedItem() == "RSD" && kor.getCurrency() == "USD") {
					Long newFirst = (Long) (firstValue * 110);
					Long newSecond = (Long) (secondValue * 110);
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if(combobox.getSelectedItem() == "USD" && kor.getCurrency() == "EUR") {
					Long newFirst = (Long) (firstValue * (93/100));
					Long newSecond = (Long) (secondValue * (93/100));
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else if(combobox.getSelectedItem() == "EUR" && kor.getCurrency() == "USD") {
					Long newFirst = (Long) (firstValue / (93/100));
					Long newSecond = (Long) (secondValue / (93/100));
					kor.updateValue(newFirst, newSecond, newCurrency);
				} else {
					System.out.println("Greska.");
				}
				JOptionPane.showMessageDialog(null, "Uspesno ste konvertovali novac.", "Obavestenje", JOptionPane.DEFAULT_OPTION);
				setVisible(false);
				kor.setVisible(true);
			}
		 });
		 this.add(convertBtn);
		 
		 JButton goBackBtn = new JButton("Vratite se nazad");
		 goBackBtn.setVisible(true);
		 goBackBtn.setBounds(110, 300, 200, 30);
		 goBackBtn.setFocusable(false);
		 goBackBtn.setBackground(new Color(60, 27, 60));
		 goBackBtn.setForeground(new Color(230, 230, 230));
		 goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				kor.setVisible(true);
				Long firstValue = kor.getFirstValue();
				Long secondValue = kor.getSecondValue();
				Long newFirst = (Long) (firstValue);
				Long newSecond = (Long) (secondValue);
				kor.updateValue(newFirst, newSecond, valuta);
			}
		 });
		 this.add(goBackBtn);
	}
}
