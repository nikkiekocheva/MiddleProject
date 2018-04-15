package model.dao;

import java.util.Collection;

import model.User;

public interface IUserDao {

	User getByID(int id) throws Exception;
	void saveUser(User u) throws Exception;
	void changeUser(User u) throws Exception;
	Collection<User> getAllUsers() throws Exception;
}