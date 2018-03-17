package picsso;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Profile {
	
	private String names;
	private String username; //nickname
	private BufferedImage photo;
	private String website;
	private String phone;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	public Profile names(String names) {
		if(names != null) {
			this.names = names;
		}
		return this;
	}
	public Profile username(String username) {
		if(names != null) {
			this.username = username;
		}
		return this;
	}
	public Profile photo(String path) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(path)); // or url, kinda this
		    this.photo = img;
		} catch (IOException e) {
			System.out.println("Non-valid path.");
		}
		return this;
	}
	
	public Profile website(String website) {
		if(website != null && website.matches("<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>")) {
			this.website = website;
		}
		return this;
	}
	
	public Profile phone(String phone) {
		if(phone != null && phone.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")) {
			this.phone = phone;
		}
		return this;
	}

	public String getUsername() {
		return this.username;
	}
	
	public String showProfileInfo() {
		return "Names: " + this.names + "\nUsername: " + this.username + "\nWebsite: " + this.website + "\nPhone: " + this.phone;
		//printing the photo in the profile info is TO-DO
	}
	
	
}
