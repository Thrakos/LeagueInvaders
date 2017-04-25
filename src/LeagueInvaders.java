import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;

	static final int WIDTH = 500;
	static final int LENGTH = 800;

	GamePanel GP;

	LeagueInvaders() {

		frame = new JFrame();

		GP = new GamePanel();

		setup();
	}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
	}

	void setup() {
		frame.add(GP);
		frame.setSize(WIDTH, LENGTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(GP);

		GP.startGame();
	}
}
