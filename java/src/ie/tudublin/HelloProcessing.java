package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		x1 = random(0, width);
		x2 = random(0, width);
		y1 = random(0, height);
		y2 = random(0, height);

		float range = 5;

		x1dir = random(-range, range);
		x2dir = random(-range, range);
		y1dir = random(-range, range);
		y2dir = random(-range, range);

		smooth();
		
	}

	float x1, y1, x2, y2;
	float x1dir, x2dir, y1dir, y2dir;
	float c = 0;
	
	public void draw()
	{	
		stroke(255);
        background(0); // greyscale
        line(10, 10, 200, 200); // x1, y1, x2, y2
        circle(200, 250, 50); // cx cy, r
        ellipse(50, 200, 90, 200); // cx, cy, w, h

        rectMode(CENTER);
        rect(300, 20, 100, 20); // tlx, tly, w, h

        rectMode(CORNER);
        rect(20, 10, 100, 20);

        point(20, 300);
        
        triangle(420, 40, 330, 150, 50, 200);
	}
}
