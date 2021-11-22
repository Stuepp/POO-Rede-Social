package negocio;

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
	//M�todos
	//quando o usu�rio fizer login vai se ter sempre um User me, sendo esse me o usu�rio
	public void registerUser(User user) {//ok?
		users.add(user);
	}
	public User login(User user) {//talvez?
		//usar um m�todo de procura visto em EDA
		/*
		 * if users.get(i) equals user
		 * if yes return users.get(i) 
		 * if not return null
		 */
		return null;
	}
	public void logout(User user) {//nem ideia como fazer
		
	}
	public void deleteUser(User user) {//est� certo?
		users.remove(user);
	}
	public ArrayList<User> searchUser(String nome) {//retorna lista de usuarios que contenha o texto inserido no nome/apelido
		//usar um m�todo de procura visto em EDA
		return null;
	}
	public User searchUser(String nickname,int uniquecode) {//retorna us�ario do nome e c�digo inseridos
		//usar um m�todo de procura visto em EDA
		return null;
	}
	public void followUser(User me,User user) {
		me.follow_user(user);
		user.getFollowers().add(me);
		//como atualizar os eles da arraylist de forma eficiente?
		//novamente o search visto em EDA e sobreescrever para a condi��o nova?
	}
	public void unfollowUser(User me,User user) {//me parece estranho
		me.unfollow_user(user);
		user.getFollowers().remove(user);
	}
	public void createPost(Post post, User user) {//ok?
		posts.add(post);
		user.getPosts().add(post);
	}
	public void sharePost() {//como fazer?
		
	}
	public void deletePost(Post post, User user) {
		user.delete_Post(post);
		//esse user que est� no arraylist users tem que ser atualizado n�o?
	}
	public void reactToPost(String reactType, Post post) {//Parece errado..
		post.reactPost(reactType);
	}
	public void unReactToPost(String reactType, Post post) {//Parece errado..
		post.cancel_reactPost(reactType);
	}
}
