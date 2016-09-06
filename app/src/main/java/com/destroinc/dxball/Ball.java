package com.destroinc.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by siraj on 13-Apr-16.
 */
public class Ball extends GameObject {
    int  speedX=5,speedY=5;
    int height, width;
    Boolean first = true;
    Paint paint= new Paint();
    int radius = 30;

    public Ball(int x, int y) {
        super(x, y);
    }

    public Ball(int x,int y,int speed){
        super(x,y);
        speedX=speed;
        speedY=speed;
    }

    @Override
    public void onDraw(Canvas canvas) {
        try {
            if(first){
                height=canvas.getHeight();
                width=canvas.getWidth();
                first=false;
            }
            paint.setColor(Color.GRAY);

            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x, y, radius, paint);
        }
        catch (Exception e){
            //Log.d("MSG",e.toString());
        }

    }



    public void updateState(){

        x+=speedX;
        y+=speedY;
        if(x<radius){
            speedX=5;
        }
        if(x>width-radius){
            speedX=-5;
        }
        if(y>height-radius){
            speedY=5;
            MainCanvas.life--;
            x=width/2;
            y=height/2;
        }

        if(y<radius){
            speedY=5;
        }
    }
}
