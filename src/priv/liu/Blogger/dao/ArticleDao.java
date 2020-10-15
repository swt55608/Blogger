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
		} catch (AuthorNotExistException ae) {
			throw ae;
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
}
