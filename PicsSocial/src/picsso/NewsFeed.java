package picsso;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewsFeed {
	private ArrayList<Post> posts;
	private ArrayList<Story> stories;
	
	NewsFeed(){
		posts= new ArrayList<>();
		stories = new ArrayList<>();
	}
	public List<Post> getPosts() {
		return Collections.unmodifiableList(posts);
	}
	
	public void addPost(Post newPost){
		posts.add(newPost);
	}
	public List<Story> getStories() {
		return Collections.unmodifiableList(stories);
	}
	public void addStory(Story newStory) {
		stories.add(newStory);
	}
	
	public void update() {
		//TODO
	}
	
	
}
