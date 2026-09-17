package bankManagementSystem;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	
	String pinNumber;
	JButton amount1,amount2,amount3,amount4,amount5,amount6,back;
	
	FastCash(String pinNumber){
		
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon li =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image im = li.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon li2 = new ImageIcon(im);
		JLabel image = new JLabel(li2);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(230,300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		amount1 =new JButton("Rs 100");
		amount1.setBounds(170,415, 100,30);
		amount1.addActionListener(this);
		image.add(amount1);
		
		amount2 =new JButton("Rs 500");
		amount2.setBounds(370 ,415, 130,30);
		amount2.addActionListener(this);
		image.add(amount2);
		
		amount3 = new JButton("Rs 1000");
		amount3.setBounds(170, 450, 100, 30);
		amount3.addActionListener(this);
		image.add(amount3);
		
		amount4 = new JButton("Rs 2000");
		amount4.setBounds(370,450,130,30);
		amount4.addActionListener(this);
		image.add(amount4);
		
		amount5 =new JButton("Rs 5000");
		amount5.setBounds(170,485,100,30);
		amount5.addActionListener(this);
		image.add(amount5);
		
		amount6 = new JButton("Rs 10000");
		amount6.setBounds(370,485,130,30);
		amount6.addActionListener(this);
		image.add(amount6);
		
		back = new JButton("Back");
		back.setBounds(370,520,130,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {

	    if (ae.getSource() == back) {
	        setVisible(false);
	        new Transactions(pinNumber).setVisible(true);
	        return;
	    }

	    // Get the amount from the selected button, e.g. "Rs 100" -> "100"
	    String amountText = ((JButton) ae.getSource()).getText().substring(3);

	    try {
	        java.math.BigDecimal withdrawalAmount =
	                new java.math.BigDecimal(amountText);

	        connect c1 = new connect();

	        // Calculate the current balance for this PIN
	        String balanceQuery =
	                "SELECT type, amount FROM bank WHERE pin = ?";

	        java.math.BigDecimal balance = java.math.BigDecimal.ZERO;

	        try (PreparedStatement ps = c1.c.prepareStatement(balanceQuery)) {
	            ps.setString(1, pinNumber);

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    java.math.BigDecimal transactionAmount =
	                            rs.getBigDecimal("amount");

	                    if ("Deposit".equalsIgnoreCase(rs.getString("type"))) {
	                        balance = balance.add(transactionAmount);
	                    } else if ("Withdrawal".equalsIgnoreCase(rs.getString("type"))) {
	                        balance = balance.subtract(transactionAmount);
	                    }
	                }
	            }
	        }

	        if (balance.compareTo(withdrawalAmount) < 0) {
	            JOptionPane.showMessageDialog(null, "Insufficient Balance");
	            return;
	        }

	        // Record the withdrawal
	        String insertQuery =
	                "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";

	        try (PreparedStatement ps = c1.c.prepareStatement(insertQuery)) {
	            ps.setString(1, pinNumber);
	            ps.setTimestamp(
	                    2, new java.sql.Timestamp(System.currentTimeMillis())
	            );
	            ps.setString(3, "Withdrawal");
	            ps.setBigDecimal(4, withdrawalAmount);

	            ps.executeUpdate();
	        }

	        JOptionPane.showMessageDialog(
	                null, "Rs. " + withdrawalAmount + " debited successfully."
	        );

	        setVisible(false);
	        new Transactions(pinNumber).setVisible(true);

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Unable to process withdrawal.");
	    }
	}
	
	

	public static void main(String[] args) {
		new FastCash("");

	}

}
