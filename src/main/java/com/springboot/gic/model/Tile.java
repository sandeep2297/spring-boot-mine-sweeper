package com.springboot.gic.model;

public class Tile {

    private boolean mineStatus;
    private boolean displayStatus;
    private int neighborMines;

    public Tile() {
        //Default Behavior
        this.mineStatus = false;
        this.displayStatus = false;
        this.neighborMines = 0;
    }

    public boolean getMineStatus() {
        return this.mineStatus;
    }

    public void setMineStatus() {
        this.mineStatus = true;
    }

    public boolean getDisplayStatus() {
        return this.displayStatus;
    }

    public void setDisplayStatus() {
        this.displayStatus = true;
    }

    public int getNeighborMines() {
        return this.neighborMines;
    }

    public void setNeighborMines(int neighborMines) {
        this.neighborMines = neighborMines;
    }

}
