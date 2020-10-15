package priv.liu.Blogger.dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/blogger?serverTimezone=UTC";
			String username = "root";
			String password = "test1234";
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
