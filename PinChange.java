package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	
	String pinNumber;
	JButton change,back;
	JPasswordField newpin,renewpin;
	
	PinChange(String pinNumber){
		
		setLayout(null);
		
		ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image im = li.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon li2 = new ImageIcon(im);
		JLabel image = new JLabel(li2);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Change Your PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,20));
		text.setBounds(250,290,400,25);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(240,330,100,20);
		image.add(pintext);
		
		newpin = new JPasswordField();
		newpin.setForeground(Color.black);
		newpin.setFont(new Font("Relaway",Font.BOLD,16));
		newpin.setBackground(Color.white);
		newpin.setBounds(240, 355,200,35);
		image.add(newpin);
		
		JLabel repintext = new JLabel("Re Enter The New PIN:");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(240,400,200,20);
		image.add(repintext);
		
		renewpin = new JPasswordField();
		renewpin.setForeground(Color.black);
		renewpin.setFont(new Font("Relaway",Font.BOLD,16));
		renewpin.setBackground(Color.white);
		renewpin.setBounds(240,425,200,35);
		image.add(renewpin);
		
		change =new JButton("Change");
		change.setBounds(380, 485,130,30);
		change.addActionListener(this);
		image.add(change);
		
		back =new JButton("Back");
		back.setBounds(380, 520,130,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		if(ae.getSource()==change) {
		
			try{
				String npin =newpin.getText();
				String rpin = renewpin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null,"Entered PIN does not match");
					
					return;
				}
				if(newpin.getText().trim().equals("")) {
					
					JOptionPane.showMessageDialog(null,"Please Enter New PIN");
					return;
					
				}
				if(renewpin.getText().trim().equals("")) {
					
					JOptionPane.showMessageDialog(null,"Please RE-enter New PIN");
					return;
					
				}
				
				connect c1 = new connect();
				
				String query ="update bank set pin ='"+rpin+" where pin ='"+pinNumber+"'";
				String query2 ="update login set Pin_Number ='"+rpin+" where Pin_Number ='"+pinNumber+"'";
				String query3 ="update signupthree set Pin_Number ='"+rpin+" where Pin_Number ='"+pinNumber+"'";
				
				c1.s.executeUpdate(query);
				c1.s.executeUpdate(query2);
				c1.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null,"PIN Change Successfully");
			     
				setVisible(false);
				new Transactions(rpin).setVisible(true);
		
			}catch(Exception e) {
			System.out.println(e);
		
			}
		}
	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);

	}

}
