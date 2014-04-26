package graphics;

import java.awt.Image;
import java.awt.Rectangle;

public class Tile {
	
	private Image tileImage;
	private Rectangle tileDimensions = new Rectangle(0,0,16,16);
	
	public Image getTileImage(){
		
		return tileImage;
	}
	
	public Tile(Image image, Rectangle dimensions){
		
		this.tileImage = image;
		this.tileDimensions = dimensions;
		
	}	
	
}
