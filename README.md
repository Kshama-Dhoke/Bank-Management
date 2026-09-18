# Bank Management System

A Java-based desktop banking application that simulates common ATM and banking operations using **Java Swing, JDBC, and MySQL**.

## 📌 Project Overview

The **Bank Management System** is a desktop application developed using Java Swing and MySQL. It provides a graphical interface for performing basic banking and ATM operations such as account registration, login, deposits, withdrawals, balance enquiry, mini statements, and PIN management.

This project was developed as a learning project to strengthen my practical knowledge of **Java, object-oriented programming, GUI development, JDBC, and MySQL database integration**.

## 🚀 Features

* User registration and account creation
* Login using card number and PIN
* Deposit money
* Cash withdrawal
* Fast cash withdrawal
* Balance enquiry
* Mini statement
* PIN change
* Transaction management
* MySQL database integration
* Graphical user interface using Java Swing
* Input validation and event handling

## 🛠️ Technologies Used

| Technology      | Purpose                  |
| --------------- | ------------------------ |
| **Java**        | Application development  |
| **Java Swing**  | Graphical user interface |
| **JDBC**        | Java–MySQL connectivity  |
| **MySQL**       | Database management      |
| **Eclipse IDE** | Development environment  |

## 📂 Project Structure

```text
Bank-Management
│
├── icons
│   ├── atm.jpg
│   └── logo.jpg
│
├── screenshots
│   ├── login page.jpg
│   ├── from page one.jpg
│   ├── second page.jpg
│   ├── three page.jpg
│   ├── transaction page.jpg
│   └── Mini statement.jpg
│
├── src
│   ├── BalanceEnquiry.java
│   ├── Deposit.java
│   ├── FastCash.java
│   ├── LoginBank.java
│   ├── MiniStatement.java
│   ├── PinChange.java
│   ├── SignupOne.java
│   ├── SignupTwo.java
│   ├── SignupThree.java
│   ├── Transactions.java
│   ├── Withdrawl.java
│   └── connect.java
│
└── README.md
```

## 🗄️ Database

The application uses **MySQL** to store and manage application data, including:

* User registration details
* Login credentials
* Account information
* Transaction-related information

The application connects to MySQL through **JDBC**.

> **Note:** Database credentials should not be uploaded to GitHub. Before sharing the project publicly, make sure your username, password, and other sensitive connection details are not exposed in the source code.

## ▶️ How to Run

### Prerequisites

Make sure you have:

1. Java JDK installed
2. MySQL Server installed and running
3. Eclipse IDE or another Java IDE
4. MySQL JDBC driver

### Steps

1. Clone or download this repository.
2. Open the project in Eclipse.
3. Create the required MySQL database and tables.
4. Configure the database connection in the `connect` class.
5. Add the MySQL JDBC driver to the project.
6. Run the application from the appropriate starting class.
7. Register a user and use the generated card number and PIN to log in.

## 📸 Application Screenshots

### Login Page

![Login Page](screenshots/login%20page.jpg)

### Signup - First Page

![Signup First Page](screenshots/from%20page%20one.jpg)

### Signup - Second Page

![Signup Second Page](screenshots/second%20page.jpg)

### Signup - Third Page

![Signup Third Page](screenshots/three%20page.jpg)

### Transactions Page

![Transactions Page](screenshots/transaction%20page.jpg)

### Mini Statement

![Mini Statement](screenshots/Mini%20statement.jpg)

## 📚 Learning Outcomes

Through this project, I gained practical experience in:

* Core Java programming
* Object-oriented programming
* Java Swing GUI development
* JDBC connectivity
* MySQL database operations
* SQL queries
* Event handling
* Exception handling
* Form validation
* Working with multiple Java classes
* Connecting a desktop application to a relational database

## 🔮 Future Enhancements

Possible future improvements include:

* Improved user interface design
* Enhanced transaction history
* Better security for PIN and account information
* Input validation improvements
* Database configuration using environment variables
* Improved error handling
* Additional banking features

## 👩‍💻 Author

**Kshama Dhoke**

Computer Science Engineering Graduate

### Project Focus

**Java | Java Swing | JDBC | MySQL | Desktop Application Development**

---

*This project was developed as a learning project to apply Java programming, GUI development, database connectivity, and software development concepts in a practical application.*
