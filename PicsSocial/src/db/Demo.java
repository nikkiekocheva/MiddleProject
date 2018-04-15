package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Use;

import controller.DBManager;
import controller.UserManager;
import exceptions.InvalidPasswordException;
import model.User;


public class Demo {

	public static void main(String[] args) {
		
		DBManager dbManager = DBManager.getInstance();
		Connection connection = DBManager.getInstance().getConnection();
		try {
			//UserManager.getInstance().register("TestFn", "TestLN", "testmail@testail.te", "0888888888", "testPassword1*");
			User u = UserManager.getInstance().login("testmail@testail.te", "testPassword1*");
			//System.out.println(UserManager.getInstance().getId(u));
			//System.out.println(" Welcome, "+ u.getFirstName() + " " + u.getLastName());
//			UserManager.getInstance().changePassword(u);
//			UserManager.getInstance().editProfile(u);
			UserManager.getInstance().addPost(u, "Second post!", "C:\\Users\\Unicornie\\Documents\\gitRepos\\MiddleProject");
		} catch (SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
		}
	}
}