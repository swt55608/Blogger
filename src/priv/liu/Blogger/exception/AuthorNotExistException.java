package priv.liu.Blogger.exception;

public class AuthorNotExistException extends Exception {
	public AuthorNotExistException() {
		super("Author Not Exists.");
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
