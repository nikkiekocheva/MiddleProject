package exceptions;

public class InvalidPasswordException extends Throwable {

	@Override
	public String getMessage() {
		return "The password must be at least 8 chars, containing at least one digit,contains at least one lower alpha char and one upper alpha char, and at least one special symbol. Does not contain space, tab, etc. OR matches the previous password.";
	}
}
