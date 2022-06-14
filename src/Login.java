import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class CreateLoginForm extends JFrame {
	
}

public class Login {
	
	private static JTextField imeInput;
	private static JPasswordField lozInput;
	private static CreateLoginForm form;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			form = new CreateLoginForm();
			form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			form.setSize(420, 420);
			form.setLayout(null);
			form.getContentPane().setBackground(new Color(60, 27, 60));
			form.setResizable(false);
			form.setTitle("Prijavite se");
			
			JLabel imeLabel = new JLabel("Unesite Vase ime:");
			imeLabel.setBounds(20, 10, 180, 30);
			form.add(imeLabel);
			imeLabel.setForeground(new Color(230, 230, 230));
			
			JLabel lozLabel = new JLabel("Unesite Vasu lozinku:");
			lozLabel.setBounds(20, 50, 180, 30);
			form.add(lozLabel);
			lozLabel.setForeground(new Color(230, 230, 230));
			
			imeInput = new JTextField();
			imeInput.setBounds(150, 10, 200, 30);
			imeInput.setBackground(new Color(40, 27, 40));
			imeInput.setForeground(new Color(230, 230, 230));
			imeInput.setBorder(null);
			form.add(imeInput);
			
			lozInput = new JPasswordField();
			lozInput.setBounds(150, 50, 200, 30);
			lozInput.setBackground(new Color(40, 27, 40));
			lozInput.setForeground(new Color(230, 230, 230));
			lozInput.setBorder(null);
			form.add(lozInput);
			
			JButton submitBtn = new JButton("Prijavite se");
			submitBtn.setBounds(170, 100, 180, 30);
			submitBtn.setFocusable(false);
			submitBtn.setBackground(new Color(230, 230, 230));
			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String imeValue = imeInput.getText();
					String lozValue = lozInput.getText();
					if(imeInput.getText().isEmpty() || lozInput.getText().isEmpty())
					 {  
						JOptionPane.showMessageDialog(null, "Niste uneli sve neophodne podatke.");
						imeInput.setBackground(new Color(230, 0, 0));
						lozInput.setBackground(new Color(230, 0, 0));
					 } else if (imeValue.equals("a") && lozValue.equals("a")) {
						 form.dispose();
						 Korisnik page = new Korisnik();
						 page.setVisible(true);
					 } else {
						 JOptionPane.showMessageDialog(null, "Niste uneli ispravne podatke.");
						 imeInput.setBackground(new Color(230, 0, 0));
						 lozInput.setBackground(new Color(230, 0, 0));
					 }

				}
				
			});
			form.add(submitBtn);
			
			
			
			form.setVisible(true);

			
		} catch(Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage()); 
		}
	}

	public void setVisible(boolean b) {
		form.setVisible(true);
		imeInput.setText("");
		lozInput.setText("");
	}

}
