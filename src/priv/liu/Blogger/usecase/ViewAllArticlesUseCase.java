package priv.liu.Blogger.usecase;

import java.util.List;

import priv.liu.Blogger.dao.ArticleDao;
import priv.liu.Blogger.entity.Article;

public class ViewAllArticlesUseCase {
	public List<Article> execute() {
		return new ArticleDao().getArticles();
	}
}
