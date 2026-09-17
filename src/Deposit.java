package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	JTextField textamount;
	JButton deposit,back;
	String pinNumber;
	Deposit(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		ImageIcon li =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		 Image im = li.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		 ImageIcon li2 =new ImageIcon(im);
		 JLabel image = new JLabel(li2);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text = new JLabel("Enter the amount you want to deposit");
		 text.setForeground(Color.white);
		 text.setFont(new Font("System",Font.BOLD,17));
		 text.setBounds(175,300,400,20);
		 image.add(text);
		
		 textamount =new JTextField();
		 textamount.setFont(new Font("System",Font.BOLD,20));
		 textamount.setBounds(170,350,300,25);
		 image.add(textamount);
		 
		 deposit =new JButton("Deposit");
		 deposit.setBounds(360,485,150,30);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		 back = new JButton("Back");
		 back.setBounds(360,520,150,30);
		 back.addActionListener(this);
		 image.add(back);
		 
		 
		 
		setSize(900,900);
		setLocation(350,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == deposit) {
			

	        String amountText = textamount.getText().trim();

	        if (amountText.isEmpty()) {
	            JOptionPane.showMessageDialog(
	                    null, "Please enter the amount you want to deposit."
	            );
	            return;
	        }

	        java.math.BigDecimal amount;

	        try {
	            amount = new java.math.BigDecimal(amountText);

	            if (amount.compareTo(java.math.BigDecimal.ZERO) <= 0) {
	                JOptionPane.showMessageDialog(
	                        null, "Please enter an amount greater than zero."
	                );
	                return;
	            }

	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(
	                    null, "Please enter a valid amount."
	            );
	            return;
	        }

	        try {
	            connect c1 = new connect();

	            String query =
	                    "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";

	            PreparedStatement ps = c1.c.prepareStatement(query);

	            ps.setString(1, pinNumber);
	            ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
	            ps.setString(3, "Deposit");
	            ps.setBigDecimal(4, amount);

	            ps.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Rs. " + amount + " deposited successfully." );

	            setVisible(false);
	            new Transactions(pinNumber).setVisible(true);

	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Unable to complete the deposit.");
	        }
			
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}
	

	public static void main(String[] args) {
		new Deposit("");

	}

}
