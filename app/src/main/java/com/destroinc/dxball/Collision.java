package com.destroinc.dxball;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by siraj on 04-May-16.
 */
public class Collision {
    Brick brick;
    Ball ball;
    Bar bar;
    int height;
    public Collision(int height) {
        // TODO Auto-generated constructor stub
        this.height=height;
    }
    void ballWithBar(ArrayList<GameObject> gameObjectLsit){

        ball=(Ball)gameObjectLsit.get(0);
        if(gameObjectLsit.size()>1){
            bar =(Bar)gameObjectLsit.get(1);
            if(bar.x-10<=ball.x && bar.x1+10>= ball.x && ball.y+(ball.radius)>height-(ball.radius)){
                Log.d("Msg", ""+height);
                ball.speedY=-5;
                Log.d("MSG","UP");
            }
        }


    }

    void ballWithBric(ArrayList<GameObject> gameObjectList){
        ball=(Ball)gameObjectList.get(0);

        if(gameObjectList.size()>2){
            for(int i=2;i<gameObjectList.size();i++){
                brick=(Brick) gameObjectList.get(i);
                if(ball.x>=brick.x-25 && ball.x<= brick.x1+25 && ball.y- ball.radius+8<brick.y1+6 && ball.y-ball.radius+6>brick.y1-3){
                    MainCanvas.Score+=10;
                    brick.life--;
                    ball.speedY=5;
                    Log.d("MSG","Bottom");
                }

                else if(ball.x+ball.radius-6>=brick.x-2 && ball.x+ball.radius-6 <= brick.x+2 && ball.y<= brick.y1+25 && ball.y>= brick.y-25 ){
                    MainCanvas.Score+=10;
                    brick.life--;
                    ball.speedX=-5;
                    Log.d("MSG","Left");
                }
                else if(ball.x-ball.radius+6<= brick.x1+2 && ball.x-ball.radius+6>=brick.x1-2 && ball.y<= brick.y1+25 && ball.y >= brick.y-25 ){
                    MainCanvas.Score+=10;
                    brick.life--;
                    ball.speedY=5;
                    ball.speedX=5;
                    Log.d("MSG","Right");
                }else if(ball.x>=brick.x-25 && ball.x<= brick.x1+25 && ball.y+ball.radius-6>=brick.y-2 && ball.y+ball.radius-6<=brick.y+2){
                    MainCanvas.Score+=10;
                    brick.life--;
                    ball.speedY=-5;
                    ball.speedX=-5;
                    Log.d("MSG","Top");
                }

                if(brick.life==0){
                    gameObjectList.remove(i);
                }
            }
        }

    }
}
