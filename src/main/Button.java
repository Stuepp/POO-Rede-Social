package main;

import javax.swing.*;
import java.awt.event.*;

public class Button {
	//Atributos
	private JButton bt;
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
	//Get
	public JButton getBt() {
		return bt;
	}
}
