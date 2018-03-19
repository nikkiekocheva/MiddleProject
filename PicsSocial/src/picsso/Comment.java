package picsso;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Comment {
   public final LocalDateTime addedAt;
   private Account owner;
   private String content;
   private Set<Account> likes;
   Comment(Account owner , String content) {
	   this.owner = owner;
	   addedAt = LocalDateTime.now();
	   this.content=content;
	   likes = new HashSet<>();
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
   
   public Set<Account> getLikes() {
		return Collections.unmodifiableSet(likes);
	}
}
