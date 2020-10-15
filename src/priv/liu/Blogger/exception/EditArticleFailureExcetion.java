package priv.liu.Blogger.exception;

public class EditArticleFailureExcetion extends Exception {
	private String _articleTitle;
	private String _authorName;
	
	public EditArticleFailureExcetion(String articleTitle, String authorName) {
		_articleTitle = articleTitle;
		_authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "Failed to edit article, title: " + _articleTitle + ", author: " + _authorName;
	}
}
