package com.shenkar.gameproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class AnimationLayout extends View implements View.OnTouchListener {
    private Level level;
    private boolean can_play; // can_play true when the user can touch the screen and play. after 1 touch is toggle to false
    private int numOfLevel;
    private int numOfTurns;

    private static final String TAG = "AnimationLayout";

    double second_X,second_Y;
    private int device_width;
    private int device_height;
    private boolean check;


    public AnimationLayout(Context context) {
        super(context);
        can_play = true;
        numOfLevel = 1;
        numOfTurns = 10;
        check = false;
        setOnTouchListener(this);
    }

    public void setBackground (int bg){
        setBackgroundResource(bg);
    }

    // getting device width and height
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        device_width = getMeasuredWidth();
        device_height =  getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(check == true){
            check = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // after finishing the last level getting to the start menu
        if(numOfLevel == 12){
            ((Activity) getContext()).finish();
        }
        // creating new level
        if(level == null)
            level = new Level(numOfLevel,BitmapFactory.decodeResource(getResources(),R.drawable.ball),device_width,device_height);
        // check if all bricks were hitted
        if(level.getNumOfHits() == 3){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numOfLevel ++;
            level = null;
            level = new Level(numOfLevel,BitmapFactory.decodeResource(getResources(),R.drawable.ball),device_width,device_height);
            can_play = true;
        }
        setBackground(level.getBackGround());
        Ball ball = level.getBall();
        ball.checkBounds(canvas,level.getMusicBoxes(),level);

        canvas.drawBitmap(ball.getBall(), ball.getPosition().getPos_X(), ball.getPosition().getPos_Y() ,null);
        // locate the musicBoxex into level
        for(musicBox mb : level.getMusicBoxes()){
            canvas.drawRect(mb.getRectangle(),mb.getColor());
        }
        // if the user fails restart the level
        if(ball.getPosition().getPos_Y() > device_height - 100){
            numOfTurns--;
            // if the user fails the whole game (numOfTurns = 0) show "Game Over" screen and return to the main menu
            if(numOfTurns == 0) {
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.over), Level.converToDeviceWidth(250,device_width)   , Level.converToDeviceHeight(300,device_height),null);
                ((Activity) getContext()).finish();
                check = true;
            }
            else{
                level = null;
                can_play = true;
                level = new Level(numOfLevel, BitmapFactory.decodeResource(getResources(), R.drawable.ball), device_width, device_height);
            }
        }
        // show num of turns (ball icons) below the screen
        for(int i=1, j=0 ; i<numOfTurns ; i++, j=j+100){
            canvas.drawBitmap(ball.getBall(), j, device_height-100 ,null);
        }
        // if the user succeeded the whole game - show "You Win" screen and return to main screen
        if(level.getNumOfHits() == 3 && numOfLevel == 11 )
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.youwin), Level.converToDeviceWidth(250,device_width)   , Level.converToDeviceHeight(300,device_height),null);
        else if(level.getNumOfHits() == 3 ) {
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.v), Level.converToDeviceWidth(300,device_width)   , Level.converToDeviceHeight(300,device_height),null);
        }
        postInvalidateOnAnimation();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(Level.converToDeviceHeight(750,device_height) > event.getY())
            return false;
        if(can_play == false)
                return false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                // set direction and speed for the ball
                second_X = (int)event.getX();
                second_Y = (int)event.getY();
                Direction dir = new Direction((int)((level.getBall().getPosition().getPos_X()-second_X)*0.025),(int)((level.getBall().getPosition().getPos_Y()-second_Y)*0.025));
                level.getBall().setDirection(dir);
                can_play = false;
                break;
        }
        return false;
    }
}
