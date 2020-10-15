package priv.liu.Blogger.exception;

public class RegisterException extends Exception {
	@Override
	public String toString() {
		return "Username may be existing or empty.\nOr password empty.";
	}
}
