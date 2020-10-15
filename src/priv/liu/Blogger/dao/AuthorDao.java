package priv.liu.Blogger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import priv.liu.Blogger.exception.RegisterException;
import priv.liu.Blogger.dao.connector.DatabaseConnector;
import priv.liu.Blogger.entity.Author;
import priv.liu.Blogger.exception.AuthorNotExistException;

public class AuthorDao {
	
	private Connection _conn;
	
	public AuthorDao() {
		_conn = new DatabaseConnector().getConnection();
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
	
	public boolean login(Author author) {
		boolean isLogin = false;
		try {
			String sql = "SELECT * FROM authors"
					+ " WHERE username=? AND password=?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, author.getUsername());
			prestmt.setString(2, author.getPassword());
			ResultSet rs = prestmt.executeQuery();
			isLogin = rs.next();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return isLogin;
	}
	
	public int getId(String username) throws AuthorNotExistException {
		int id = -1;
		try {
			String sql = "SELECT * FROM authors"
					+ " WHERE username=?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, username);
			ResultSet rs = prestmt.executeQuery();
			if (rs.next())
				id = rs.getInt("id");
			else 
				throw new AuthorNotExistException();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return id;
	}
}
