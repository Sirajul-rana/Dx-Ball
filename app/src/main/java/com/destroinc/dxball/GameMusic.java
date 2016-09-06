package com.destroinc.dxball;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by siraj on 08-May-16.
 */
public class GameMusic {
    MediaPlayer mp1;
    MediaPlayer mp2;

    public GameMusic(MediaPlayer mp1, MediaPlayer mp2){
        this.mp1 = mp1;
        this.mp2 = mp2;
    }



    public void playMp1(){
        mp1.start();
    }

    public void playMp2(){
        mp2.start();
    }

    public void stopMp1(){
        mp1.stop();
    }

    public void stopMp2(){
        mp2.stop();
    }
}
