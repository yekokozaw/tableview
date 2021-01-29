package userDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private  String user ="root";
	private String pass = "password";
	private  String url="jdbc:mysql://localhost:3306/test";
	
	public  Connection fileConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connectdata= DriverManager.getConnection(url,user,pass);
			System.out.println("Success!");
		//	return connectdata;
		}
		catch (SQLException e) {
			e.printStackTrace();
		
		}
		catch(ClassNotFoundException ex) {
			return null;
	}
		
	return null;
}
}
