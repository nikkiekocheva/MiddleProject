package controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import model.dao.UserDao;

public class UserManager {

	private static UserManager instance;

	public static synchronized UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}

	private UserManager() {
	}

	public User login(String email, String password) throws SQLException {
		String userPassword;
		userPassword = UserDao.USER_DAO.getPasswordViaEmail(email);
			if (passwordMatch(password, userPassword)) {
				System.out.println("Login complete");
				return UserDao.USER_DAO.getByEmail(email);
				
			}else {
				return null;
			}
	}
	
	public void changePassword(User u) throws SQLException {
		UserDao.USER_DAO.changePassword(u);
	}

	public boolean register(String firstName, String lastName, String email, String phone, String password) {
		User u = new User(firstName, lastName, email, phone, password);
		try {
			UserDao.USER_DAO.saveUser(u);
			UserDao.USER_DAO.setID(u);
			return true;
		} catch (SQLException e) {
			System.out.println("There is a DB problem: " + e.getMessage());
			return false;
		}
	}

	public Collection<User> getAll() {
		try {
			return UserDao.USER_DAO.getAllUsers();
		} catch (SQLException e) {
			return Collections.EMPTY_LIST;
		}
	}

	public boolean passwordMatch(String password, String userPassword) {
		return BCrypt.checkpw(password, userPassword);
	}

}
