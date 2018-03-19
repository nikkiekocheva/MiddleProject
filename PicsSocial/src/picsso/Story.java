package picsso;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Story {
   
	  public final LocalDateTime addedAt;
	   private Account owner;
	   private String content;
    	 Story(Account owner , String content) {
		   this.owner = owner;
		   addedAt = LocalDateTime.now();
		   this.content=content;
		  
	   }
	   
	   public Account getOwner() {
	   return this.owner;

	   } 
	   
	   public String getContent() {
		   return content;
	   }
	   public String addedAt() {
		   return addedAt.toString();
	   }
	   
}
