package com.shenkar.gameproject;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import static android.graphics.Color.GREEN;

public class musicBox {
    private Paint color;
    private Rect rectangle;
    private boolean hit;

    public musicBox(int color, Rect rectangle) {
        this.hit = false;
        this.setColor(color);
        this.rectangle = rectangle;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit() {
        this.hit = true;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = new Paint();
        this.color.setStyle(Paint.Style.FILL);
        this.color.setColor(color);

    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rect rectangle) {
        this.rectangle = rectangle;
    }
}
