package priv.liu.Blogger.usecase;

import priv.liu.Blogger.RegisterException;
import priv.liu.Blogger.dao.AuthorDao;
import priv.liu.Blogger.entity.Author;

public class RegisterUseCase {
	
	public void execute(String username, String password) throws RegisterException {
		Author aNewAuthor = new Author(username, password);
		new AuthorDao().register(aNewAuthor);
	}
	
}
