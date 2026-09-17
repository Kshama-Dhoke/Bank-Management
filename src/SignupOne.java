package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    
    JTextField nameTextField, fnameTextField, emailTextField;
    JTextField addressTextField, cityTextField, stateTextField, pinTextField;

    JDateChooser dateChooser;

    JButton next;

    JRadioButton male, female, other;
    JRadioButton married, unmarried;

    SignupOne() {

        // ---------------- FRAME ----------------
        setTitle("Bank Management System - Application Form");
        setSize(950, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().setBackground(new Color(18, 32, 55));
        setLayout(null);


        // ---------------- MAIN WHITE PANEL ----------------
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(55, 25, 840, 780);
        add(panel);


        // ---------------- HEADER ----------------
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(18, 32, 55));
        header.setBounds(0, 0, 840, 95);
        panel.add(header);


        // Application form number
        Random ran = new Random();

        // Always generates a 4-digit number
        random = 1000 + ran.nextInt(9000);

        JLabel formno = new JLabel(
                "APPLICATION FORM NO. " + random
        );

        formno.setForeground(Color.WHITE);
        formno.setFont(new Font("Arial", Font.BOLD, 22));
        formno.setBounds(25, 15, 500, 35);
        header.add(formno);


        JLabel subtitle = new JLabel(
                "Please enter your personal information"
        );

        subtitle.setForeground(new Color(220, 230, 240));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setBounds(27, 53, 400, 25);
        header.add(subtitle);


        // ---------------- TITLE ----------------
        JLabel title = new JLabel("Personal Details");

        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(18, 32, 55));
        title.setBounds(30, 115, 300, 35);
        panel.add(title);


        // Small line below title
        JPanel line = new JPanel();
        line.setBackground(new Color(30, 100, 180));
        line.setBounds(30, 152, 100, 3);
        panel.add(line);


        // ---------------- LABELS ----------------

        JLabel name = createLabel("Name");
        name.setBounds(30, 180, 150, 25);
        panel.add(name);

        nameTextField = createTextField();
        nameTextField.setBounds(30, 208, 350, 38);
        panel.add(nameTextField);


        JLabel fname = createLabel("Father's Name");
        fname.setBounds(440, 180, 150, 25);
        panel.add(fname);

        fnameTextField = createTextField();
        fnameTextField.setBounds(440, 208, 350, 38);
        panel.add(fnameTextField);


        // ---------------- DATE OF BIRTH ----------------

        JLabel dob = createLabel("Date of Birth");
        dob.setBounds(30, 265, 150, 25);
        panel.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(30, 293, 350, 38);
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 15));
        dateChooser.setDateFormatString("yyyy-MM-dd");
        panel.add(dateChooser);


        // ---------------- GENDER ----------------

        JLabel genderLabel = createLabel("Gender");
        genderLabel.setBounds(440, 265, 150, 25);
        panel.add(genderLabel);


        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setBackground(Color.WHITE);
        male.setBounds(440, 292, 80, 35);
        panel.add(male);


        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setBackground(Color.WHITE);
        female.setBounds(525, 292, 90, 35);
        panel.add(female);


        other = new JRadioButton("Other");
        other.setFont(new Font("Arial", Font.PLAIN, 15));
        other.setBackground(Color.WHITE);
        other.setBounds(620, 292, 80, 35);
        panel.add(other);


        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);


        // ---------------- EMAIL ----------------

        JLabel email = createLabel("Email Address");
        email.setBounds(30, 350, 150, 25);
        panel.add(email);

        emailTextField = createTextField();
        emailTextField.setBounds(30, 378, 350, 38);
        panel.add(emailTextField);


        // ---------------- MARITAL STATUS ----------------

        JLabel maritalLabel = createLabel("Marital Status");
        maritalLabel.setBounds(440, 350, 150, 25);
        panel.add(maritalLabel);


        married = new JRadioButton("Married");
        married.setFont(new Font("Arial", Font.PLAIN, 15));
        married.setBackground(Color.WHITE);
        married.setBounds(440, 377, 90, 35);
        panel.add(married);


        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Arial", Font.PLAIN, 15));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(535, 377, 105, 35);
        panel.add(unmarried);


        other = new JRadioButton("Other");
        other.setFont(new Font("Arial", Font.PLAIN, 15));
        other.setBackground(Color.WHITE);
        other.setBounds(650, 377, 80, 35);
        panel.add(other);


        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);


        // ---------------- ADDRESS ----------------

        JLabel address = createLabel("Address");
        address.setBounds(30, 435, 150, 25);
        panel.add(address);

        addressTextField = createTextField();
        addressTextField.setBounds(30, 463, 760, 38);
        panel.add(addressTextField);


        // ---------------- CITY ----------------

        JLabel city = createLabel("City");
        city.setBounds(30, 520, 150, 25);
        panel.add(city);

        cityTextField = createTextField();
        cityTextField.setBounds(30, 548, 230, 38);
        panel.add(cityTextField);


        // ---------------- STATE ----------------

        JLabel state = createLabel("State");
        state.setBounds(305, 520, 150, 25);
        panel.add(state);

        stateTextField = createTextField();
        stateTextField.setBounds(305, 548, 230, 38);
        panel.add(stateTextField);


        // ---------------- PINCODE ----------------

        JLabel pincode = createLabel("Pincode");
        pincode.setBounds(580, 520, 150, 25);
        panel.add(pincode);

        pinTextField = createTextField();
        pinTextField.setBounds(580, 548, 210, 38);
        panel.add(pinTextField);


        // ---------------- NEXT BUTTON ----------------

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


        // ---------------- FOOTER ----------------

        JLabel footer = new JLabel(
                "Step 1 of 3  •  Personal Information"
        );

        footer.setFont(new Font("Arial", Font.PLAIN, 13));
        footer.setForeground(Color.GRAY);
        footer.setBounds(30, 710, 300, 25);
        panel.add(footer);


        setVisible(true);
    }


    // ==========================================================
    // CREATE LABEL
    // ==========================================================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(55, 65, 80));

        return label;
    }


    // ==========================================================
    // CREATE TEXT FIELD
    // ==========================================================

    private JTextField createTextField() {

        JTextField textField = new JTextField();

        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setForeground(new Color(40, 40, 40));
        textField.setBackground(new Color(250, 251, 253));

        textField.setBorder(
                new LineBorder(
                        new Color(200, 205, 215),
                        1,
                        true
                )
        );

        return textField;
    }


    // ==========================================================
    // BUTTON ACTION
    // ==========================================================

    @Override
    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;

        String name = nameTextField.getText().trim();
        String fname = fnameTextField.getText().trim();
        String email = emailTextField.getText().trim();

        String address = addressTextField.getText().trim();
        String city = cityTextField.getText().trim();
        String state = stateTextField.getText().trim();
        String pincode = pinTextField.getText().trim();


        // ---------------- VALIDATION ----------------

        if (name.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Name is required"
            );
            return;
        }


        if (fname.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Father's Name is required"
            );
            return;
        }


        if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Date of Birth is required"
            );
            return;
        }


        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }


        if (gender == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select Gender"
            );
            return;
        }


        if (email.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Email is required"
            );
            return;
        }


        // Basic email validation
        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address"
            );
            return;
        }


        String marital = null;

        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }


        if (marital == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select Marital Status"
            );
            return;
        }


        if (address.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Address is required"
            );
            return;
        }


        if (city.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "City is required"
            );
            return;
        }


        if (state.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "State is required"
            );
            return;
        }


        if (pincode.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Pincode is required"
            );
            return;
        }


        // Pincode should contain exactly 6 digits
        if (!pincode.matches("\\d{6}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Pincode must contain exactly 6 digits"
            );

            return;
        }


        // ======================================================
        // DATABASE INSERT
        // ======================================================

        try {

            connect c1 = new connect();


            String query =
                    "INSERT INTO signup " +
                    "(formno, name, fname, dob, gender, email, marital, " +
                    "address, city, pincode, state) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


            PreparedStatement ps =
                    c1.c.prepareStatement(query);


            // Convert Java Date to SQL Date
            java.util.Date selectedDate =
                    dateChooser.getDate();

            java.sql.Date sqlDate =
                    new java.sql.Date(
                            selectedDate.getTime()
                    );


            ps.setString(1, formno);
            ps.setString(2, name);
            ps.setString(3, fname);
            ps.setDate(4, sqlDate);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, marital);
            ps.setString(8, address);
            ps.setString(9, city);
            ps.setString(10, pincode);
            ps.setString(11, state);


            ps.executeUpdate();


            JOptionPane.showMessageDialog(
                    this,
                    "Personal details saved successfully!"
            );


            // Close current window
            setVisible(false);


            // Open SignupTwo
            new SignupTwo(formno).setVisible(true);


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }


    // ==========================================================
    // MAIN METHOD
    // ==========================================================

    public static void main(String[] args) {

        new SignupOne();
    }
}