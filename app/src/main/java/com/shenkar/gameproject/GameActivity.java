package com.shenkar.gameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    AnimationLayout AL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        AL = new AnimationLayout(this);
        setContentView(AL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MySFxRunnable.getMediaPlayer().pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        MySFxRunnable.getMediaPlayer().start();
    }
}
