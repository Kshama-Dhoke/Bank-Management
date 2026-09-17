package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBank extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    LoginBank() {

        setTitle("ATM - Login");
        setSize(850, 500);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Background
        getContentPane().setBackground(new Color(18, 32, 55));

        // Main white panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(150, 45, 550, 370);
        add(panel);

        // ATM Logo
        ImageIcon ic = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.jpg")
        );

        Image i2 = ic.getImage().getScaledInstance(
                80, 80, Image.SCALE_SMOOTH
        );

        JLabel imageLabel = new JLabel(new ImageIcon(i2));
        imageLabel.setBounds(235, 15, 80, 80);
        panel.add(imageLabel);

        // Welcome text
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setForeground(new Color(18, 32, 55));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBounds(100, 95, 350, 35);
        panel.add(text);

        // Card Number
        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Arial", Font.BOLD, 16));
        cardno.setBounds(70, 150, 130, 25);
        panel.add(cardno);

        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        cardTextField.setBounds(210, 148, 260, 30);
        panel.add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Arial", Font.BOLD, 16));
        pin.setBounds(70, 195, 130, 25);
        panel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        pinTextField.setBounds(210, 193, 260, 30);
        panel.add(pinTextField);

        // Sign In button
        login = new JButton("SIGN IN");
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBackground(new Color(30, 100, 200));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setBounds(210, 245, 120, 35);
        login.addActionListener(this);
        panel.add(login);

        // Clear button
        clear = new JButton("CLEAR");
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBackground(new Color(90, 90, 90));
        clear.setForeground(Color.WHITE);
        clear.setFocusPainted(false);
        clear.setBounds(350, 245, 120, 35);
        clear.addActionListener(this);
        panel.add(clear);

        // Sign Up button
        signup = new JButton("CREATE ACCOUNT");
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBackground(new Color(18, 32, 55));
        signup.setForeground(Color.WHITE);
        signup.setFocusPainted(false);
        signup.setBounds(210, 295, 260, 35);
        signup.addActionListener(this);
        panel.add(signup);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {

            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {

            String cardNumber = cardTextField.getText().trim();
            String pinNumber = new String(pinTextField.getPassword());

            if (cardNumber.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Please enter your card number."
                );
                return;
            }

            if (pinNumber.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Please enter your PIN."
                );
                return;
            }

            try {

                connect c = new connect();

                String query =
                        "SELECT * FROM login WHERE Card_Number = ? AND PIN_Number = ?";

                PreparedStatement ps = c.c.prepareStatement(query);

                ps.setString(1, cardNumber);
                ps.setString(2, pinNumber);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    JOptionPane.showMessageDialog(
                            null, "Login Successful!"
                    );

                    setVisible(false);

                    new Transactions(pinNumber).setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Incorrect Card Number or PIN.",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (Exception e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Database connection error.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } else if (ae.getSource() == signup) {

            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new LoginBank();

    }
}