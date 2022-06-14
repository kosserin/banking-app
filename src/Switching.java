import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Switching extends JFrame {
	
	ButtonGroup saRacun;
	ButtonGroup naRacun;
	JTextField sumaInput;

	Switching(String prvaKartica, String drugaKartica, String trenutnaValuta, Long prvoStanje, Long drugoStanje) {
		 this.getContentPane().setBackground(new Color(60, 27, 60)); 
		 this.getContentPane().setLayout(null);
		 this.setSize(420, 420);
		 this.setResizable(false);
		 this.setTitle("Prebacivanje novca sa jednog racuna na drugi");
		 Korisnik kor = new Korisnik();
		 kor.setTrenutnaValuta(trenutnaValuta);
		 kor.setPrvoStanje(prvoStanje);
		 kor.setDrugoStanje(drugoStanje);
		 
		 JLabel saLabel = new JLabel();
		 saLabel.setText("Molimo odaberite racun sa kojeg zelite da prebacite novac");
		 saLabel.setBounds(40, 20, 350, 30);
		 saLabel.setForeground(new Color(230, 230, 230));
		 this.add(saLabel);
		 
		 JRadioButton saPrvog = new JRadioButton(prvaKartica);
		 saPrvog.setActionCommand(prvaKartica);
		 saPrvog.setVisible(true);
		 saPrvog.setBounds(120, 50, 100, 30);
		 saPrvog.setFocusable(false);
		 saPrvog.setBackground(new Color(60, 27, 60));
		 saPrvog.setForeground(new Color(230, 230, 230));
		 JRadioButton saDrugog = new JRadioButton(drugaKartica);
		 saDrugog.setActionCommand(drugaKartica);
		 saDrugog.setVisible(true);
		 saDrugog.setBounds(225, 50, 100, 30);
		 saDrugog.setFocusable(false);
		 saDrugog.setBackground(new Color(60, 27, 60));
		 saDrugog.setForeground(new Color(230, 230, 230));
		 
		 JLabel naLabel = new JLabel();
		 naLabel.setText("Molimo odaberite racun na koji zelite da prebacite novac");
		 naLabel.setBounds(40, 80, 350, 30);
		 naLabel.setForeground(new Color(230, 230, 230));
		 this.add(naLabel);
		 
		 JRadioButton naPrvi = new JRadioButton(prvaKartica);
		 naPrvi.setActionCommand(prvaKartica);
		 naPrvi.setVisible(true);
		 naPrvi.setBounds(120, 110, 100, 30);
		 naPrvi.setFocusable(false);
		 naPrvi.setBackground(new Color(60, 27, 60));
		 naPrvi.setForeground(new Color(230, 230, 230));
		 JRadioButton naDrugi = new JRadioButton(drugaKartica);
		 naDrugi.setActionCommand(drugaKartica);
		 naDrugi.setVisible(true);
		 naDrugi.setBounds(225, 110, 100, 30);
		 naDrugi.setFocusable(false);
		 naDrugi.setBackground(new Color(60, 27, 60));
		 naDrugi.setForeground(new Color(230, 230, 230));
		 
		 saRacun = new ButtonGroup();	
		 saRacun.add(saPrvog);
		 saRacun.add(saDrugog);
		 naRacun = new ButtonGroup();	
		 naRacun.add(naPrvi);
		 naRacun.add(naDrugi);
		 this.add(saPrvog);
		 this.add(saDrugog);
		 this.add(naPrvi);
		 this.add(naDrugi);
		 
		 JLabel sumaLabel = new JLabel();
		 sumaLabel.setText("Unesite sumu koju zelite da prebacite");
		 sumaLabel.setBounds(110, 140, 350, 30);
		 sumaLabel.setForeground(new Color(230, 230, 230));
		 this.add(sumaLabel);
		 
		 sumaInput = new JTextField();
		 sumaInput.setBounds(110, 170, 200, 30);
		 sumaInput.setBackground(new Color(40, 27, 40));
		 sumaInput.setForeground(new Color(230, 230, 230));
		 sumaInput.setBorder(null);
		 sumaInput.addKeyListener(new KeyListener() {
			 public void keyPressed(KeyEvent e){
			 }

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		 });
		 this.add(sumaInput);
		 
		 JButton transferBtn = new JButton("Prebacite");
		 transferBtn.setVisible(true);
		 transferBtn.setBounds(110, 250, 200, 30);
		 transferBtn.setFocusable(false);
		 transferBtn.setBackground(new Color(230, 230, 230));
		 transferBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(transferBtn)) {
					if(saRacun.getSelection() == null || naRacun.getSelection() == null || sumaInput.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste odabrali racune i uneli cifru.");
					} else if(saRacun.getSelection().getActionCommand() == naRacun.getSelection().getActionCommand()) {
						JOptionPane.showMessageDialog(null, "Odabrali ste iste racune.");
					} else {
						Long sumaVal = Long.parseLong(sumaInput.getText());
						if(prvaKartica == saRacun.getSelection().getActionCommand()) {
							Long newFirst = kor.getFirstValue() - sumaVal;
							Long newSecond = kor.getSecondValue() + sumaVal;
							if(newFirst < 0) {
								JOptionPane.showMessageDialog(null, "Na racunu " + prvaKartica + " nema dovoljno sredstva. Molimo pokusajte ponovo.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
							} else {								
								kor.switchValue(newFirst, newSecond);
								JOptionPane.showMessageDialog(null, "Uspesno ste prebacili novac na drugu karticu.", "Obavestenje", JOptionPane.DEFAULT_OPTION);
								setVisible(false);
								kor.setVisible(true);
							}
						} else {
							Long newFirst = kor.getFirstValue() + sumaVal;
							Long newSecond = kor.getSecondValue() - sumaVal;
							if(newSecond < 0) {
								JOptionPane.showMessageDialog(null, "Na racunu " + drugaKartica + " nema dovoljno sredstva. Molimo pokusajte ponovo.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
							} else {								
								kor.switchValue(newFirst, newSecond);
								JOptionPane.showMessageDialog(null, "Uspesno ste prebacili novac na drugu karticu.", "Obavestenje", JOptionPane.DEFAULT_OPTION);
								setVisible(false);
								kor.setVisible(true);
							}
						}
					}
				}
			}
		 });
		 this.add(transferBtn);
		 
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
				kor.updateValue(newFirst, newSecond, trenutnaValuta);
			}
		 });
		 this.add(goBackBtn);
	}
	
}
