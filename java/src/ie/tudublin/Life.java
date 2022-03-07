package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    LifeBoard board;

	public void settings() {
		size(1000, 1000);
        board = new LifeBoard(200, this);
        board.randomise();
        System.out.println(board.countCellsAround(1, 1));
	}

	public void setup() {
		colorMode(RGB);
	}

	
	public void draw() {
        board.render();
        if ((frameCount % 1) == 0) {
            board.update();
        }
	}
}
