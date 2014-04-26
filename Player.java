package tunnel.snakes;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Rectangle{
    
    public float velocity = 0.f;
    
    public Player(){
        this.x=400;
        this.y=300;
        this.height=80;
        this.width=25;
    }
    
    public void changeVelocity(int keyPressed){
        if(keyPressed == KeyEvent.VK_A){
            if(velocity > -40.f){
                velocity = velocity - 1.f;
            }else{
                velocity = 40.f;
            }
        } else if(keyPressed == KeyEvent.VK_D){
            if(velocity < 40.f){
                velocity = velocity + 1.f;
            }else{
                velocity = 40.f;
            }
        }
    }
    
    public void reduceVelocity(){
            if(velocity != 0.0f){
                if(velocity < 0.0f){
                    velocity = velocity + 0.5f;
                }else{
                    velocity = velocity - 0.5f;
                }
            }
    }
    
    public void playerMovement(){
        x = x + (int)velocity;
    }
}
