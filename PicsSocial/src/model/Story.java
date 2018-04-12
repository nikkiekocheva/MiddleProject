package model;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Story {
   
	  public LocalTime time;
	  private User owner;
	  private String content;
	  private int id;
	  
	  Story( User owner , String content) {
		   this.owner = owner;
		   time = LocalTime.now();
		   this.content=content;
		  
	   }
	  
       Story(int id, User owner , String content) {
	        this(owner, content);
	        this.id = id;
	   }
	   
     
       public int getId() {
    	   return id;
       }
	   public User getOwner() {
	   return this.owner;

	   } 
	   
	   public String getContent() {
		   return content;
	   }
	  
	   
}
