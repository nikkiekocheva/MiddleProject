package picsso;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class NewsFeed {
	private Set<Post> posts;
	private Set<Story> stories;
	
	public Set<Post> getPosts() {
		return Collections.unmodifiableSet(posts);
	}
	
	public void addPost(Post newPost){
		posts.add(newPost);
	}
	public Set<Story> getStories() {
		return Collections.unmodifiableSet(stories);
	}
	public void addStory(Story newStory) {
		stories.add(newStory);
	}
	
	public void update() {
		for (Iterator iterator = story.iterator(); iterator.hasNext();) {
			Story story = (Story) iterator.next();
			if(story.getDuration()== 24) {
				stories.remove(story);
			}
			
		}
	}
	
	
}
