package model.dao;

import java.util.Collection;

import exceptions.InvalidPasswordException;
import model.User;

public interface IUserDao {

	User getByID(int id) throws Exception;
	void saveUser(User u) throws Exception;
	void changeUser(User u) throws Exception, InvalidPasswordException;
	Collection<User> getAllUsers() throws Exception;
}
