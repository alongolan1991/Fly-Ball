package com.shenkar.gameproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class Settings extends AppCompatActivity {
    SeekBar music_bar, effect_bar;
    TextView current_music_volume, current_effect_volume;
    ToggleButton mute_button;
    private final int MAX_VOLUME = 100;
    private final int MUTE = 0;
    private  SharedPreferences sharedPreferences;


    @Override
    // this function receives all arguments from the shared preferences and building the pages
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("souundinfo", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        MySFxRunnable.getMediaPlayer().start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mute_button = (ToggleButton) findViewById(R.id.toggleButton);
        current_music_volume = (TextView) findViewById(R.id.muteView);
        current_effect_volume = (TextView) findViewById(R.id.muteView2);
        music_bar = (SeekBar) findViewById(R.id.musicBar);
        music_bar.setMax(MAX_VOLUME);
        music_bar.setProgress(Integer.parseInt(sharedPreferences.getString("music_bar_progress","30")));
        effect_bar = (SeekBar) findViewById(R.id.effectBar);
        effect_bar.setMax(MAX_VOLUME);
        effect_bar.setProgress(Integer.parseInt(sharedPreferences.getString("effect_bar_progress","30")));
        current_music_volume.setText(sharedPreferences.getString("music_bar_progress","30"));
        current_effect_volume.setText(sharedPreferences.getString("effect_bar_progress","30"));

        music_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged (SeekBar SeekBar,int progress, boolean fromUser){
                float output = (float) progress / MAX_VOLUME;
                if (progress == MUTE) {
                    current_music_volume.setText("MUTTED");
                } else
                    current_music_volume.setText(String.valueOf(progress));
                editor.putString("music_bar_progress",String.valueOf(progress));
                editor.putString("music_bar",String.valueOf(output));
                editor.apply();
                mute_button.setChecked(false);
                MySFxRunnable.getMediaPlayer().setVolume(output, output);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        effect_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged (SeekBar SeekBar,int progress, boolean fromUser){
                float output = (float) progress / MAX_VOLUME;
                if (progress == MUTE) {
                    current_effect_volume.setText("MUTTED");
                } else
                    current_effect_volume.setText(String.valueOf(progress));
                editor.putString("effect_bar_progress",String.valueOf(progress));
                editor.putString("effect_bar",String.valueOf(output));
                editor.apply();
                mute_button.setChecked(false);
                MySFxRunnable.setVolume(output);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        if(sharedPreferences.getString("mute","off").equals("off")){
            mute_button.setChecked(false);
        }
        else{
            mute_button.setChecked(true);
        }
        mute_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mute_button.isChecked()){
                    MySFxRunnable.getMediaPlayer().setVolume(0,0);
                    MySFxRunnable.setVolume(0);
                    editor.putString("mute",String.valueOf("on"));
                    editor.apply();
                }
                else{
                    MySFxRunnable.getMediaPlayer().setVolume(Float.parseFloat(sharedPreferences.getString("music_bar","1.0f")),Float.parseFloat(sharedPreferences.getString("music_bar","1.0f")));
                    MySFxRunnable.setVolume(Float.parseFloat(sharedPreferences.getString("music_bar","1.0f")));
                    editor.putString("mute",String.valueOf("off"));
                    editor.apply();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MySFxRunnable.getMediaPlayer().start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MySFxRunnable.getMediaPlayer().pause();
    }
}
