package priv.liu.Blogger.exception;

public class EditArticleFailureExcetion extends Exception {
	public EditArticleFailureExcetion(String articleTitle, String authorName) {
		super("Failed to edit article, title: " + articleTitle + ", author: " + authorName);
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
