package priv.liu.Blogger.entity;

public class Article {
	private String _title;
	private String _content;
	private String _authorName;
	
	public Article(String title, String content) {
		_title = title;
		_content = content;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public String getContent() {
		return _content;
	}
}
