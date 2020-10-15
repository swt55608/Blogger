package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.exception.AuthorNotExistException;

public class DeleteArticleUseCase {
	public boolean execute(String articleTitle, String authorName) throws AuthorNotExistException {
		return new ArticleDao().deleteArticle(articleTitle, authorName);
	}
}
