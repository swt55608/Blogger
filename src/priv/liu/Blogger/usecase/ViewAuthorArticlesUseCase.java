package priv.liu.Blogger.usecase;

import java.util.List;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.ArticleNotFoundException;
import priv.liu.Blogger.exception.AuthorNotExistException;

public class ViewAuthorArticlesUseCase {
	public List<Article> execute(String authorName) throws AuthorNotExistException {
		return new ArticleDao().findArticles(authorName);
	}
}
