package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import controller.HashingClass;

public class User {

	private String firstName;
	private String lastName;
	private String username; // nickname
	private String photo; // path to photo
	private String website;
	private String phone;
	private String email;
	private String password;
	private int id;
	private Set<User> followers;
	private Set<User> following;
	private final NewsFeed newsFeed;
	private List<Post> posts;

	
	
	public User(String firstName, String lastName, String email, String phone, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		setPassword(password);
		followers = new HashSet<>();
		following = new HashSet<>();
		newsFeed = new NewsFeed();
		posts = new ArrayList<>();
	}
	
	public void setID(int i) {
		this.id = i;
		System.out.println("id set to " + this.id);
	}
	
	public int getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = HashingClass.hashPassword(password);	
	}

//	public User(String firstName, String lastName, String email, String phone, String password) {
//		this(firstName, lastName, email, phone, password);
//	}

	public void follow(User a) {
		following.add(a);
		a.followers.add(this);
		notifyFollowing(a);
	}

	public void unfollow(User a) {
		following.remove(a);
		a.followers.remove(this);
	}

	public void addPost(Post p) {
		posts.add(p);
		for (User follower : followers) {
			follower.newsFeed.addPost(p);
		}
	}

	public void removePost(Post p) {
		posts.remove(p);
	}

	public String getUsername() {
		return this.username;
	}

	public void setEmail(String email) {
		if (email.toLowerCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
			// if the mail is not in the database -> change
			this.email = email;
		}
	}

	void changePassword(String password) {
		if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
				&& (!password.equals(this.password))) {
			this.password = password;
		}
	}

	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		}
	}

	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		}
	}

	public void setPhoto(String path) {
		// BufferedImage img = null;
		// try {
		// img = ImageIO.read(new File(path)); // or url, kinda this
		// this.photo = img;
		// } catch (IOException e) {
		// System.out.println("Non-valid path.");
		// }
		// TODO
	}

	public void setWebsite(String website) {
		if (website != null
				&& website.matches("<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>")) {
			this.website = website;
		}
	}

	public void setPhone(String phone) {
		if (phone != null && phone.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")) {
			this.phone = phone;
		}
	}

	public NewsFeed getNewsFeed() {
		return newsFeed;
	}

	public void notifyFollowing(User a) {
		System.out.println(this.toString() + "started following you");

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoto() {
		return photo;
	}

	public String getWebsite() {
		return website;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	

	public List<Post> getPosts() {
		return Collections.unmodifiableList(posts);
	}

	public Set<User> getFollowers() {
		return Collections.unmodifiableSet(followers);
	}

	public Set<User> getFollowing() {
		return Collections.unmodifiableSet(following);
	}

	public void viewProfile() {
		System.out.println("-----PROFILE------");
		System.out.println();
		this.getUsername();
		System.out.println();
		System.out.println(this.getPosts().size() + " posts " + this.getFollowers().size() + " followers "
				+ this.getFollowing().size() + " following ");
		System.out.println();
		this.getName();
		System.out.println();
		for (Post p : posts) {
			p.getContent();
		}

		System.out.println("--------------------");
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}
}
