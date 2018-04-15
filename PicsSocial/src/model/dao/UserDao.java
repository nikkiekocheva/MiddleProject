package model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import controller.DBManager;
import controller.UserManager;
import model.User;

public enum UserDao implements IUserDao {
	USER_DAO;

	private Connection connection;

	private UserDao() {
		connection = DBManager.getInstance().getConnection();
	}

	@Override
	public void changeUser(User u) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("----EDIT INFORMATION----");
		System.out.println();
		System.out.println("1. Edit profile");
		System.out.println("2. Change password");
		System.out.println("3. <-");
		System.out.println();
		System.out.println("-------------------------");

		switch (sc.nextInt()) {
		case 1:
			editProfile(u);
			break;
		case 2:
			changePassword(u);
			break;
		case 3:
			u.viewProfile();
		}

	}

	@Override
	public void saveUser(User u) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"INSERT INTO mydb.users(first_name, last_name, email, phone, password) VALUES (?,?,?,?,?)");
		s.setString(1, u.getFirstName());
		s.setString(2, u.getLastName());
		s.setString(3, u.getEmail());
		s.setString(4, u.getPhone());
		s.setString(5, u.getPassword());
		s.executeUpdate();
	}

	@Override
	public Collection<User> getAllUsers() throws SQLException {
		PreparedStatement s = connection
				.prepareStatement("SELECT id,first_name, last_name, email, phone, password FROM Users;");
		HashSet<User> users = new HashSet<>();
		ResultSet result = s.executeQuery();
		while (result.next()) {
			User u = new User(result.getString("first_name"), result.getString("last_name"), result.getString("email"),
					result.getString("phone"), result.getString("password"));
			users.add(u);
		}
		return users;
	}

	@Override
	public User getByID(int id) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"SELECT first_name, last_name, email, phone, password FROM Users WHERE id=" + id + ";");
		ResultSet result = s.executeQuery();
		User u = new User(result.getString("first_name"), result.getString("last_name"), result.getString("email"),
				result.getString("phone"), result.getString("password"));
		return u;
	}

	public User getByEmail(String email) throws SQLException {
		PreparedStatement s = connection.prepareStatement(
				"SELECT first_name, last_name, email, phone, password FROM mydb.users WHERE email = ?");
		s.setString(1, email);
		ResultSet result = s.executeQuery();
		User u = null;
		while (result.next()) {
			u = new User(result.getString("first_name"), result.getString("last_name"), result.getString("email"),
					result.getString("phone"), result.getString("password"));

		}
		return u;
	}

	public String getPasswordViaEmail(String email) {
		try {
			PreparedStatement s = connection.prepareStatement("SELECT password FROM users WHERE users.email =?");
			s.setString(1, email);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				return result.getString("password");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;

	}

	public void changePassword(User u) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String oldPass, newPass, confirmNewPass;
		System.out.println("----CHANGE PASSWORD----");
		System.out.println();
		System.out.print("Old Password: ");
		oldPass = sc.next();
		System.out.print("New Password: ");
		newPass = sc.next();
		System.out.print("Confirm New Password: ");
		confirmNewPass = sc.next();

		System.out.println("Save: Y/N");
		if (sc.next().charAt(0) == 'Y') {
			System.out.println("in");
			if (UserManager.getInstance().passwordMatch(oldPass, u.getPassword())) {
				System.out.println("Your password was entered incorrectly. Please enter it again!");
			} else if (!newPass.equals(confirmNewPass)) {
				System.out.println("The two password fields didn't match.");
			} else {
				PreparedStatement s = connection.prepareStatement("UPDATE users SET password = ? WHERE id= ?;");
				s.setString(1, newPass);
				s.setInt(2, u.getId()); // getId not working, returns 0 
				System.out.println(u.getId());
				s.executeUpdate();
				u.setPassword(newPass);
				System.out.println("The password was changed!");
			}

		}
	}

	public void setID(User u) {
		try {
			PreparedStatement s = connection.prepareStatement("SELECT id FROM mydb.users WHERE users.email = ?");
			s.setString(1, u.getEmail());
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				u.setID(id);
				System.out.println("id: " + id);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private void editProfile(User u) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String[] profileInfo = new String[7];

		System.out.println("----EDIT PROFILE----");
		System.out.println();
		System.out.println("1. First name");
		System.out.println("2. Last name");
		System.out.println("3. Username");
		System.out.println("4. Website");
		System.out.println("5. Email");
		System.out.println("6. Phone number");
		System.out.println("7. Photo");
		System.out.println("8. Save ");
		System.out.println("9. <-");
		while (true) {
			switch (sc.nextInt()) {
			case 1: {
				System.out.println("1. ");
				profileInfo[0] = sc.next();
			}
				break;
			case 2: {
				System.out.println("2. ");
				profileInfo[1] = sc.next();
			}
				break;
			case 3: {
				System.out.println("3. ");
				profileInfo[2] = sc.next();
			}
				break;
			case 4: {
				System.out.println("4. ");
				profileInfo[3] = sc.next();
			}
				break;
			case 5: {
				System.out.println("5. ");
				profileInfo[4] = sc.next();
			}
				break;
			case 6: {
				System.out.println("6. ");
				profileInfo[5] = sc.next();
			}
				break;
			case 7: {
				System.out.println("7. ");
				profileInfo[6] = sc.next();
			}
				break;
			case 8: {
				int[] profileInfoIndex = new int[7];
				StringBuilder query = new StringBuilder();
				int j = 0;
				for (int i = 0; i < profileInfo.length; i++) {
					if (!profileInfo[i].isEmpty()) {
						if (j != 0) {
							query.append(',');
						}
						profileInfoIndex[j++] = i + 1;
						query.append((i + 1) + "=?");
					}
				}
				PreparedStatement s = connection
						.prepareStatement("UPDATE Users SET " + query + "WHERE id=" + u.getId() + ";");
				for (int i = 0; i < profileInfoIndex.length; i++) {
					String text = profileInfo[profileInfoIndex[i]];
					s.setString(i + 1, text);
					switch (profileInfoIndex[i]) {
					case 1:
						u.setFirstName(text);
						break;
					case 2:
						u.setLastName(text);
						break;
					case 3:
						u.setUsername(text);
						break;
					case 4:
						u.setWebsite(text);
						break;
					case 5:
						u.setEmail(text);
						break;
					case 6:
						u.setPhone(text);
						break;
					case 7:
						u.setPhoto(text);
						break;

					}
				}
				s.executeUpdate();
				s.close();
			}
				break;
			case 9: {
				System.out.close();
				changeUser(u);
			}
				break;
			} // end of switch
		} // end of while
	}

}
