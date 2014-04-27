package main;

import graphics.Tile;
import graphics.TileMap;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener{
	
	private Dimension windowSize = new Dimension(1024, 768);
	public static boolean keys[] = new boolean[256];
	private Image playerImage;
	private Image enemyImage;
	
	TileMap roomOne = new TileMap();
	Timer timer = new Timer(20, this);
	Player hero = new Player(windowSize.width / 2, windowSize.height / 2,48,48, playerImage);
	Rectangle tileSize = new Rectangle(0,0,16,16);
	Tile wallTile = new Tile(loadTexture("res/edgeblock.png"),tileSize);
	Enemy testEnemy = new Enemy(100,100,48,48,enemyImage);
	
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
		testEnemy.updateEnemy();
		
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
		enemyImage = loadTexture("res/grunt.png");
		playerImage = loadTexture("res/newmanx3.png");
		g2d.drawImage(playerImage, hero.getPlayerDimensions().x, hero.getPlayerDimensions().y, null);
		g2d.drawImage(enemyImage, testEnemy.getDimensions().x, testEnemy.getDimensions().y, null);
		
		for(int x = 0; x <= 3; x++){
			
			for(int y = 0; y <= 7*16; y+=16){
				
				if(roomOne.roomOne[y/16] == 'x'){
					
					g2d.drawImage(wallTile.getTileImage(), x, y, null);
					
				}
				
			}
			
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
