import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	Rocketship(int x, int y, int width, int height) {
		super();

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		speed = 5;
		
		up = false;
		down = false;
		left = false;
		right = false;

	}

	void update() {
		super.update();

		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
