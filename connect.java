package bankManagementSystem;

import java.sql.*;

public class connect {
	
	Connection c;
	Statement s;
	
	connect(){
		
		try {
			
			
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "YOUR_USERNAME",
	                "YOUR_PASSWORD");
			s = c.createStatement();
			
		}
		catch (Exception e){
			System.out.println(e);		}
		
		
	}

}
