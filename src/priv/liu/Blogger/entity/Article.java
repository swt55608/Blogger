package priv.liu.Blogger.entity;

public class Article {
	private String _title;
	private String _content;
	private String _authorName;
	
	public Article(String title, String content) {
		_title = title;
		_content = content;
	}
	
	public Article(String title, String content, String authorName) {
		_title = title;
		_content = content;
		_authorName = authorName;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public String getContent() {
		return _content;
	}
	
	public String getAuthorName() {
		return _authorName;
	}
	
	@Override
	public String toString() {
		return "Title: " + getTitle() + 
			"\nContent: " + getContent() +
			"\nAuthor: " + getAuthorName() + "\n";
	}
}
