package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinNumber;
	
	BalanceEnquiry(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon li =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image im = li.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon li2 = new ImageIcon(im);
		JLabel image = new JLabel(li2);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JButton back = new JButton("Back");
		back.setBounds(355,520,130,30);
		back.addActionListener(this);
		image.add(back);
		
		connect c1 = new connect();
		  java.math.BigDecimal balance = java.math.BigDecimal.ZERO;
		try {
	    
				String balanceQuery =
	                "SELECT type, amount FROM bank WHERE pin = ?";


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
	        }catch(Exception e) {
	        		System.out.println(e);
	        	
	        }
		
		JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,13));
		text.setBounds(170,320,300,30);
		image.add(text);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
	}

	public static void main(String[] args) {
	    new BalanceEnquiry("");

	}

}
