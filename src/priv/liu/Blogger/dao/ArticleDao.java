package priv.liu.Blogger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import priv.liu.Blogger.dao.connector.DatabaseConnector;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.InvalidArticleException;
import priv.liu.Blogger.exception.ArticleNotExistException;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.EditArticleFailureExcetion;

public class ArticleDao {
	private Connection _conn;
	
	public ArticleDao() {
		_conn = new DatabaseConnector().getConnection();
	}
	
	public void create(Article article, String authorName) throws InvalidArticleException, AuthorNotExistException {
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "INSERT INTO articles (title, content, author_id)"
					+ " VALUES (?, ?, ?);";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, article.getTitle());
			prestmt.setString(2, article.getContent());
			prestmt.setInt(3, authorId);
			prestmt.executeUpdate();
		} catch (SQLException sqlException) {
			throw new InvalidArticleException();
		}
	}
	
	public Article findArticle(String articleTitle) throws ArticleNotExistException {
		Article article = null;
		try {
			String sql = "SELECT * FROM articles"
					+ " JOIN authors ON articles.author_id = authors.id"
					+ " WHERE title=?;";
			PreparedStatement prestmt = _conn.prepareStatement(sql);
			prestmt.setString(1, articleTitle);
			ResultSet rs = prestmt.executeQuery();
			if (rs.next()) {
				String content = rs.getString("content");
				String authorName = rs.getString("username");
				article = new Article(articleTitle, content, authorName);
			} else {
				throw new ArticleNotExistException(articleTitle);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return article;
	}
	
	public void editArticle(String articleTitle, Article newArticle, String authorName) throws AuthorNotExistException, EditArticleFailureExcetion {
		try {
			int authorId = new AuthorDao().getId(authorName);
			String sql = "UPDATE articles" + 
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
			String sql = "DELETE FROM articles" + 
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
