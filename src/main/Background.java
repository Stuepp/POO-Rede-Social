package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Background {
	//atributos
	private BufferedImage background;
	//construtor
	public Background(String path) {
		try {
			background = ImageIO.read(getClass().getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	//metodos
	public BufferedImage getBackground(int PosX, int PosY, int width, int height) {
		return background.getSubimage(PosX,PosY,width,height);
	}
}
