package priv.liu.Blogger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import priv.liu.Blogger.exception.RegisterException;
import priv.liu.Blogger.dao.connector.DatabaseConnector;
import priv.liu.Blogger.entity.Author;
import priv.liu.Blogger.exception.AuthorNotExistException;

public class AuthorDao {
	
	private Connection _conn;
	private String _tableName;
	
	public AuthorDao() {
		_conn = new DatabaseConnector().getConnection();
		_tableName = "authors";
		createTableIfNotExists();
	}
	
	private void createTableIfNotExists() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS " + _tableName + " (" + 
					"    id INT NOT NULL AUTO_INCREMENT," + 
					"    username VARCHAR(50) NOT NULL," + 
					"    password VARCHAR(50) NOT NULL," + 
					"    PRIMARY KEY (id)," + 
					"    UNIQUE (username)," + 
					"    CHECK (username <> '' && password <> '')" + 
					");";
			Statement stmt = _conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public void register(Author author) throws RegisterException {
		try {
			String sql = "INSERT INTO " + _tableName + " (username, password)"
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
			String sql = "SELECT * FROM " + _tableName
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
			String sql = "SELECT * FROM " + _tableName
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
