package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Use;

import controller.DBManager;
import controller.UserManager;
import model.User;


public class Demo {

	public static void main(String[] args) {
		
		DBManager dbManager = DBManager.getInstance();
		Connection connection = DBManager.getInstance().getConnection();
		try {
//			UserManager.getInstance().register("TestFn", "TestLN", "testmail@testail.te", "0888888888", "testpassword");
			User u = UserManager.getInstance().login("testmail@testail.te", "testpassword");
			System.out.println(" Welcome, "+ u.getFirstName() + " " + u.getLastName());
			UserManager.getInstance().changePassword(u);
		} catch (SQLException e) {
			System.out.println("SQL error: " + e.getMessage());
		}
		
		//TO-DOs:
		//Password and email validation check
		//Exceptions
		//The bug in changePassword()
		//Test edit profile, followers, posts, etc 
		
		
		
		
	}
}