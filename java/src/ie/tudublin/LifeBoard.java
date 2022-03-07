package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    // boolean[][] next;

    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa) {
        board = new boolean[size][size];
        // next = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float)size; 
    }

    public void randomise() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // float dice = pa.random(1.0f);
                // if (dice < 0.5f) {
                //     board[row][col] = true;
                // }
                // this is the same as the if as its boolean
                board[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

    public void update() {
        // if cell isAlive
        // 2 - 3 alive neighbours it survives
        // if a dead cell has 3 neighbours - comes to life
        boolean[][] next = new boolean[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int count = countCellsAround(row, col);

                if (isAlive(row, col)) {
                    if (count == 2 || count == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                } else {
                    if (count == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                }
            }
        }

        board = next;
    }

    public int countCellsAround(int row, int col) {
        int count = 0;

        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1 ; j++) {
                if (isAlive(i, j)) count++;
            }
        }
        if (isAlive(row, col)) {
            count--;
        }

        return count;
    }

    public boolean isAlive(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        }

        return false;
    }

    public void render() {

        pa.background(0);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // float x = PApplet.map(col, 0, size, 0, pa.width);
                // float y = PApplet.map(col, 0, size, 0, pa.height);
                // float x = cellSize * col; // same as map
                // float y = cellSize * row; // same as map

                if (board[row][col]) {
                    pa.fill(0, 255, 0);
                } else {
                    pa.noFill();
                }
                // not needed to generate and discard x and y value everytime
                // by storing in variables
                pa.square(cellSize*col, cellSize*row, cellSize);
            }
        }
    }
}
