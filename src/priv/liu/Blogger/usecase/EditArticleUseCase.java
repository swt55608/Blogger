package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.EditArticleFailureExcetion;

public class EditArticleUseCase {
	public void execute(String oldArticleTitle, Article newArticle, String authorName) throws AuthorNotExistException, EditArticleFailureExcetion {
		new ArticleDao().editArticle(oldArticleTitle, newArticle, authorName);
	}
}
