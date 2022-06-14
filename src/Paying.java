import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Paying extends JFrame {
	
	JTextField sumaInput;
	JTextField racunPrimInput;
	JTextField imePrimInput;
	JTextField svrhaInput;
	ButtonGroup saRacun;
	
	Paying(String ime, String prezime, String prvaKartica, String drugaKartica, String trenutnaValuta, Long prvoStanje, Long drugoStanje) {
		 this.getContentPane().setBackground(new Color(60, 27, 60)); 
		 this.getContentPane().setLayout(null);
		 this.setSize(420, 540);
		 this.setResizable(false);
		 this.setTitle("Promena valute");
		 Korisnik kor = new Korisnik();
		 kor.setTrenutnaValuta(trenutnaValuta);
		 kor.setPrvoStanje(prvoStanje);
		 kor.setDrugoStanje(drugoStanje);
		 
		 JLabel amountLabel = new JLabel();
		 amountLabel.setText("Popunite uplatnicu");
		 amountLabel.setVisible(true);
		 amountLabel.setBounds(150, 40, 200, 30);
		 amountLabel.setForeground(new Color(230, 230, 230));
		 amountLabel.setFont(new Font(null, Font.PLAIN, 15));
		 this.add(amountLabel);
		 
		 JLabel saLabel = new JLabel();
		 saLabel.setText("Molimo odaberite racun sa kojeg zelite da uplatite novac");
		 saLabel.setBounds(40, 70, 350, 30);
		 saLabel.setForeground(new Color(230, 230, 230));
		 this.add(saLabel);
		 
		 JRadioButton prviRac = new JRadioButton(prvaKartica);
		 prviRac.setActionCommand(prvaKartica);
		 prviRac.setVisible(true);
		 prviRac.setBounds(120, 100, 100, 30);
		 prviRac.setFocusable(false);
		 prviRac.setBackground(new Color(60, 27, 60));
		 prviRac.setForeground(new Color(230, 230, 230));
		 
		 JRadioButton drugiRac = new JRadioButton(drugaKartica);
		 drugiRac.setActionCommand(drugaKartica);
		 drugiRac.setVisible(true);
		 drugiRac.setBounds(225, 100, 100, 30);
		 drugiRac.setFocusable(false);
		 drugiRac.setBackground(new Color(60, 27, 60));
		 drugiRac.setForeground(new Color(230, 230, 230));
		 
		 saRacun = new ButtonGroup();	
		 saRacun.add(prviRac);
		 saRacun.add(drugiRac);
		 this.add(prviRac);
		 this.add(drugiRac);
		 
		 JLabel racunPrimLabel = new JLabel();
		 racunPrimLabel.setText("Unesite racun primaoca");
		 racunPrimLabel.setBounds(110, 140, 350, 30);
		 racunPrimLabel.setForeground(new Color(230, 230, 230));
		 this.add(racunPrimLabel);
		 
		 racunPrimInput = new JTextField();
		 racunPrimInput.setBounds(110, 170, 200, 30);
		 racunPrimInput.setBackground(new Color(40, 27, 40));
		 racunPrimInput.setForeground(new Color(230, 230, 230));
		 racunPrimInput.setBorder(null);
		 this.add(racunPrimInput);

		 JLabel imePrimLabel = new JLabel();
		 imePrimLabel.setText("Unesite ime primaoca");
		 imePrimLabel.setBounds(110, 200, 350, 30);
		 imePrimLabel.setForeground(new Color(230, 230, 230));
		 this.add(imePrimLabel);
		 
		 imePrimInput = new JTextField();
		 imePrimInput.setBounds(110, 230, 200, 30);
		 imePrimInput.setBackground(new Color(40, 27, 40));
		 imePrimInput.setForeground(new Color(230, 230, 230));
		 imePrimInput.setBorder(null);
		 this.add(imePrimInput);
		 
		 JLabel sumaLabel = new JLabel();
		 sumaLabel.setText("Unesite sumu koju zelite da posaljete");
		 sumaLabel.setBounds(110, 260, 350, 30);
		 sumaLabel.setForeground(new Color(230, 230, 230));
		 this.add(sumaLabel);
		 
		 sumaInput = new JTextField();
		 sumaInput.setBounds(110, 290, 200, 30);
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

		 JLabel svrhaLabel = new JLabel();
		 svrhaLabel.setText("Unesite svrhu uplate");
		 svrhaLabel.setBounds(110, 320, 350, 30);
		 svrhaLabel.setForeground(new Color(230, 230, 230));
		 this.add(svrhaLabel);
		 
		 svrhaInput = new JTextField();
		 svrhaInput.setBounds(110, 350, 200, 30);
		 svrhaInput.setBackground(new Color(40, 27, 40));
		 svrhaInput.setForeground(new Color(230, 230, 230));
		 svrhaInput.setBorder(null);
		 this.add(svrhaInput);
		 
		 JButton transferBtn = new JButton("Posaljite");
		 transferBtn.setVisible(true);
		 transferBtn.setBounds(110, 410, 200, 30);
		 transferBtn.setFocusable(false);
		 transferBtn.setBackground(new Color(230, 230, 230));
		 transferBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == transferBtn) {
					if(saRacun.getSelection() == null) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste odabrali racun.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
					} else if(racunPrimInput.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste uneli racun primaoca.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
					} else if(imePrimInput.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste uneli ime primaoca.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
					} else if(sumaInput.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste uneli sumu.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
					} else if(svrhaInput.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Proverite da li ste uneli svrhu uplate.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
					} else {
						Long sumaVal = Long.parseLong(sumaInput.getText());
						if(saRacun.getSelection().getActionCommand().equals(prvaKartica)) {
							Long newVal = kor.getFirstValue() - sumaVal;
							if(newVal < 0) {
								JOptionPane.showMessageDialog(null, "Na racunu nemate dovoljno sredstva. Molimo pokusajte ponovo.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
							} else {
								JOptionPane.showMessageDialog (null, "Uspesno ste uplatili!", "Obavestenje", JOptionPane.DEFAULT_OPTION);
								kor.switchValue(newVal, kor.getSecondValue());	
								setVisible(false);
								kor.setVisible(true);
							}
						} else {
							Long newVal = kor.getSecondValue() - sumaVal;
							if(newVal < 0) {
								JOptionPane.showMessageDialog(null, "Na racunu nemate dovoljno sredstva. Molimo pokusajte ponovo.", "Obavestenje", JOptionPane.WARNING_MESSAGE);
							} else {
								kor.switchValue(kor.getFirstValue(), newVal);
								JOptionPane.showMessageDialog (null, "Uspesno ste uplatili!", "Obavestenje", JOptionPane.DEFAULT_OPTION);	
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
		 goBackBtn.setBounds(110, 450, 200, 30);
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