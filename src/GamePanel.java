import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;

	Font thatOtherFont;

	Rocketship ship;
	
	ObjectManager OM;

	GamePanel() {
		timer = new Timer(1000 / 60, this);

		titleFont = new Font("Arial", Font.PLAIN, 48);
		thatOtherFont = new Font("Arial", Font.PLAIN, 25);

		ship = new Rocketship(250, 700, 50, 50);
		
		OM = new ObjectManager();
		
		OM.addObject(ship);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("You typed a key. Congratulations.");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("You pressed a key. Yaaaaaaayyyyyy.");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState += 1;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.down = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("You released a key. Impressive.");
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.down = false;
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {

		OM.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);

		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(thatOtherFont);
		g.drawString("Press ENTER to start", 130, 300);
		g.drawString("Press SPACE for instructions", 80, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);
		OM.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.LENGTH);
	}
}
