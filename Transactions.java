package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit,withdrawl,fastcash,ministatement,exit,pinchange,balanceenquiry;
	String pinNumber;
	
	Transactions(String pinNumber){
		
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon li =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image im = li.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon li2 = new ImageIcon(im);
		JLabel image = new JLabel(li2);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select your Transaction");
		text.setBounds(230,300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit =new JButton("Deposit");
		deposit.setBounds(170,415, 100,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl =new JButton("Cash Withdrawl");
		withdrawl.setBounds(370 ,415, 130,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 450, 100, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(370,450,130,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange =new JButton("Pin Change");
		pinchange.setBounds(170,485,100,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(370,485,130,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(370,520,130,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(e.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}else if(e.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(e.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}else if(e.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}else if(e.getSource() == ministatement) {
			
			new MiniStatement(pinNumber).setVisible(true);
		}
		
		
	}

	public static void main(String[] args) {
		
		new Transactions("");
		
	}
	
}
