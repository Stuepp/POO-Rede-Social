package dados;

import java.util.ArrayList;
import java.util.Collections;

public class User {
	//Atributos
	private String name, bio, nickname, password;
	private int uniqueCode;
	private ArrayList<Post> posts = new ArrayList<Post>();
	private ArrayList<User> following = new ArrayList<User>();
	private ArrayList<User> followers = new ArrayList<User>();
	//construtor
	public User() {
		this.uniqueCode = unique_code();
	}
	//Getters and Setters
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getBio() {
		return bio;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public int getUniqueCode() {
		return uniqueCode;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	public ArrayList<User> getFollowing() {
		return following;
	}
	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}
	public ArrayList<User> getFollowers() {
		return followers;
	}
	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}
	//métodos
	public static int unique_code() {
		int uniqueCode;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 999; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		uniqueCode = list.get(0);
		
		return uniqueCode;
	}
	public void delete_Post(int pos) {
		posts.remove(pos);
	}
	public Post share_post(Post post) {//???
		return post;
	}
	public void logout() {//como fazer?
		
	}
	public void follow_user(User user) {
		following.add(user);
	}
	public void unfollow_user(User user) {//fazer mecanica de busca
		for(int i = 0;  i < following.size(); i++) {
			if(user.getUniqueCode() == following.get(i).getUniqueCode()) {
				following.remove(i);
			}
		}
	}
	//
	public boolean equals(Object o) {
		if(o instanceof User) {
			User u = new User();
			if (this.uniqueCode == u.getUniqueCode()){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
