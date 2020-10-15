package priv.liu.Blogger.entity;

public class Author {
	private String _username;
	private String _password;
	
	public Author(String username, String password) {
		_username = username;
		_password = password;
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getPassword() {
		return _password;
	}
}
