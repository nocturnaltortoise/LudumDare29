package main;

import java.awt.Image;
import java.awt.Rectangle;

public class Enemy {

	private String weaponEquipped;
	private Rectangle dimensions = new Rectangle(0,0,0,0);
	private Image enemyImage;
	private boolean firing, alert, idle;
	
	public Enemy(int x, int y, int width, int height, Image enemyImage){
		
		dimensions.x = x;
		dimensions.y = y;
		dimensions.width = width;
		dimensions.height = height;
		this.enemyImage = enemyImage;
		
	}
	
	public Rectangle getDimensions(){
		
		return dimensions;
		
	}
	
	public void updateEnemy(){
		
		int randNum = (int)((Math.random()*2)+1);
		int deltaY = 0;
		
		if(randNum == 1){
			
			while(deltaY <= 10){
				dimensions.y++;
				deltaY++;
			}
			
			
		}else if(randNum == 2){
			
			while(deltaY <= 10){
				
				dimensions.y--;
				deltaY++;
			}
			
			
		}		
		
	}
	
}
