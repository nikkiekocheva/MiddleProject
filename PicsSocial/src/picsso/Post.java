package picsso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Post {
	//who made the post
	private final Account owner;
	private Set<Account> likes;
    private ArrayList<Comment> comments;
    private Set<Account> tags;
    private String location;
    private String description;
    private String content; // path to video file or picture
    
    Post(Account owner){
    	this.owner = owner;
    	likes = new HashSet<>();
    	comments = new ArrayList<>();
    	tags = new HashSet<>();
    	
    };
    
    
    Post tags(Account...accounts) 
    {
        for(Account a : accounts) {
        	tags.add(a);
        }
    	return this;
    }
    
    Post location (String location) {
    	if(location!= null) {
    		this.location= location;
    	}
    	return this;
    }
    
    Post description (String description) {
    	if(description!= null) {
    		this.description= description;
    	}
    	return this;
    }
    
    Post content(String content) {
    	//TODO
    	return this;
    }
    
    void comment(Comment comment) {
    	comments.add(comment);
    }
  
    void like(Account a) {
    	likes.add(a);
    }
    
	public Account getOwner() {
		return owner;
	}

	public Set<Account> getLikes() {
		return Collections.unmodifiableSet(likes);
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public Set<Account> getTags() {
		return Collections.unmodifiableSet(tags);
	}


	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}

    
    
}
