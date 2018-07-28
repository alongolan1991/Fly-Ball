package com.shenkar.gameproject;


import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;

public class Level {
    private ArrayList<musicBox> musicBoxes = new ArrayList<>();
    private Ball ball;
    private int numOfHits;
    private int backGround;

    public int getBackGround() {
        return backGround;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    public void setNumOfHits() {
        this.numOfHits++;
    }


    public Level(int levelNumber, Bitmap bitmap, int device_width, int device_height) {
        this.numOfHits = 0;

        switch (levelNumber){
                // any case represents level
            case 1:
                this.backGround = R.drawable.blackbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                // convert height and width to the device parameters and creating the music boxes
                this.musicBoxes.add(new musicBox (0xff660000, new Rect(0,converToDeviceHeight(300,device_height),converToDeviceWidth(100,device_width),converToDeviceHeight(500,device_height))));
                this.musicBoxes.add(new musicBox (0xff660000, new Rect(converToDeviceWidth(300,device_width),0,converToDeviceWidth(700,device_width),converToDeviceHeight(50,device_height))));
                this.musicBoxes.add(new musicBox (0xff660000, new Rect(converToDeviceWidth(900,device_width),converToDeviceHeight(300,device_height),converToDeviceWidth(1000,device_width),converToDeviceHeight(500,device_height))));
                break;
            case 2:
                this.backGround = R.drawable.greenbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xff111e21, new Rect(converToDeviceWidth(300,device_width),converToDeviceHeight(400,device_height),converToDeviceWidth(700,device_width),converToDeviceHeight(550,device_height))));
                this.musicBoxes.add(new musicBox (0xff111e21, new Rect(converToDeviceWidth(100,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(300,device_width),converToDeviceHeight(300,device_height))));
                this.musicBoxes.add(new musicBox (0xff111e21, new Rect(converToDeviceWidth(700,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(900,device_width),converToDeviceHeight(300,device_height))));
                break;
            case 3:
                this.backGround = R.drawable.bluebg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xffffccff, new Rect(0,converToDeviceHeight(50,device_height),converToDeviceWidth(125,device_width),converToDeviceHeight(250,device_height))));
                this.musicBoxes.add(new musicBox (0xffffccff, new Rect(0,converToDeviceHeight(300,device_height),converToDeviceWidth(125,device_width),converToDeviceHeight(400,device_height))));
                this.musicBoxes.add(new musicBox (0xffffccff, new Rect(0,converToDeviceHeight(450,device_height),converToDeviceWidth(125,device_width),converToDeviceHeight(650,device_height))));
                break;
            case 4:
                this.backGround = R.drawable.whitebg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xffffcccc, new Rect(converToDeviceWidth(200,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(200,device_height))));
                this.musicBoxes.add(new musicBox (0xffffcccc, new Rect(converToDeviceWidth(200,device_width),converToDeviceHeight(300,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(400,device_height))));
                this.musicBoxes.add(new musicBox (0xffffcccc, new Rect(converToDeviceWidth(200,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(600,device_height))));
                break;
            case 5:
                this.backGround = R.drawable.pinkbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(0,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(200,device_width),converToDeviceHeight(600,device_height))));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(800,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(1000,device_width),converToDeviceHeight(600,device_height))));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(400,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(600,device_width),converToDeviceHeight(500,device_height))));
                break;
            case 6:
                this.backGround = R.drawable.colorfullbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(200,device_width),converToDeviceHeight(0,device_height),converToDeviceWidth(400,device_width),converToDeviceHeight(100,device_height))));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(600,device_width),converToDeviceHeight(0,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(100,device_height))));
                this.musicBoxes.add(new musicBox (0xffa3a3c2, new Rect(converToDeviceWidth(300,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(700,device_width),converToDeviceHeight(600,device_height))));
                break;

            case 7:
                this.backGround = R.drawable.silverbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xff80dfff, new Rect(converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height),converToDeviceWidth(200,device_width),converToDeviceHeight(200,device_height))));
                this.musicBoxes.add(new musicBox (0xff80dfff, new Rect(converToDeviceWidth(750,device_width),converToDeviceHeight(50,device_height),converToDeviceWidth(950,device_width),converToDeviceHeight(400,device_height))));
                this.musicBoxes.add(new musicBox (0xff80dfff, new Rect(converToDeviceWidth(50,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(600,device_width),converToDeviceHeight(600,device_height))));
                break;
            case 8:
                this.backGround = R.drawable.woodbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xff804000, new Rect(converToDeviceWidth(100,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(300,device_width),converToDeviceHeight(200,device_height))));
                this.musicBoxes.add(new musicBox (0xff804000, new Rect(converToDeviceWidth(400,device_width),converToDeviceHeight(300,device_height),converToDeviceWidth(600,device_width),converToDeviceHeight(400,device_height))));
                this.musicBoxes.add(new musicBox (0xff804000, new Rect(converToDeviceWidth(700,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(900,device_width),converToDeviceHeight(600,device_height))));
                break;
            case 9:
                this.backGround = R.drawable.darkbluebg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xffffbf80, new Rect(converToDeviceWidth(0,device_width),converToDeviceHeight(0,device_height),converToDeviceWidth(500,device_width),converToDeviceHeight(200,device_height))));
                this.musicBoxes.add(new musicBox (0xffffbf80, new Rect(converToDeviceWidth(0,device_width),converToDeviceHeight(300,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(400,device_height))));
                this.musicBoxes.add(new musicBox (0xffffbf80, new Rect(converToDeviceWidth(0,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(500,device_width),converToDeviceHeight(700,device_height))));
                break;
            case 10:
                this.backGround = R.drawable.goldbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xff000000, new Rect(converToDeviceWidth(50,device_width),converToDeviceHeight(50,device_height),converToDeviceWidth(70,device_width),converToDeviceHeight(300,device_height))));
                this.musicBoxes.add(new musicBox (0xff000000, new Rect(converToDeviceWidth(930,device_width),converToDeviceHeight(50,device_height),converToDeviceWidth(950,device_width),converToDeviceHeight(300,device_height))));
                this.musicBoxes.add(new musicBox (0xff000000, new Rect(converToDeviceWidth(400,device_width),converToDeviceHeight(600,device_height),converToDeviceWidth(600,device_width),converToDeviceHeight(610,device_height))));
                break;
            case 11:
                this.backGround = R.drawable.redbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                this.musicBoxes.add(new musicBox (0xff1aff1a, new Rect(converToDeviceWidth(475,device_width),converToDeviceHeight(100,device_height),converToDeviceWidth(525,device_width),converToDeviceHeight(130,device_height))));
                this.musicBoxes.add(new musicBox (0xff1aff1a, new Rect(converToDeviceWidth(200,device_width),converToDeviceHeight(315,device_height),converToDeviceWidth(800,device_width),converToDeviceHeight(350,device_height))));
                this.musicBoxes.add(new musicBox (0xff1aff1a, new Rect(converToDeviceWidth(450,device_width),converToDeviceHeight(500,device_height),converToDeviceWidth(550,device_width),converToDeviceHeight(550,device_height))));
                break;
            case 12:
                this.backGround = R.drawable.redbg;
                this.ball = new Ball(bitmap,new Position(converToDeviceWidth(475,device_width),converToDeviceHeight(750,device_height)),new Direction(0,0));
                break;

        }

        this.musicBoxes = musicBoxes;
        this.ball = ball;
    }
    // converting to device width
    static int converToDeviceWidth(float x ,float width){
        return (int)((x/1000)*width);
    }
    // converting to device height
    static int converToDeviceHeight(float y,float height){
        return (int)((y/1000)*height);
    }


    public ArrayList<musicBox> getMusicBoxes() {
        return musicBoxes;
    }

    public void setMusicBoxes(ArrayList<musicBox> musicBoxes) {
        this.musicBoxes = musicBoxes;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
