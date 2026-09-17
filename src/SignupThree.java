package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignupThree extends JFrame implements ActionListener {

    private JRadioButton saving, current, fixed, recurring;
    private JCheckBox atm, internet, cheque, alerts, mobile, statement, selfDeclar;
    private JButton submit, cancel;

    private String formno;

    SignupThree(String formno) {
        this.formno = formno;

        setTitle("Bank Management System - Application Form");
        setSize(950, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(new Color(18, 32, 55));

        // Main white panel
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(55, 25, 840, 780);
        add(panel);

        // Blue header
        JPanel header = new JPanel(null);
        header.setBackground(new Color(18, 32, 55));
        header.setBounds(0, 0, 840, 95);
        panel.add(header);

        JLabel pageLabel = new JLabel("APPLICATION FORM - PAGE 3");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pageLabel.setForeground(Color.WHITE);
        pageLabel.setBounds(25, 15, 500, 35);
        header.add(pageLabel);

        JLabel subtitle = new JLabel("Choose your account type and required services");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(220, 230, 240));
        subtitle.setBounds(27, 53, 500, 25);
        header.add(subtitle);

        // Page title
        JLabel title = new JLabel("Account Details");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(18, 32, 55));
        title.setBounds(30, 115, 350, 35);
        panel.add(title);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(30, 100, 180));
        titleLine.setBounds(30, 152, 100, 3);
        panel.add(titleLine);

        // Account type
        addSectionLabel(panel, "Account Type", 30, 180);

        saving = createRadioButton("Saving Account");
        saving.setBounds(30, 215, 180, 30);
        panel.add(saving);

        fixed = createRadioButton("Fixed Deposit Account");
        fixed.setBounds(250, 215, 240, 30);
        panel.add(fixed);

        current = createRadioButton("Current Account");
        current.setBounds(30, 255, 180, 30);
        panel.add(current);

        recurring = createRadioButton("Recurring Deposit Account");
        recurring.setBounds(250, 255, 270, 30);
        panel.add(recurring);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(saving);
        accountTypeGroup.add(current);
        accountTypeGroup.add(fixed);
        accountTypeGroup.add(recurring);

        // Card number information
        addSectionLabel(panel, "Card Number", 30, 315);

        JLabel cardInfo = new JLabel("Your 16-digit card number");
        cardInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        cardInfo.setForeground(Color.GRAY);
        cardInfo.setBounds(30, 345, 250, 22);
        panel.add(cardInfo);

        JLabel cardNumber = new JLabel("xxxx-xxxx-xxxx-xxxx");
        cardNumber.setFont(new Font("Arial", Font.BOLD, 20));
        cardNumber.setForeground(new Color(30, 100, 180));
        cardNumber.setBounds(300, 325, 300, 35);
        panel.add(cardNumber);

        // PIN information
        addSectionLabel(panel, "PIN", 30, 380);

        JLabel pinInfo = new JLabel("Your 4-digit PIN");
        pinInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        pinInfo.setForeground(Color.GRAY);
        pinInfo.setBounds(30, 410, 250, 22);
        panel.add(pinInfo);

        JLabel pinNumber = new JLabel("xxxx");
        pinNumber.setFont(new Font("Arial", Font.BOLD, 20));
        pinNumber.setForeground(new Color(30, 100, 180));
        pinNumber.setBounds(300, 390, 150, 35);
        panel.add(pinNumber);

        // Services
        addSectionLabel(panel, "Services Required", 30, 450);

        atm = createCheckBox("ATM Card");
        atm.setBounds(30, 485, 200, 30);
        panel.add(atm);

        internet = createCheckBox("Internet Banking");
        internet.setBounds(300, 485, 220, 30);
        panel.add(internet);

        mobile = createCheckBox("Mobile Banking");
        mobile.setBounds(30, 525, 200, 30);
        panel.add(mobile);

        alerts = createCheckBox("Email & SMS Alerts");
        alerts.setBounds(300, 525, 220, 30);
        panel.add(alerts);

        cheque = createCheckBox("Cheque Book");
        cheque.setBounds(30, 565, 200, 30);
        panel.add(cheque);

        statement = createCheckBox("E-Statement");
        statement.setBounds(300, 565, 220, 30);
        panel.add(statement);

        // Declaration
        selfDeclar = createCheckBox(
                "I declare that the details entered above are correct."
        );
        selfDeclar.setFont(new Font("Arial", Font.PLAIN, 13));
        selfDeclar.setBounds(30, 625, 650, 30);
        panel.add(selfDeclar);

        // Buttons
        submit = createButton("Submit");
        submit.setBounds(490, 680, 140, 45);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = createButton("Cancel");
        cancel.setBounds(650, 680, 140, 45);
        cancel.addActionListener(this);
        panel.add(cancel);

        // Footer
        JLabel footer = new JLabel("Step 3 of 3  •  Account Setup");
        footer.setFont(new Font("Arial", Font.PLAIN, 13));
        footer.setForeground(Color.GRAY);
        footer.setBounds(30, 730, 350, 25);
        panel.add(footer);

        setVisible(true);
    }

    private void addSectionLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(new Color(55, 65, 80));
        label.setBounds(x, y, 350, 25);
        panel.add(label);
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        radioButton.setForeground(new Color(40, 40, 40));
        radioButton.setBackground(Color.WHITE);
        return radioButton;
    }

    private JCheckBox createCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Arial", Font.PLAIN, 15));
        checkBox.setForeground(new Color(40, 40, 40));
        checkBox.setBackground(Color.WHITE);
        return checkBox;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(30, 100, 180));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        // Generate exactly 16 digits
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }

        // Ensure the first digit is not zero
        if (cardNumber.charAt(0) == '0') {
            cardNumber.setCharAt(0, (char) ('1' + random.nextInt(9)));
        }

        return cardNumber.toString();
    }

    private String generatePinNumber() {
        Random random = new Random();

        // Always generates a 4-digit PIN
        return String.valueOf(1000 + random.nextInt(9000));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cancel) {
            setVisible(false);
            new LoginBank().setVisible(true);
            return;
        }

        if (ae.getSource() == submit) {

            String accountType = null;

            if (saving.isSelected()) {
                accountType = "Saving Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            } else if (fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            if (accountType == null) {
                JOptionPane.showMessageDialog(this, "Please select an account type.");
                return;
            }

            if (!selfDeclar.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please accept the declaration.");
                return;
            }

            String cardNumber = generateCardNumber();
            String pinNumber = generatePinNumber();

            StringBuilder facility = new StringBuilder();

            if (atm.isSelected()) {
                facility.append("ATM Card, ");
            }
            if (internet.isSelected()) {
                facility.append("Internet Banking, ");
            }
            if (mobile.isSelected()) {
                facility.append("Mobile Banking, ");
            }
            if (cheque.isSelected()) {
                facility.append("Cheque Book, ");
            }
            if (alerts.isSelected()) {
                facility.append("Email & SMS Alerts, ");
            }
            if (statement.isSelected()) {
                facility.append("E-Statement, ");
            }

            // Remove the final comma and space, if any
            if (facility.length() > 0) {
                facility.setLength(facility.length() - 2);
            }

            try {
                connect c3 = new connect();

                String query =
                        "INSERT INTO signupThree " +
                        "(formno, accountType, cardNumber, pinNumber, facility) " +
                        "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement ps = c3.c.prepareStatement(query);

                ps.setString(1, formno);
                ps.setString(2, accountType);
                ps.setString(3, cardNumber);
                ps.setString(4, pinNumber);
                ps.setString(5, facility.toString());

                ps.executeUpdate();

                String query1 =
                        "INSERT INTO login (formno, Card_Number, PIN_Number) " +
                        "VALUES (?, ?, ?)";

                PreparedStatement ps1 = c3.c.prepareStatement(query1);

                ps1.setString(1, formno);
                ps1.setString(2, cardNumber);
                ps1.setString(3, pinNumber);

                ps1.executeUpdate();

                JOptionPane.showMessageDialog(
                        this,
                        "Account created successfully!\n\n" +
                        "Card Number: " + cardNumber +
                        "\nPIN: " + pinNumber +
                        "\n\nPlease keep your PIN safe."
                );

                setVisible(false);
                new LoginBank().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Database Error: " + e.getMessage()
                );
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}