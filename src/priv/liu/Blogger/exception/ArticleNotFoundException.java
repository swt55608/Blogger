package priv.liu.Blogger.exception;

public class ArticleNotFoundException extends Exception {
	private String _articleTitle;
	
	public ArticleNotFoundException(String artitcleTitle) {
		_articleTitle = artitcleTitle;
	}
	
	@Override
	public String toString() {
		return "No Such Article: " + _articleTitle;
	}
}
