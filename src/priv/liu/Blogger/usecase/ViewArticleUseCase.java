package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.ArticleNotExistException;

public class ViewArticleUseCase {
	public Article execute(String articleTitle) throws ArticleNotExistException {
		return new ArticleDao().findArticle(articleTitle);
	}
}
