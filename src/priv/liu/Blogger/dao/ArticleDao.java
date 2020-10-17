package priv.liu.Blogger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import priv.liu.Blogger.dao.connector.DatabaseConnector;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.InvalidArticleTitleException;
import priv.liu.Blogger.exception.ArticleNotFoundException;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.EditArticleFailureExcetion;

public class ArticleDao {
	private Connection _conn;
	private String _tableName;
	
	public ArticleDao() {
		_conn = new DatabaseConnector().getConnection();
		_tableName = "articles";
		createTableIfNotExists();
	}
	
	private void createTableIfNotExists() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS " + _tableName + " (" + 
					"    id INT NOT NULL AUTO_INCREMENT," + 
					"    title VARCHAR(50) NOT NULL," + 
					"    content VARCHAR(50) NOT NULL," + 
					"    author_id INT NOT NULL," + 
					"    PRIMARY KEY (id)," + 
					"    FOREIGN KEY (author_id) REFERENCES authors(id)," + 
					"    UNIQUE (title)," + 
					"    CHECK (title <> '')" + 
					");";
			Statement stmt = _conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public void create(Article article, String authorName) throws InvalidArticleTitleException, AuthorNotExistException {
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "INSERT INTO " + _tableName + " (title, content, author_id)"
					+ " VALUES (?, ?, ?);";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, article.getTitle());
			prestmt.setString(2, article.getContent());
			prestmt.setInt(3, authorId);
			prestmt.executeUpdate();
		} catch (SQLException sqlException) {
			throw new InvalidArticleTitleException();
		}
	}
	
	public List<Article> getArticles() {
		List<Article> articles = new ArrayList<Article>();
		try {
			String sql = "SELECT title, content, authors.username FROM " + _tableName
					+ " JOIN authors ON articles.author_id = authors.id;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);;
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String authorName = rs.getString("authors.username");
				articles.add(new Article(title, content, authorName));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return articles;
	} 
	
	public List<Article> getArticles(String authorName) throws AuthorNotExistException {
		List<Article> articles = new ArrayList<Article>();
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "SELECT * FROM " + _tableName
					+ " WHERE author_id = ?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setInt(1, authorId);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				articles.add(new Article(title, content, authorName));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return articles;
	}
	
	public void editArticle(String articleTitle, Article newArticle, String authorName) throws AuthorNotExistException, EditArticleFailureExcetion {
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "UPDATE " + _tableName + 
					" SET title=?, content=?" + 
					" WHERE title=? AND author_id=?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, newArticle.getTitle());
			prestmt.setString(2, newArticle.getContent());
			prestmt.setString(3, articleTitle);
			prestmt.setInt(4, authorId);
			boolean isEdit = prestmt.executeUpdate() > 0;
			if (!isEdit)
				throw new EditArticleFailureExcetion(articleTitle, authorName);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public boolean deleteArticle(String articleTitle, String authorName) throws AuthorNotExistException {
		boolean isDeleted = false;
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "DELETE FROM " + _tableName + 
					" WHERE title=? AND author_id=?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, articleTitle);
			prestmt.setInt(2, authorId);
			isDeleted = prestmt.executeUpdate() > 0;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			isDeleted = false;
		}
		return isDeleted;
	}
}
