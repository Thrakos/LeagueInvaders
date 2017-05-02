import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	
	int right;

	Alien(int x, int y, int width, int height) {
		super();
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		

	
	}
	void update() {
		super.update();
		
		y += 3;
		if (right == 0 || right == 1 || right == 2 || right == 3 || right == 4 || right == 5 || right == 6 || right == 7 || right == 8 || right == 9 || right == 11 || right == 12 || right == 13 || right == 14 || right == 15 || right == 16 || right == 17 || right == 18 || right == 19) {
			x += 3;
			right += 1;
		}
		else{
			x -= 3;
			right += 1;
		}
		if (right == 39) {
			right = 0;
		}


		
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
