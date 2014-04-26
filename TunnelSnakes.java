package tunnel.snakes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TunnelSnakes extends JPanel implements KeyListener, ActionListener {
    
    private static Image pistol;
    private static Image pistolSilenced;
    private static Image assaultRifle;
    
    Timer timer = new Timer(16, this);
    Player player = new Player();
    

    public static void main(String[] args) {
        TunnelSnakes window = new TunnelSnakes();
	JFrame frame = new JFrame("This is also a title");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1100, 828);
	frame.setResizable(false);
	frame.setContentPane(window);
        frame.setVisible(true);
	frame.addKeyListener(window);
        
        window.timer.start();
        
    }

    @Override
    public void keyTyped(KeyEvent eevent) {
        //TO-DO Ignore this part
    }

    @Override
    public void keyPressed(KeyEvent event) {
        handlePlayerInput(event.getKeyCode(), true);
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
        handlePlayerInput(event.getKeyCode(), false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == timer){
            update();
            repaint();
        }
    }
    
    private void handlePlayerInput(int keyCode, boolean keyPressed){
        if(keyPressed == true){
            player.changeVelocity(keyCode);
        }
    }
   
    
    private void update(){
        player.reduceVelocity();
        player.playerMovement();
    }
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.red);
                g2d.fill(player);
                
                System.out.println(""+player.velocity);
    }




}
