package model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Comment {
	public final LocalDateTime time;
	private int id;
	private User owner;
	private String content;
	private Set<User> likes;

	public Comment(User owner, String content) {
		this.owner = owner;
		time = LocalDateTime.now();
		this.content = content;
		likes = new HashSet<>();
	}

	public Comment(int id, User owner, String content) {
		this(owner, content);
		this.id = id;
	}

	public User getOwner() {
		return this.owner;

	}

	public String getContent() {
		return content;
	}

	public String time() {
		return time.toString();
	}

	public Set<User> getLikes() {
		return Collections.unmodifiableSet(likes);
	}
}
