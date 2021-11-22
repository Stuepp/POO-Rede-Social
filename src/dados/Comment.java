package dados;

public class Comment {
	//Atributos
	private String text;
	private User user;
	//Getters and Setters
	public String getComment() {
		return text;
	}
	public void setComment(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//
}