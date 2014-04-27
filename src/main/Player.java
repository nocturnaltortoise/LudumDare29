package main;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

public class Player {

	private Rectangle playerDimensions = new Rectangle(0,0,0,0);
	private Image playerImage;
	private boolean playerFiring;
	private int ammo;
	private String gunEquipped;
	
	public Rectangle getPlayerDimensions(){
		return playerDimensions;
	}
	
	public Image getPlayerImage(){
		
		return playerImage;
	}
	
	public Player(int x, int y, int width, int height, Image playerImage){

		playerDimensions.x = x;
		playerDimensions.y = y;
		playerDimensions.width = width;
		playerDimensions.height = height;
		this.playerImage = playerImage;
		
	}
	
	public void updatePlayer(){
		
		if(Game.keys[KeyEvent.VK_A]){
			playerDimensions.x--;
		}	
		if(Game.keys[KeyEvent.VK_D]){
			playerDimensions.x++;
		}
		if(Game.keys[KeyEvent.VK_W]){
			playerDimensions.y--;
		}
		if(Game.keys[KeyEvent.VK_S]){
			playerDimensions.y++;
		}
		if(Game.keys[KeyEvent.VK_SPACE]){
			playerFiring = true;
		}
		
	}	
	
}
