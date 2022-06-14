import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Korisnik extends JFrame {
	private Long prvoStanje = (long) 50000;
	private Long drugoStanje = (long) 32000;
	private String prvaKartica = "1863221312";
	private String drugaKartica = "1863221123";
	private String ime = "Milan";
	private String prezime = "Stojakovic";
	private String trenutnaValuta = "RSD";
	
	JLabel prviLabel;
	JLabel drugiLabel;
	
	Korisnik() {
		 this.getContentPane().setBackground(new Color(60, 27, 60)); 
		 this.getContentPane().setLayout(null);
		 this.setSize(420, 420);
		 this.setTitle("Korisnik");
		 this.setResizable(false);
		 
		 JLabel welcomeLabel = new JLabel("Dobrodosli nazad, " + ime + "!");
		 welcomeLabel.setVisible(true);
		 welcomeLabel.setBounds(130, 40, 200, 30);
		 welcomeLabel.setForeground(new Color(230, 230, 230));
		 welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));
		 this.add(welcomeLabel);
		 
		 JLabel stanjeLabel = new JLabel("Trenutno imate:");
		 stanjeLabel.setVisible(true);
		 stanjeLabel.setBounds(130, 70, 300, 30);
		 stanjeLabel.setForeground(new Color(230, 230, 230));
		 stanjeLabel.setFont(new Font(null, Font.PLAIN, 12));
		 this.add(stanjeLabel);
		 
		 prviLabel = new JLabel();
		 prviLabel.setText(prvaKartica + ": " + prvoStanje + " " + trenutnaValuta);
		 prviLabel.setVisible(true);
		 prviLabel.setBounds(130, 90, 300, 30);
		 prviLabel.setForeground(new Color(230, 230, 230));
		 prviLabel.setFont(new Font(null, Font.PLAIN, 12));
		 this.add(prviLabel);
		 
		 drugiLabel = new JLabel();
		 drugiLabel.setText(drugaKartica + ": " + drugoStanje + " " + trenutnaValuta);
		 drugiLabel.setVisible(true);
		 drugiLabel.setBounds(130, 110, 300, 30);
		 drugiLabel.setForeground(new Color(230, 230, 230));
		 drugiLabel.setFont(new Font(null, Font.PLAIN, 12));
		 this.add(drugiLabel);
		 
		 JButton switchingBtn = new JButton("Prebacite novac");
		 switchingBtn.setVisible(true);
		 switchingBtn.setBounds(110, 150, 200, 30);
		 switchingBtn.setFocusable(false);
		 switchingBtn.setBackground(new Color(230, 230, 230));
		 switchingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Switching sw = new Switching(prvaKartica, drugaKartica, trenutnaValuta, prvoStanje, drugoStanje);
				sw.setVisible(true);
			}
		 });
		 this.add(switchingBtn);
	
		 JButton currencyBtn = new JButton("Promenite valutu");
		 currencyBtn.setVisible(true);
		 currencyBtn.setBounds(110, 200, 200, 30);
		 currencyBtn.setFocusable(false);
		 currencyBtn.setBackground(new Color(230, 230, 230));
		 currencyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Currency curr = new Currency(trenutnaValuta, prvoStanje, drugoStanje);
				curr.setVisible(true);
			}
		 });
		 this.add(currencyBtn);
		 
		 JButton payBtn = new JButton("Platite racun");
		 payBtn.setVisible(true);
		 payBtn.setBounds(110, 250, 200, 30);
		 payBtn.setFocusable(false);
		 payBtn.setBackground(new Color(230, 230, 230));
		 payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Paying pay = new Paying(ime, prezime, prvaKartica, drugaKartica, trenutnaValuta, prvoStanje, drugoStanje);
				pay.setVisible(true);
			}
		 });
		 this.add(payBtn);
		 
		 JButton logOutBtn = new JButton("Odjavite se");
		 logOutBtn.setVisible(true);
		 logOutBtn.setBounds(110, 300, 200, 30);
		 logOutBtn.setFocusable(false);
		 logOutBtn.setBackground(new Color(60, 27, 60));
		 logOutBtn.setForeground(new Color(230, 230, 230));
		 logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login log = new Login();
				log.setVisible(true);
			}
		 });
		 this.add(logOutBtn);
	}

	public String getCurrency() {
		return trenutnaValuta;
	}
	
	public void setTrenutnaValuta(String trenutnaValuta) {
		this.trenutnaValuta = trenutnaValuta;
	}
	
	public void setPrvoStanje(Long prvoStanje) {
		this.prvoStanje = prvoStanje;
	}
	
	public void setDrugoStanje(Long drugoStanje) {
		this.drugoStanje = drugoStanje;
	}
	
	public Long getFirstValue() {
		return prvoStanje;
	}
	
	public Long getSecondValue() {
		return drugoStanje;
	}
	
	public void updateValue(Long first, Long second, String newCurr) {
		prvoStanje = (Long) first;
		drugoStanje = (Long) second;
		trenutnaValuta = newCurr;
		prviLabel.setText(prvaKartica + ": " + prvoStanje + " " + trenutnaValuta);
		drugiLabel.setText(drugaKartica + ": " + drugoStanje + " " + trenutnaValuta);
		return;
	}
	
	public void switchValue(Long first, Long second) {
		prvoStanje = (Long) first;
		drugoStanje = (Long) second;
		prviLabel.setText(prvaKartica + ": " + prvoStanje + " " + trenutnaValuta);
		drugiLabel.setText(drugaKartica + ": " + drugoStanje + " " + trenutnaValuta);
		return;
	}
}
