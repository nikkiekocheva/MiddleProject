package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Post {
	//who made the post
	private final User owner;
	private int id;
	private Set<User> likes;
    private ArrayList<Comment> comments;
    private Set<User> tags;
    private String location;
    private String description;
    private String content; // path to video file or picture
    
    public Post(User owner){
    	this.owner = owner;
    	likes = new HashSet<>();
    	comments = new ArrayList<>();
    	tags = new HashSet<>();
    	
    };
    
   public Post id(int id){
    	this.id=id;
    	return this;
    }
   public Post setTags(User...accounts) 
    {
        for(User a : accounts) {
        	tags.add(a);
        }
    	return this;
    }
    
   public Post setLocation (String location) {
    	if(location!= null) {
    		this.location= location;
    	}
    	return this;
    }
    
   public  Post setDescription (String description) {
    	if(description!= null) {
    		this.description= description;
    	}
    	return this;
    }
    
   public String setContent(String content) {
    	return content;
    }
    
   public void comment(Comment comment) {
    	comments.add(comment);
    }
  
   public void like(User a) {
    	likes.add(a);
    }
    
	public User getOwner() {
		return owner;
	}

	public Set<User> getLikes() {
		return Collections.unmodifiableSet(likes);
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public Set<User> getTags() {
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
  
	public int getId() {
		return id;
	}
    
    
}
