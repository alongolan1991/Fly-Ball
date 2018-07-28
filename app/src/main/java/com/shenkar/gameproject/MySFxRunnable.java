package com.shenkar.gameproject;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.SparseIntArray;


/**
 * This can be an independent class.
 * It's here for convenience.
 */
public class MySFxRunnable implements Runnable {
    Context appContext;
    SoundPool soundPool;
    /**
     * like a hash map, but more efficient
     */
    private static MediaPlayer ring;
    private SparseIntArray soundsMap = new SparseIntArray();
    private boolean prepared = false;
    private static MySFxRunnable myRef = null;
    private static float sound_volume = 1.0000f;


    public static void setVolume(float vol){
        sound_volume = vol;

    }

    public static MediaPlayer getMediaPlayer(){
        return ring;
    }

    // implemented by singletone, initializing the background music and return the music effects (sound pool).
    public static MySFxRunnable getSoundPool(Context c) {
        if (myRef == null) {

            synchronized (MySFxRunnable.class) {
                if (myRef == null) {
                    myRef = new MySFxRunnable(c);
                    ring= MediaPlayer.create(c,R.raw.bkm);
                    ring.setLooping(true);
                    ring.start();
                }
            }
        }
        return myRef;
    }

    public static MySFxRunnable getSoundPoolins() {
        return myRef;
    }


    private MySFxRunnable(Context c) {
        // be careful not to leak the activity context.
        // can keep the app context instead.
        appContext = c.getApplicationContext();

        // init this object on a user thread.
        // The rest of the use of this class can be on the UI thread
        new Thread(this).start();
    }

    /**
     * load and init the sound effects, so later I'll be able to play them instantly from the
     * UI thread.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void run() {

//        soundPool = Compat.createSoundPool();

        // Initialize AudioAttributes.
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .setMaxStreams(7)
                .build();

        /**
         * a callback when prepared -- we need to prevent playing before prepared
         */
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                prepared = true;
            }
        });

        /**
         * the load() returns a stream id that can be used to play the sound.
         * I use the "R.raw.xyz" integer as key, because it's useless to invent new keys for
         * them
         */
        soundsMap.put(0, soundPool.load(appContext, R.raw.beep0, 1));
        soundsMap.put(1, soundPool.load(appContext, R.raw.beep1, 1));
        soundsMap.put(2, soundPool.load(appContext, R.raw.beep2, 1));
        soundsMap.put(3, soundPool.load(appContext, R.raw.pushb, 1));


    }

    public void play(int soundKey) {
        if (soundPool == null || !prepared) {
            return;
        }
        soundPool.play(soundsMap.get(soundKey), sound_volume, sound_volume, 1, 0, 1.0f);
    }

    public int getSound(int key) {
        return soundsMap.get(key);
    }
}
