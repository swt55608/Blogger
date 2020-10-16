package priv.liu.Blogger.exception;

public class InvalidArticleTitleException extends Exception {
	public InvalidArticleTitleException() {
		super("Article Title should not be duplicative or empty.");
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
