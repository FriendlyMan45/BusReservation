package demoWorks;

import java.sql.*;

public class DBconnection {
	
	private static final String url="jdbc:mysql://localhost:3306/waran";
	private static final String username="root";
	private static final String password="3228";
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);

	}
	
}
