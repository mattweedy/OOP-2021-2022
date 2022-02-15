package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{
    int mode = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
	}

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
        switch (mode) {
            case 1:
                background(0);
                int bars = (int)(mouseX / 20f);
                for (int i = 0; i < bars; i++) {
                    fill(255, 100, 0);
                    rect(0, 0, 50, 500);
                }
                break;
        
            default:
                break;
        }
        rect(50, 50, 100, 100);
	}
}
