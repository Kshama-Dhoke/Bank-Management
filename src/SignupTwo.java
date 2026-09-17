package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignupTwo extends JFrame implements ActionListener {

    private JTextField panTextField, aadharTextField;
    private JButton next;

    private JRadioButton syes, sno, eyes, eno;

    private JComboBox<String> religion, category, income, education, occupation;

    private String formno;

    SignupTwo(String formno) {
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

        JLabel formNumberLabel = new JLabel("APPLICATION FORM - PAGE 2");
        formNumberLabel.setFont(new Font("Arial", Font.BOLD, 22));
        formNumberLabel.setForeground(Color.WHITE);
        formNumberLabel.setBounds(25, 15, 500, 35);
        header.add(formNumberLabel);

        JLabel subtitle = new JLabel("Please provide your additional details");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(220, 230, 240));
        subtitle.setBounds(27, 53, 400, 25);
        header.add(subtitle);

        // Page title
        JLabel title = new JLabel("Additional Details");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(18, 32, 55));
        title.setBounds(30, 115, 350, 35);
        panel.add(title);

        JPanel titleLine = new JPanel();
        titleLine.setBackground(new Color(30, 100, 180));
        titleLine.setBounds(30, 152, 100, 3);
        panel.add(titleLine);

        // Religion
        addFieldLabel(panel, "Religion", 30, 180);
        religion = createComboBox(
                new String[]{"Hindu", "Buddhist", "Muslim", "Sikh", "Christian", "Other"});
        religion.setBounds(30, 208, 350, 38);
        panel.add(religion);

        // Category
        addFieldLabel(panel, "Category", 440, 180);
        category = createComboBox(
                new String[]{"General", "OBC", "ST", "SC", "Other"});
        category.setBounds(440, 208, 350, 38);
        panel.add(category);

        // Income
        addFieldLabel(panel, "Income", 30, 265);
        income = createComboBox(
                new String[]{"Null", "< 1,50,000", "< 2,50,000",
                    "< 5,50,000", "Upto 10,00,000"});
        income.setBounds(30, 293, 350, 38);
        panel.add(income);

        // Education
        addFieldLabel(panel, "Educational Qualification", 440, 265);
        education = createComboBox(
                new String[]{"Non Graduation", "Graduation",
                    "Post Graduation", "Doctorate", "Other"});
        education.setBounds(440, 293, 350, 38);
        panel.add(education);

        // Occupation
        addFieldLabel(panel, "Occupation", 30, 350);
        occupation = createComboBox(
                new String[]{"Salaried", "Self Employed", "Business",
                    "Student", "Retired", "Other"});
        occupation.setBounds(30, 378, 350, 38);
        panel.add(occupation);

        // PAN number
        addFieldLabel(panel, "PAN Number", 440, 350);
        panTextField = createTextField();
        panTextField.setBounds(440, 378, 350, 38);
        panel.add(panTextField);

        // Aadhaar number
        addFieldLabel(panel, "Aadhaar Number", 30, 435);
        aadharTextField = createTextField();
        aadharTextField.setBounds(30, 463, 350, 38);
        panel.add(aadharTextField);

        // Senior citizen
        addFieldLabel(panel, "Senior Citizen", 440, 435);

        syes = createRadioButton("Yes");
        syes.setBounds(440, 463, 80, 35);
        panel.add(syes);

        sno = createRadioButton("No");
        sno.setBounds(530, 463, 80, 35);
        panel.add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        // Existing account
        addFieldLabel(panel, "Existing Account", 30, 520);

        eyes = createRadioButton("Yes");
        eyes.setBounds(30, 548, 80, 35);
        panel.add(eyes);

        eno = createRadioButton("No");
        eno.setBounds(120, 548, 80, 35);
        panel.add(eno);

        // Correct group: existing-account buttons go in their own group
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        // Next button
        next = new JButton("Next");
        next.setBounds(650, 650, 140, 45);
        next.setBackground(new Color(30, 100, 180));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 16));
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.addActionListener(this);
        panel.add(next);

        // Footer
        JLabel footer = new JLabel("Step 2 of 3  •  Additional Information");
        footer.setFont(new Font("Arial", Font.PLAIN, 13));
        footer.setForeground(Color.GRAY);
        footer.setBounds(30, 710, 350, 25);
        panel.add(footer);

        setVisible(true);
    }

    private void addFieldLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(55, 65, 80));
        label.setBounds(x, y, 350, 25);
        panel.add(label);
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setForeground(new Color(40, 40, 40));
        textField.setBackground(new Color(250, 251, 253));
        textField.setBorder(new LineBorder(new Color(200, 205, 215), 1, true));
        return textField;
    }

    private JComboBox<String> createComboBox(String[] values) {
        JComboBox<String> comboBox = new JComboBox<>(values);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        radioButton.setBackground(Color.WHITE);
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;

        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;

        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = panTextField.getText().trim();
        String aadhar = aadharTextField.getText().trim();

        if (span.isEmpty()) {
            JOptionPane.showMessageDialog(this, "PAN number is required");
            return;
        }

        if (aadhar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aadhaar number is required");
            return;
        }

        if (seniorcitizen == null) {
            JOptionPane.showMessageDialog(this, "Please select Senior Citizen");
            return;
        }

        if (existingaccount == null) {
            JOptionPane.showMessageDialog(this, "Please select Existing Account");
            return;
        }

        try {
            connect c1 = new connect();

            String query =
                    "INSERT INTO signuptwo " +
                    "(formno, religion, category, income, education, occupation, " +
                    "seniorcitizen, existingaccount, pan, aadhar) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = c1.c.prepareStatement(query);

            ps.setString(1, formno);
            ps.setString(2, sreligion);
            ps.setString(3, scategory);
            ps.setString(4, sincome);
            ps.setString(5, seducation);
            ps.setString(6, soccupation);
            ps.setString(7, seniorcitizen);
            ps.setString(8, existingaccount);
            ps.setString(9, span);
            ps.setString(10, aadhar);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Details saved successfully");

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}