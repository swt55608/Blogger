package priv.liu.Blogger.usecase;

import priv.liu.Blogger.dao.AuthorDao;
import priv.liu.Blogger.entity.Author;

public class LoginUseCase {
	public boolean execute(String username, String password) {
		Author author = new Author(username, password);
		return new AuthorDao().login(author);
	}
}
