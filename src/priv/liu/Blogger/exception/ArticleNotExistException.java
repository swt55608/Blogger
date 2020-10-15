package priv.liu.Blogger.exception;

public class ArticleNotExistException extends Exception {
	private String _articleTitle;
	
	public ArticleNotExistException(String artitcleTitle) {
		_articleTitle = artitcleTitle;
	}
	
	@Override
	public String toString() {
		return "No Such Article: " + _articleTitle;
	}
}
