package priv.liu.Blogger.exception;

public class InvalidArticleException extends Exception {
	@Override
	public String toString() {
		return "Article Title should not be duplicative or empty.";
	}
}
