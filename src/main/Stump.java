package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import dados.User;

public class Stump extends Canvas implements Runnable{
	//Atributos
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	//
	private final int WIDTH = 600;//240
	private final int HEIGHT = 450;//140
	private final int SCALE = 1;
	//
	private Background background;
	private BufferedImage image;
	private BufferedImage[] bk;
	static int curbackground = 0;
	private static int maxbackground = 3;
	//
	private Button bt;
	private User me;//várivel do tipo User que vai conter o usuário que está logado
	//Construtor
	public Stump() {
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		background = new Background("/Tintin1.jpg");
		bk = new BufferedImage[maxbackground];
		bk[0] = background.getBackground(0, 50, WIDTH, HEIGHT/2);
		background = new Background("/baki.jpg");
		bk[1] = background.getBackground(0, 0, WIDTH, HEIGHT);
		background = new Background("/images-36.jpeg");
		bk[2] = background.getBackground(0, 0, WIDTH, HEIGHT);

	}
	//Métodos de inicialização
	public void initFrame() {
		frame = new JFrame("Stump");
		bt = new Button(20,0,90,30,"BK 1",0);
		frame.add(bt.getBt());
		bt = new Button(20,40,90,30,"BK 2",1);
		frame.add(bt.getBt());
		bt = new Button(20,80,90,30,"BK 3",2);
		frame.add(bt.getBt());
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try{
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	//main
	public static void main(String[] args) {
		Stump stump = new Stump();
		stump.start();
	}
	//Métodos
	public void tick() {

	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.dispose();
		g = bs.getDrawGraphics();
		
		g.drawImage(bk[curbackground],0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show();
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks; //9 zeros
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: "+ frames);
				//troca de background a cada frame?
				/*curbackground++;
				if(curbackground >= maxbackground) {
					curbackground = 0;
				}*/
				//
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}
}
