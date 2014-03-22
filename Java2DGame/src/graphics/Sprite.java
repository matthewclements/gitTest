package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	public Sprite(){
		
		BufferedImage player;
		try {
			System.out.println("test");
			player = ImageIO.read(getClass().getResourceAsStream("Resources/Sprites/Player/space_Dude.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//this is a test
	//second test
}
