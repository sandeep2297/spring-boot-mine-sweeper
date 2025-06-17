package com.springboot.gic.model;

import java.util.Random;

public class Layout {

    private final int size;
    private final int mineCount;
    private final Tile[][] grid;

    public Layout(int size, int mineCount) {
        if (mineCount > size * size * 0.35) {
            throw new IllegalArgumentException("Mines exceed 35% limit");
        }
        this.size = size;
        this.mineCount = mineCount;
        this.grid = new Tile[size][size];
        initializeMineLayout();
        setMinesRandomly();
        checkNeighborTiles();
    }

    private void initializeMineLayout() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Tile();
            }
        }
    }

    private void setMinesRandomly() {
        Random random = new Random();
        int placed = 0;
        while (placed < mineCount) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!grid[row][col].getMineStatus()) {
                grid[row][col].setMineStatus();
                placed++;
            }
        }
    }

    private void checkNeighborTiles() {
        int[] x = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] y = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!grid[row][col].getMineStatus()) {
                    for (int i = 0; i < x.length; i++) {
                        int newRow = row + x[i];
                        int newCol = col + y[i];
                        if (isInsideLayout(newRow, newCol) && grid[newRow][newCol].getMineStatus()) {
                            grid[row][col].setNeighborMines(grid[row][col].getNeighborMines() + 1);
                        }
                    }
                }
            }
        }
    }

    private boolean isInsideLayout(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public int getSize() {
        return size;
    }

    public Tile getTile(int row, int col) {
        return grid[row][col];
    }

    public boolean displayTile(int row, int col) {
        if (!isInsideLayout(row, col) || grid[row][col].getDisplayStatus()) {
            return true; // Ignore already displayed or out-of-bounds
        }

        grid[row][col].setDisplayStatus();

        if (grid[row][col].getMineStatus()) {
            return false; // Hit a mine, game over
        }

        if (grid[row][col].getNeighborMines() == 0) {
            displayNonMineNeighborTiles(row, col);
        }

        return true;
    }

    private void displayNonMineNeighborTiles(int row, int col) {
        int[] x = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] y = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int i = 0; i < y.length; i++) {
            int newRow = row + x[i];
            int newCol = col + y[i];

            if (isInsideLayout(newRow, newCol) && !grid[newRow][newCol].getDisplayStatus()) {
                if (!grid[newRow][newCol].getMineStatus()) {
                    displayTile(newRow, newCol); // Recursive call to display Tiles
                }
            }
        }
    }

    // To check if the game is won
    public boolean allNonMineTilesDisplayed() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Tile tile = grid[row][col];
                if (!tile.getMineStatus() && !tile.getDisplayStatus()) {
                    return false;
                }
            }
        }
        return true;
    }


}
