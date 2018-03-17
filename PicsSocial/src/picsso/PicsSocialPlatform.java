package picsso;

import java.util.HashMap;
import java.util.HashSet;

public class PicsSocialPlatform {
	
	private static PicsSocialPlatform instance = null;
	private HashMap<Integer, Account> accounts;
	private HashSet<Post> posts;

	private PicsSocialPlatform() {
		this.accounts = new HashMap<>();
		this.posts = new HashSet<>();
	}

	public static PicsSocialPlatform getInstance() {
		if (instance == null) {
			instance = new PicsSocialPlatform();
		}
		return instance;
	}

	public void signUp(String email, String password) {
		if (email.toLowerCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
				&& password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")) {
			Account account = new Account(email, password);
			this.accounts.put(account.PERSONAL_ID, account);
		}
// password :
//		(?=.*[0-9])       # a digit must occur at least once
//		(?=.*[a-z])       # a lower case letter must occur at least once
//		(?=.*[A-Z])       # an upper case letter must occur at least once
//		(?=\S+$)          # no whitespace allowed in the entire string
//		.{8,}             # anything, at least eight places though
	}

}
