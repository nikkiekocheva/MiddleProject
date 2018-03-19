package picsso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Account {
	
	private Profile profile;
	private String email;
	private String password;
	private static int identificalNumber = 0;
	public final int PERSONAL_ID;
	private Set<Account> followers;
	private Set<Account> following;
	private final NewsFeed newsFeed;
	private ArrayList<Post> posts;
	
	
	public Account(String email, String password) {
        followers= new HashSet<>();
        following= new HashSet<>();
        newsFeed = new NewsFeed();
        posts = new ArrayList<>();
		this.profile = new Profile();
		this.email = email;
		this.password = password;
		identificalNumber++;
		this.PERSONAL_ID = Account.identificalNumber;
		
		
	}

    public void follow(Account a) {
    	   following.add(a);
    	   a.followers.add(this);
    	   notify(a);
    }
    
    public void unfollow(Account a) {
    	following.remove(a);
    	a.followers.remove(this);
    }
    
    public void addPost(Post p) {
    	posts.add(p);
    	for(Account follower : followers) {
    		follower.newsFeed.addPost(p);
    	}
    }
    
    public void removePost(Post p) {
    	posts.remove(p);
    }
    
	public void editProfile(String names, String username, String path, String website, String phone){
		this.profile.names(names).username(username).photo(path).website(website).phone(phone);
	}

	
	public String getUsername() {
		return this.profile.getUsername();
	}
	

	public String showProfilePage() {
		return this.profile.showProfileInfo();
	}
	
	private void changeEmail(String email) {
		if(email.toLowerCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){
			// if the mail is not in the database -> change
			this.email = email;
		}
	}

	private void changePassword(String password) {
		if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$") && (!password.equals(this.password))){
			this.password = password;
		}
	}
	
	

	public NewsFeed getNewsFeed() {
		return newsFeed;
	}
    
	public void notify(Account a) {
		System.out.println(this.toString()+ "started following you");
		
	}

	@Override
	public String toString() {
		return this.getUsername();
	}

	
	
	
	
}
