import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;

	final int width;
	final int length;
	
	GamePanel GP;

	LeagueInvaders() {
		width = 500;
		length = 800;

		frame = new JFrame();
		
		GP = new GamePanel();

		setup();
	}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
	}

	void setup() {
		frame.add(GP);
		frame.setSize(width, length);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		GP.startGame();
	}
}
