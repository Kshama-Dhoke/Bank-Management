package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber) {

        setTitle("Indian Bank - Mini Statement");
        setSize(450, 650);
        setLocation(450, 80);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= BACKGROUND =================
        getContentPane().setBackground(new Color(245, 247, 250));

        // ================= HEADER =================
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(30, 30, 30));
        header.setBounds(0, 0, 450, 80);
        add(header);

        JLabel bankName = new JLabel("INDIAN BANK");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Arial", Font.BOLD, 24));
        bankName.setBounds(135, 12, 200, 30);
        header.add(bankName);

        JLabel statementTitle = new JLabel("MINI STATEMENT");
        statementTitle.setForeground(new Color(210, 210, 210));
        statementTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        statementTitle.setHorizontalAlignment(SwingConstants.CENTER);
        statementTitle.setBounds(100, 45, 250, 20);
        header.add(statementTitle);

        // ================= CARD NUMBER =================
        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setFont(new Font("Arial", Font.BOLD, 13));
        cardLabel.setForeground(new Color(90, 90, 90));
        cardLabel.setBounds(30, 100, 120, 25);
        add(cardLabel);

        JLabel card = new JLabel();
        card.setFont(new Font("Arial", Font.BOLD, 16));
        card.setForeground(Color.BLACK);
        card.setBounds(30, 125, 380, 30);
        add(card);

        // Get card number
        try {

            connect c1 = new connect();

            ResultSet rs = c1.s.executeQuery(
                    "SELECT * FROM login WHERE PIN_Number = '" + pinNumber + "'"
            );

            while (rs.next()) {

                String cardNumber = rs.getString("card_Number");

                if (cardNumber != null && cardNumber.length() >= 16) {

                    String maskedCard =
                            cardNumber.substring(0, 4)
                            + " XXXX XXXX "
                            + cardNumber.substring(12);

                    card.setText(maskedCard);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        // ================= SEPARATOR =================
        JSeparator separator = new JSeparator();
        separator.setBounds(30, 165, 390, 1);
        add(separator);

        // ================= TRANSACTION HEADER =================

        JLabel dateHeader = new JLabel("DATE");
        dateHeader.setFont(new Font("Arial", Font.BOLD, 12));
        dateHeader.setBounds(30, 180, 100, 25);
        add(dateHeader);

        JLabel typeHeader = new JLabel("TYPE");
        typeHeader.setFont(new Font("Arial", Font.BOLD, 12));
        typeHeader.setBounds(160, 180, 100, 25);
        add(typeHeader);

        JLabel amountHeader = new JLabel("AMOUNT");
        amountHeader.setFont(new Font("Arial", Font.BOLD, 12));
        amountHeader.setBounds(320, 180, 90, 25);
        add(amountHeader);

        // ================= TRANSACTION PANEL =================

        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(new BoxLayout(transactionPanel, BoxLayout.Y_AXIS));
        transactionPanel.setBackground(Color.WHITE);
        transactionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(transactionPanel);
        scrollPane.setBounds(25, 210, 400, 280);
        scrollPane.setBorder(BorderFactory.createLineBorder(
                new Color(210, 210, 210)
        ));

        add(scrollPane);

        // ================= BALANCE =================

        JPanel balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBackground(new Color(235, 235, 235));
        balancePanel.setBounds(25, 505, 400, 55);
        add(balancePanel);

        JLabel balanceLabel = new JLabel("CURRENT BALANCE");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        balanceLabel.setForeground(new Color(80, 80, 80));
        balanceLabel.setBounds(15, 5, 150, 20);
        balancePanel.add(balanceLabel);

        JLabel balanceValue = new JLabel();
        balanceValue.setFont(new Font("Arial", Font.BOLD, 18));
        balanceValue.setForeground(Color.BLACK);
        balanceValue.setBounds(15, 25, 350, 25);
        balancePanel.add(balanceValue);

        // ================= DATABASE TRANSACTIONS =================

        try {

            connect c2 = new connect();

            BigDecimal balance = BigDecimal.ZERO;

            ResultSet rs = c2.s.executeQuery(
                    "SELECT * FROM bank WHERE pin = '" + pinNumber + "'"
            );

            while (rs.next()) {

                String date = rs.getString("date");
                String type = rs.getString("type");
                BigDecimal amount = rs.getBigDecimal("amount");

                // Transaction row
                JPanel row = new JPanel(null);
                row.setPreferredSize(new java.awt.Dimension(370, 40));
                row.setMaximumSize(new java.awt.Dimension(370, 40));
                row.setBackground(Color.WHITE);

                JLabel dateLabel = new JLabel(date);
                dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                dateLabel.setBounds(0, 5, 110, 25);
                row.add(dateLabel);

                JLabel typeLabel = new JLabel(type);
                typeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                typeLabel.setBounds(125, 5, 110, 25);
                row.add(typeLabel);

                JLabel amountLabel = new JLabel("Rs. " + amount);
                amountLabel.setFont(new Font("Arial", Font.BOLD, 12));
                amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                amountLabel.setBounds(245, 5, 110, 25);
                row.add(amountLabel);

                transactionPanel.add(row);

                // Calculate balance
                if ("Deposit".equalsIgnoreCase(type)) {

                    balance = balance.add(amount);

                } else if ("Withdrawal".equalsIgnoreCase(type)) {

                    balance = balance.subtract(amount);
                }

                // Small separator
                JSeparator rowSeparator = new JSeparator();
                rowSeparator.setMaximumSize(
                        new java.awt.Dimension(370, 1)
                );

                transactionPanel.add(rowSeparator);
            }

            balanceValue.setText("Rs. " + balance);

        } catch (Exception e) {

            System.out.println(e);
        }

        // ================= CLOSE BUTTON =================

        JButton close = new JButton("CLOSE");
        close.setFont(new Font("Arial", Font.BOLD, 13));
        close.setForeground(Color.WHITE);
        close.setBackground(new Color(30, 30, 30));
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setBounds(165, 575, 120, 35);
        add(close);

        close.addActionListener(e -> dispose());

        setVisible(true);
    }

    public static void main(String[] args) {

        new MiniStatement("");
    }
}