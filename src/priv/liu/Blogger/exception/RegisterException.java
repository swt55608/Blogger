package priv.liu.Blogger.exception;

public class RegisterException extends Exception {
	public RegisterException() {
		super("Username may be existing or empty.\nOr password empty.");
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
