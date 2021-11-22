package dados;

import java.util.ArrayList;

public class Post {
	//Atributos
	private String subtitle, description;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<Image> imagens = new ArrayList<Image>();
	private User user;
	private int like=0,sad=0,happy=0,angry=0;
	/*reactions por enquanto tratadas como como int para saber usar
	 *Reaction realmente precisa existir? No conceito de ser uma imagem sim, uma classe
	 *filha de Image, mas como estamos tratando como int no momento vamos deixar ela vazia
	 *para focar em como funcionar
	*/
	//Construtor
	public Post() {
		
	}
	//Getters and Setters
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public ArrayList<Image> getImagens() {
		return imagens;
	}
	public void setImagens(ArrayList<Image> imagens) {
		this.imagens = imagens;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getSad() {
		return sad;
	}
	public void setSad(int sad) {
		this.sad = sad;
	}
	public int getHappy() {
		return happy;
	}
	public void setHappy(int happy) {
		this.happy = happy;
	}
	public int getAngry() {
		return angry;
	}
	public void setAngry(int angry) {
		this.angry = angry;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//métodos
	public void cancel_reactPost(String reactType) {//implementar lógica da imagem (emoji) se react == 0 no emoji
		switch(reactType) {
		case "like":
			like--;
			break;
		case "sad":
			sad--;
			break;
		case "happy":
			happy--;
			break;
		case "angry":
			angry--;
			break;
		default:
			break;
		}
	}
	public void reactPost(String reactType) {//implementar lógica da imagem (emoji) se react > 0 si emoji
		switch(reactType) {
		case "like":
			like++;
			break;
		case "sad":
			sad++;
			break;
		case "happy":
			happy++;
			break;
		case "angry":
			angry++;
			break;
		default:
			break;
		}
		
	}
	public void comment_in_Post(Comment comment) {
		comments.add(comment);
	}
	/* parando para pensar esse método não faz sentido
	public Post create_post(ArrayList<Image> imgs, String subtitle, String description) {
		Post post = new Post();
		post.setImagens(imgs);
		post.setSubtitle(subtitle);
		post.setDescription(description);	
		return post;
	}*/
	public void update_post(ArrayList<Image> imgs,String subtitle,String description){
		imagens = imgs;
		this.subtitle = subtitle;
		this.description = description;
	}
}
