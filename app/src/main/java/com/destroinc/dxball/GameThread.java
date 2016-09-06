package com.destroinc.dxball;

import android.graphics.Canvas;
import android.util.Log;

/**
 * Created by siraj on 04-May-16.
 */
public class GameThread extends Thread {

    Boolean running;
    MainCanvas can;
    GameObject ball;
    public GameThread(MainCanvas canvas) {
        this.can=canvas;
    }

    public GameThread(GameObject ball) {
        this.ball=ball;
    }

    public void setRunning(Boolean run) {

        running=run;
    }
    Canvas canvas= new Canvas();

    @Override
    public void run() {


        while(running){

            Log.d("ABC", "sa  "+running);

            try {

                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                //game.onDraw(c);
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                can=null;
                ball=null;
            }



        }
    }
}
