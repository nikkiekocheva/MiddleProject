package controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

import model.User;
import model.UserDao;

public class UserManager {
	
	private static UserManager instance;

	public static synchronized UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	private UserManager() {
		
	}
	
	public void login(String username, String password) {
		
	}
	
	public boolean register(String firstName, String lastName, String email, String phone, String password) {
		User u = new User(firstName, lastName, email, phone, password);
		try {
			UserDao.USER_DAO.saveUser(u);
			return true;
		} catch (SQLException e) {
			System.out.println("Sori, ama ima bug: " + e.getMessage());
			return false;
		}
	}
	
	public Collection<User> getAll(){
		try {
			return UserDao.USER_DAO.getAllUsers();
		} catch (SQLException e) {
			return Collections.EMPTY_LIST;
		}
	}
	
}
