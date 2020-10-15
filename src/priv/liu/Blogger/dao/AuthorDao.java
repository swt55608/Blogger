package priv.liu.Blogger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import priv.liu.Blogger.RegisterException;
import priv.liu.Blogger.entity.Author;

public class AuthorDao {
	
	private Connection _conn;
	
	public AuthorDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/blogger?serverTimezone=UTC";
			String username = "root";
			String password = "test1234";
			_conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void register(Author author) throws RegisterException {
		try {
			String sql = "INSERT INTO authors (username, password)"
					+ " VALUES (?, ?);";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, author.getUsername());
			prestmt.setString(2, author.getPassword());
			prestmt.executeUpdate();
		} catch (SQLException sqlException) {
			throw new RegisterException();
		}
	}
}
