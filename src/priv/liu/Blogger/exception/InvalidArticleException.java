package priv.liu.Blogger.exception;

public class InvalidArticleException extends Exception {
	public InvalidArticleException() {
		super("Article Title should not be duplicative or empty.");
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
