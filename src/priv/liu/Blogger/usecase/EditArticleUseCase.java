package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.EditArticleFailureExcetion;

public class EditArticleUseCase {
	public void execute(String articleTitle, String newArticleTitle, String newArticleContent, String authorName) throws AuthorNotExistException, EditArticleFailureExcetion {
		Article newArticle = new Article(newArticleTitle, newArticleContent);
		new ArticleDao().editArticle(articleTitle, newArticle, authorName);
	}
}
