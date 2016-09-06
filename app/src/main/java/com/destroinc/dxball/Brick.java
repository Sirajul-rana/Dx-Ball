package com.destroinc.dxball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by siraj on 18-Apr-16.
 */
public class Brick extends GameObject {

    Paint paint= new Paint();
    int x1,y1;
    int life;

    public Brick(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    public Brick(int x,int x1,int y,int y1, int life){
        super(x,y);
        this.life=life;
        this.x1=x1;
        this.y1=y1;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(life==1){
            paint.setColor(Color.GRAY);
        }
        else if (life==2){
            paint.setColor(Color.DKGRAY);
        }else if (life==3){
            paint.setColor(Color.RED);
        }

        paint.setStyle(Paint.Style.FILL);
        Rect r= new Rect(x+2,y+2, x1,y1);
        //Log.d("MS",r.toString());
        canvas.drawRect(r, paint);
    }
}
