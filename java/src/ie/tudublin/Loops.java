package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode = 0;

    public void settings() {
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

    float magicMap(float a, float b, float c, float d, float e) {
        float output;
        a -= b;
        c -= b;
        e -= d;

        output = ((a / c) * e) + d;

        return output;
    }

    float magicMap1(float a, float b, float c, float d, float e) {
        float r1 = c - b;
        float r2 = e - d;
        float howFar = a - b;

        return d + ((howFar / r1) * r2);
    }

    float offset = 0;

    public void draw() {

        switch (mode) {
            case 0:
                background(0);
                int bars = (int) (mouseX / 20.0f);
                float w = width / (float) bars;
                for (int i = 0; i < bars; i++) {
                    noStroke();
                    fill(map(i, 0, bars, 0, 255), 255, 255);
                    rect(map(i, 0, bars, 0, 500), 0, w, height);
                }
                break;
            case 1:
                background(0);
                int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
                for (int i = 0; i < squares; i++) {
                    noStroke();
                    fill(map(i, 0, squares, 0, 255), 255, 255);
                    float x = map(i, 0, squares, 0, width);
                    square(x, x, h);
                    square((width - h) - x, x, h);
                }
                break;
            case 2:
                background(0);
                int circles = (int) (mouseX / 20.0f);
				// float r = width / (float) circles;
                for (int i = 0; i < circles; i++) {
                    noStroke();
                    fill(map(i, 0, circles, 205, 0), 255, 255);
                    float y = map(i, 0, circles, width, 0);
                    ellipse(250, 250, y, y);
                }
                break;
            case 3:
                background(0);
                int circles2 = (int) (mouseX / 20.0f);
                offset = (mouseY / 100.0f);
                float d = width / (float)circles2;
                for (int i = 0; i < circles2; i++) {
                    for (int j = 0; j < circles2; j++) {
                        noStroke();
                        float x = map(i, 0, circles2 - 1, d / 2, width - (d / 2.0f));
                        float y = map(j, 0, circles2 - 1, d / 2.0f, width - (d / 2.0f));
                        float c = map((i + j + offset), 0, (circles2 * 2), 0, 255) % 256;
                        fill(c, 255, 255);
                        circle(x, y, d);
                    }
                }
                break;
            case 4:
                background(0);
                float scale = 41.6666666667f;
                float x = scale;
                float y = scale;
                stroke(120, 255, 255);
                fill(0);
                // int cols = width/scale;
                // int rows = height/scale;
                for (int i = 0; i < width-(scale*2); i+=scale) {
                    line(x, scale, x, (height-scale));
                    line(scale, y, (width-scale), y);
                    x += scale;
                    y += scale;
                }
                break;

            // map(a,b,c,d,e);
            // a = inputvalue
            // b - c - start and end of the first range
            // d, e 0 - start and and of the end range

            // map(-2, 10, 90, 200, 233);

        }
    }
}