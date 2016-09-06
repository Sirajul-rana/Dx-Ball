package com.destroinc.dxball;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by siraj on 18-Apr-16.
 */
public class Bar extends GameObject {
    int x1,y1;
    Boolean first=true;
    Paint paint =new Paint();
    int height , width;
    public Bar(int x, int y) {
        super(x, y);
    }
    public Bar(int x,int y,int x1,int y1){
        super(x, y);
        this.x1=x1;
        this.y1=y1;
    }


    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas) {
        if(first){
            height=canvas.getHeight();
            width= canvas.getWidth();
            x=width/4;
            x1=3*width/6;
            y=height-30;
            y1=height-2;
            first=false;
        }
        //Log.d("test", ""+x );
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        Rect r = new Rect(x, y, x1, y1);
        canvas.drawRect(r, paint);

    }
}
