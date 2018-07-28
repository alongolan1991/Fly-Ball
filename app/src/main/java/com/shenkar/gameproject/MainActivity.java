package com.shenkar.gameproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity{


    String check_if_mute;
    float current_music_vol;
    float current_effect_vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        // get information about audio (mute / unmute / current volume ...)
        SharedPreferences sharedPreferences = getSharedPreferences("souundinfo", Context.MODE_PRIVATE);
        current_music_vol = Float.parseFloat(sharedPreferences.getString("music_bar","1.0f"));
        current_effect_vol = Float.parseFloat(sharedPreferences.getString("effect_bar","1.0f"));
        check_if_mute = sharedPreferences.getString("mute","on");
        super.onCreate(savedInstanceState);
        // handle crashes
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        MySFxRunnable.getSoundPool(this);

        if(check_if_mute.equals("on")){
            MySFxRunnable.getMediaPlayer().setVolume(0,0);
            MySFxRunnable.setVolume(0);
        }
        else{
            MySFxRunnable.getMediaPlayer().setVolume(current_music_vol,current_music_vol);
            MySFxRunnable.setVolume(current_effect_vol);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        MySFxRunnable.getMediaPlayer().start();
    }

    public void goToSetting(View view) {
        MySFxRunnable.getSoundPoolins().play(3);
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }

    public void moveToPlay(View view) {
        MySFxRunnable.getSoundPoolins().play(3);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MySFxRunnable.getMediaPlayer().pause();
    }
}
