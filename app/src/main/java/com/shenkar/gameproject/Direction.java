package com.shenkar.gameproject;

public class Direction {
    private int dir_X;
    private int dir_Y;

    public Direction(int dir_X, int dir_Y) {
        this.dir_X = dir_X;
        this.dir_Y = dir_Y;
    }

    public int getDir_X() {
        return dir_X;
    }

    public void setDir_X(int dir_X) {
        this.dir_X = dir_X;
    }

    public int getDir_Y() {
        return dir_Y;
    }

    public void setDir_Y(int dir_Y) {
        this.dir_Y = dir_Y;
    }
}
