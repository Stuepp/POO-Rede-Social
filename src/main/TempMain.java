package main;

import java.util.ArrayList;
import java.util.Scanner;
import dados.User;
import dados.Post;
import dados.Image;
import negocio.Action;

public class TempMain {

	private static Scanner s = new Scanner(System.in);
	private static User me;
	private static Action action = new Action();
	
	public static void main(String[] args) {
		int menu = 0;
		while(menu == 0) {
			panel();
			System.out.println("Deseja continuar?"
					+ "\n(0)Sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
		}

	}
	public static void panel() {
		System.out.println("(1) registra usuário\n(2)login\n(3)mostra usuários"
				+ "\n(4)deletar conta\n(5) seguir usuário\n(6) deixar de seguir um usuário"
				+ "\n(7) cria post\n(8) motra posts\n(9) deletar post");
		int escolha = Integer.parseInt(s.nextLine());
		switch(escolha) {
			case 1:
				register();				
				break;
			case 2:
				login();
				break;
			case 3:
				show_users();
				break;
			case 4:
				delete_user();
				break;
			case 5:
				follow_user();
				break;
			case 6:
				unfollow_user();
				break;
			case 7:
				create_post();
				break;
			case 8:
				show_posts();
				break;
			case 9:
				delete_post();
				break;
			default:
			break;
		}
	}
	public static void register() {
		User user = new User();
		System.out.println("Digite o nome:");
		user.setName(s.nextLine());
		System.out.println("Vai querer nickname?");
		boolean nick = Boolean.parseBoolean(s.nextLine());
		if(nick == true) {
			System.out.println("Digite o nickname:");
			user.setNickname(s.nextLine());
		}else if(nick == false) {
			user.setNickname(user.getName());
		}
		System.out.println("Digite a senha:");
		user.setPassword(s.nextLine());
		System.out.println("Escreva uma bio:");
		user.setBio(s.nextLine());
		System.out.println("Seu código único: " +user.getUniqueCode());
		
		action.registerUser(user);
	}
	public static void login() {
		System.out.println("Digite seu código único:");
		int uniquecode = Integer.parseInt(s.nextLine());
		System.out.println("Digite sua senha:");
		String password = s.nextLine();
		me = action.login(uniquecode,password);
		if(me != null) {
			System.out.println("login was a success");
		}else {
			System.out.println("login failed check for the correct code and/or password");
		}
		System.out.println("Usuário logado:"
				+ "\n"+me.getNickname()+"#"+me.getUniqueCode() 
				+"\n"+me.getBio());
	}
	public static void show_users() {
		System.out.println("Usuários cadastrados:");
		for(int i = 0; i < action.getUsers().size(); i++) {
			System.out.println(action.getUsers().get(i).getNickname()+"#"+action.getUsers().get(i).getUniqueCode()
					+"\n"+action.getUsers().get(i).getBio()
					+"\n\tSeguidores: ");
			for(int j = 0; j < action.getUsers().get(i).getFollowers().size(); j++) {
				System.out.println("\t\t"+action.getUsers().get(i).getFollowers().get(j).getNickname()+"#"+action.getUsers().get(i).getFollowers().get(j).getUniqueCode());
			}
		}
	}
	public static void delete_user() {
		System.out.println("Deseja realmente deletar a conta?");
		boolean escolha = Boolean.parseBoolean(s.nextLine());
		if(escolha == true) {
			action.deleteUser(me);
			me = null;
			System.out.println("Usuário deletado");
		}else if(escolha == false){
			System.out.println("Operação cancelada");
		}
	}
	public static void follow_user() {
		show_users();
		System.out.println("Digite o código de quem deseja seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < action.getUsers().size();i++) {
			if(uniquecode == action.getUsers().get(i).getUniqueCode() && uniquecode != me.getUniqueCode()) {
				action.followUser(me, action.getUsers().get(i));
				System.out.println(me.getNickname()+" começou a seguir "+action.getUsers().get(i).getNickname());
			}else if(uniquecode == me.getUniqueCode()) {
				System.out.println("Você não pode se seguir");
			}
		}
	}
	public static void unfollow_user() {
		System.out.println("Seguindo:");
		for(int i = 0; i < me.getFollowing().size(); i++) {
			System.out.println("\t"+me.getFollowing().get(i).getNickname()+"#"+me.getFollowing().get(i).getUniqueCode());
		}
		System.out.println("Digite o código de quem deseja parar de seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < me.getFollowing().size(); i++) {
			if(me.getFollowing().get(i).getUniqueCode() == uniquecode) {
				action.unfollowUser(me, me.getFollowing().get(i));
			}
		}
	}
	public static void create_post() {
		Post post = new Post();
		ArrayList<Image> imgs = new ArrayList<Image>();
		System.out.println("Digite o sub titulo do post:");
		post.setSubtitle(s.nextLine());
		System.out.println("Descrição do post:");
		post.setDescription(s.nextLine());
		int repet = 0;
		while(repet == 0) {
			Image img = new Image();
			System.out.println("Img:");
			img.setLocation(s.nextLine());
			imgs.add(img);
			System.out.println("Deseja adicionar outra img?(0)sim(1)não");
			repet = Integer.parseInt(s.nextLine());
		}
		post.setImagens(imgs);
		post.setUser(me);
		action.createPost(post, me);
	}
	public static void show_posts() {
		for(int i = 0; i < action.getPosts().size(); i++) {
			Post post = action.getPosts().get(i);
			System.out.println(post.getSubtitle()+"\n\t"+post.getDescription());
			for(int j = 0; j < post.getImagens().size(); j++) {
				System.out.println(post.getImagens().get(i).getLocation()+"\n");
			}
			if(post.getLike() > 0) {
				System.out.print("likes: "+post.getLike());
			}
			if(post.getSad() > 0) {
				System.out.print(" sad: "+post.getSad());	
			}
			if(post.getHappy() > 0) {
				System.out.print(" happy: "+post.getHappy());	
			}
			if(post.getAngry() > 0) {
				System.out.print(" angry: "+post.getAngry()+"");	
			}
			System.out.println("\nDeseja reagir?");
			boolean react = Boolean.parseBoolean(s.nextLine());
			if(react == true) {
				react_post(post);
			}
			if((post.getLike()+post.getSad()+post.getHappy()+post.getAngry()) > 0) {
				System.out.println("\nDeseja deixar de reagir?");
				boolean unreact = Boolean.parseBoolean(s.nextLine());
				if(unreact == true) {
					unreact_post(post);
				}
			}
			System.out.println("Autor: "+post.getUser().getNickname());
		}
	}
	public static void delete_post() {
		System.out.println("Meus Posts:");
		for(int i = 0; i < me.getPosts().size();i++) {
			Post post = me.getPosts().get(i);
			System.out.println("#"+i+"\n"+post.getSubtitle()+"\n\t"+post.getDescription());
			for(int j = 0; j < post.getImagens().size(); j++) {
				System.out.println(post.getImagens().get(j).getLocation());
			}
		}
		System.out.println("Digite o número do post que deseja deletar");
		int deletar = Integer.parseInt(s.nextLine());
		action.deletePost(me, deletar);
	}
	/*não estão usando a camada de negócio, precisam ser adaptadas para usalá, além de fazer
	 * uma verificação de quem está reagindo se está reagindo mais de uma vez a mesm reação
	 * mesma coisa para quem está deixando de reagir, se está deixndo de reagir a sua reação
	 * não a dos outros
	*/
	public static void react_post(Post post) {
		System.out.println("Escolha uma reação: like,sad,happy,angry");
		String react = s.nextLine();
		switch(react) {
		case "like":
			post.setLike(post.getLike()+1);
			break;
		case "sad":
			post.setSad(post.getSad()+1);
			break;
		case "happy":
			post.setHappy(post.getHappy()+1);
			break;
		case "angry":
			post.setAngry(post.getAngry()+1);
			break;
		default:
			break;
		}
	}
	public static void unreact_post(Post post) {
		System.out.println("Quer deixar de reagir?: like,sad,happy,angry");
		String react = s.nextLine();
		switch(react) {
		case "like":
			if(post.getLike() > 0) {
				post.setLike(post.getLike()-1);
			}
			break;
		case "sad":
			if(post.getSad() > 0) {
				post.setSad(post.getSad()-1);
			}
			break;
		case "happy":
			if(post.getHappy() > 0) {
				post.setHappy(post.getHappy()-1);
			}
			break;
		case "angry":
			if(post.getAngry() > 0) {
				post.setAngry(post.getAngry()-1);
			}
			break;
		default:
			break;
		}
	}
}
