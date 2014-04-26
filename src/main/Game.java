package main;

import graphics.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener{
	
	private Dimension windowSize = new Dimension(1024, 768);
	public static boolean keys[] = new boolean[256];
	private Image playerImage;

	Timer timer = new Timer(20, this);
	Player hero = new Player(windowSize.width / 2, windowSize.height / 2,  16,16, playerImage);
	Rectangle tileSize = new Rectangle(0,0,16,16);
	Tile wallTile = new Tile(loadTexture("res/edgeblock.png"),tileSize);
	
	public Game(){
		
		JFrame frame = new JFrame("Ludum Dare 29");
		frame.setContentPane(this);
		this.setPreferredSize(windowSize);
		frame.pack();
		frame.setLocation(200, 200);
		this.setBackground(Color.BLACK);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setVisible(true);
		this.timer.start();
		
	}
	
	public static void main(String[] args){
		
		new Game();
		
	}
	
	private void update(){

		hero.updatePlayer();
		
	}
	
	private Image loadTexture(String filename){
		Image tempImg;
		
		try {
			tempImg = ImageIO.read(new File(filename));
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return tempImg;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
		
		playerImage = loadTexture("res/Man.png");
		g2d.drawImage(playerImage, hero.getPlayerDimensions().x, hero.getPlayerDimensions().y, null);
		
		for(int i = 0; i < 10; i++){
			
			g2d.drawImage(wallTile.getTileImage(), 0 + i*16, 0, null);
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == timer){
			
			update();
			repaint();
			
		}
		
		
	}
	
}
