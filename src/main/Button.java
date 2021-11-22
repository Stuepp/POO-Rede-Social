package main;

import javax.swing.*;
import java.awt.event.*;

public class Button {
	//Atributos
	private JButton bt;
	public static JFrame frame;
	//construtor
	public Button(int PosX,int PosY,int width,int height,String text, int background){
		bt = new JButton(text);
		bt.setBounds(PosX,PosY,width,height);
	    bt.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){  
	    		Stump.curbackground = background;
	    	}
	    });
	}
	public Button(int PosX,int PosY,int width,int height,String text) {
		bt = new JButton(text);
		bt.setBounds(PosX,PosY,width,height);
	    bt.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){  
	    		if(text == "Register") {
	    			register();
	    		}else if(text == "Login") {
	    			
	    		}
	    	}
	    });
	}
	//Get
	public JButton getBt() {
		return bt;
	}
	//Métodos
	public void register() {
		/*Stump.frame.removeAll();
		Stump.frame = new JFrame("Register");
		Stump.frame.setResizable(false);
		Stump.frame.pack();
		Stump.frame.setLocationRelativeTo(null);
		Stump.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Stump.frame.setVisible(true);*/
		
	}
	public void login() {
		
	}
}
