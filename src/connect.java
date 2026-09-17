package bankManagementSystem;

import java.sql.*;

public class connect {
	
	Connection c;
	Statement s;
	
	connect(){
		
		try {
			
			
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root",
	                "Mykshama123##");
			s = c.createStatement();
			
		}
		catch (Exception e){
			System.out.println(e);		}
		
		
	}

}
