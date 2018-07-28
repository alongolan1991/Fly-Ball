package com.shenkar.gameproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;

public class Ball {
    private Bitmap ball;
    private Position position;
    private Direction direction;

    public Ball(Bitmap ball, Position position, Direction direction) {
        this.ball = ball;
        this.position = position;
        this.direction = direction;
    }

    public void checkMusicBoxStatus(musicBox mb, Level level){
        if(!mb.isHit()){
            mb.setHit();
            mb.setColor(0xffe4e4e4);
            // making sound according to ball hits
            switch (level.getNumOfHits()){
                case 0:
                    MySFxRunnable.getSoundPoolins().play(0);
                    break;
                case 1:
                    MySFxRunnable.getSoundPoolins().play(1);
                    break;
                case 2:
                    MySFxRunnable.getSoundPoolins().play(2);
                    break;
            }
            level.setNumOfHits();
        }
    }

    public Bitmap getBall() {
        return ball;
    }

    public void setBall(Bitmap ball) {
        this.ball = ball;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // check screen bounds and changing direction if needed
    public void checkBounds(Canvas canvas, ArrayList<musicBox> musicBoxes, Level level){
        // check if the ball hitted the right wall
        if (position.getPos_X() > canvas.getWidth() - 75){
            this.direction.setDir_X(this.direction.getDir_X()* -1);
        }
        // check if the ball hitted the music boxes
        for(musicBox mb : musicBoxes){
                // checking the left & right side of music box
            if((position.getPos_X() > mb.getRectangle().left - 89 && position.getPos_X() < mb.getRectangle().right + 14) && (position.getPos_Y() < mb.getRectangle().bottom && position.getPos_Y() > mb.getRectangle().top - 75)){
                /* check if the music box was hitted. if so - fill color and make sound.
                   increment num of hits at the level (3 hits is done)
                */
                checkMusicBoxStatus(mb, level);
                //  changing ball direction horizonly
                direction.setDir_X(direction.getDir_X() * -1);
            }
            // checking the top & down side of music box
            if((position.getPos_X() > mb.getRectangle().left - 75 && position.getPos_X() < mb.getRectangle().right) && (position.getPos_Y() < mb.getRectangle().bottom + 10 && position.getPos_Y() > mb.getRectangle().top - 85)){
                /* check if the music box was hitted. if so - fill color and make sound.
                   increment num of hits at the level (3 hits is done)
                */
                checkMusicBoxStatus(mb, level);
                direction.setDir_Y(direction.getDir_Y() * -1);
            }
        }
            // change direction if the ball hitted the left wall
            if (position.getPos_X() < 0){
            this.direction.setDir_X(this.direction.getDir_X()* -1);
        }
            // change direction if the ball hitted the bottom wall
        if (position.getPos_Y() > canvas.getHeight() - 75){
            this.direction.setDir_Y(this.direction.getDir_Y()* -1);
        }
            // change direction if the ball hitted the top wall
        if (position.getPos_Y() < 0){
            this.direction.setDir_Y(this.direction.getDir_Y()* -1);
        }
            // update the ball direction status
        position.setPos_X(position.getPos_X()+ direction.getDir_X());
        position.setPos_Y(position.getPos_Y()+ direction.getDir_Y());
    }
}
