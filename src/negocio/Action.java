package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dados.User;
import dados.Post;

public class Action {
	//Atributos
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Post> posts = new ArrayList<>();
	//Getters and Setters
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	//Métodos
	//quando o usuário fizer login vai se ter sempre um User me, sendo esse me o usuário
	public void registerUser(User user) {//ok no momento
		users.add(user);
	}
	public User login(int uniquecode, String password) {//ok no momento
		//usar um método de procura visto em EDA
		for(int i = 0; i < users.size();i++) {
			if(users.get(i).getUniqueCode() == uniquecode && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}
	public void logout(User user) {//nem ideia como fazer
		
	}
	public void deleteUser(User user) {//ok no momento
		
		for(int i = 0;  i < users.size(); i++) {
			if(user.getUniqueCode() == users.get(i).getUniqueCode()) {
				users.remove(i);
			}
		}
	}
	public ArrayList<User> searchUser(String nome) {//retorna lista de usuarios que contenha o texto inserido no nome/apelido
		//usar um método de procura visto em EDA
		int size = users.size();
		ArrayList<User> foundedUsers = new ArrayList<User>();
		for(int i = 0; i < size; i++) {
			if(users.get(i).getName().equals(nome) || users.get(i).getNickname().equals(nome)) {
				foundedUsers.add(users.get(i));
			}
		}
		return foundedUsers;
	}
	public User searchUser(String nickname,int uniquecode) {//retorna usúario do nome e código inseridos
		//usar um método de procura visto em EDA
		int size = users.size();
		for(int i = 0; i < size; i++) {
			if(users.get(i).getNickname().equals(nickname) && users.get(i).getUniqueCode() == uniquecode) {
				return users.get(i);
			}
		}
		return null;
	}
	public void followUser(User me,User user) {//ok no momento
		me.follow_user(user);
		user.getFollowers().add(me);
	}
	public void unfollowUser(User me,User user) {//ok no momento
		me.unfollow_user(user);
		for(int i = 0;  i < user.getFollowers().size(); i++) {
			if(me.getUniqueCode() == user.getFollowers().get(i).getUniqueCode()) {
				user.getFollowers().remove(i);
			}
		}
	}
	public void createPost(Post post, User user) {//ok no momento
		posts.add(post);
		user.getPosts().add(post);
	}
	public void sharePost() {//como fazer?
		
	}
	public void deletePost(User user, int pos) {//ok no momento
		for(int i = 0; i < posts.size();i++) {
			user.delete_Post(pos);
			posts.remove(pos);
		}		
	}
	public void reactToPost(String reactType, Post post) {//adaptar para ser uma imagem
		post.reactPost(reactType);
	}
	public void unReactToPost(String reactType, Post post) {//adaptar para ser uma imagem
		post.cancel_reactPost(reactType);
	}
	/*
	public void showPosts() { // a trabalhar no método ainda
		PreparedStatement ps = con.prepareStatement("SELECT.img.FROM.images.VALUES="+posts.get(0).getImagens());
		ps.setString(1,posts.get(0).getImagens());
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			while(rs.next()) {
				byte[] imgBytes = rs.getBytes(1);
				//use os dados de alguma forma
			}
			rs.close();
		}
		ps.close();
	}*/
}
