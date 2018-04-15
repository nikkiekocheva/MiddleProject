package controller;

import org.mindrot.jbcrypt.BCrypt;

public class HashingClass extends BCrypt{

	public static String hashPassword(String password) {
		String salt = BCrypt.gensalt(5);
		String hashedPassword = BCrypt.hashpw(password, salt);
		return(hashedPassword);
	}
	

	
	
	
}
