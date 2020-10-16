package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.InvalidArticleTitleException;

public class CreateArticleUseCase {
	public void execute(String title, String content, String username) throws InvalidArticleTitleException, AuthorNotExistException {
		Article article = new Article(title, content);
		new ArticleDao().create(article, username);
	}
}
