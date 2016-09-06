package com.destroinc.dxball;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.MotionEvent;
import java.util.ArrayList;

/**
 * Created by siraj on 07-May-16.
 */
public class MainCanvas extends View {

    static int  Score=0,life=3;
    Paint paint = new Paint();
    Boolean first=true,onTouch = false;
    int speed=15,width,height;
    int level=0;
    Collision collision;


    Ball b;
    Bar ba;
    GameObject ball=new Ball(560,1000);
    GameObject bar= new Bar(1,2);

    ArrayList<GameObject> gameObjectsList = new ArrayList<>();
    GameThread gameThread =new GameThread(this);
    GameThread gameThread2 =new GameThread(ball);

    public MainCanvas(Context context) {
        super(context);

        gameObjectsList.add(ball);
        gameObjectsList.add(bar);
        gameThread.setRunning(true);
        gameThread2.setRunning(true);
        gameThread.start();
        gameThread2.start();


    }

    public void test() {


        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,height/10,(height/10)*2,1));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,height/10,(height/10)*2,1));


        b=(Ball)gameObjectsList.get(0);
        ba= (Bar)gameObjectsList.get(1);
        level++;
        onTouch=true;
    }
    public void stage2() {

        gameObjectsList.add(new Brick(0,(width)/5,height/10,(height/10)*2,3));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,height/10,(height/10)*2,1));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,height/10,(height/10)*2,2));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,height/10,(height/10)*2,1));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,height/10,(height/10)*2,3));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*2,(height/10)*3,1));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*2,(height/10)*3,3));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*2,(height/10)*3,1));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*3,(height/10)*4,3));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*3,(height/10)*4,2));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*3,(height/10)*4,3));

        b=(Ball)gameObjectsList.get(0);
        ba= (Bar)gameObjectsList.get(1);
        level++;
        onTouch=true;
    }

    public void stage1(){

        gameObjectsList.add(new Brick(0,(width)/5,height/10,(height/10)*2,2));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,height/10,(height/10)*2,1));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,height/10,(height/10)*2,2));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,height/10,(height/10)*2,1));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,height/10,(height/10)*2,2));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*2,(height/10)*3,1));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*2,(height/10)*3,1));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*2,(height/10)*3,1));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,(height/10)*3,(height/10)*4,1));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*3,(height/10)*4,1));


        b=(Ball)gameObjectsList.get(0);
        ba= (Bar)gameObjectsList.get(1);
        onTouch=true;
        level++;

    }

    public void stage3(){

        gameObjectsList.add(new Brick(0,(width)/5,height/10,(height/10)*2,3));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,height/10,(height/10)*2,2));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,height/10,(height/10)*2,3));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*2,(height/10)*3,1));
        gameObjectsList.add(new Brick((width/5),(width/5)*2,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*2,(height/10)*3,3));
        gameObjectsList.add(new Brick((width/5)*3,(width/5)*4 ,(height/10)*2,(height/10)*3,2));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*2,(height/10)*3,1));

        gameObjectsList.add(new Brick(0,(width)/5,(height/10)*3,(height/10)*4,3));
        gameObjectsList.add(new Brick((width/5)*2,(width/5)*3 ,(height/10)*3,(height/10)*4,2));
        gameObjectsList.add(new Brick((width/5)*4,(width/5)*5-1 ,(height/10)*3,(height/10)*4,3));


        b=(Ball)gameObjectsList.get(0);
        ba= (Bar)gameObjectsList.get(1);
        onTouch=true;
        level++;

    }

    protected void onDraw(Canvas canvas) {

        if (first) {
            canvas.drawColor(Color.argb(1,255,255,255));
            width = canvas.getWidth();
            height = canvas.getHeight();
            collision = new Collision(height);
            test();

            first = false;

        }
        else {

            //Log.d("game", "in els"+gameObjectsList.size());
            if(gameObjectsList.size()>2){
                if(life!=0){
                    paint.setColor(Color.BLUE);
                    paint.setTextSize(40);
                    canvas.drawText("S: "+String.valueOf(Score), width-130, 35, paint);
                    paint.setColor(Color.RED);
                    canvas.drawText("L: "+String.valueOf(life), 20, 35, paint);
                    for(int i=0;i<gameObjectsList.size();i++){
                        gameObjectsList.get(i).onDraw(canvas);


                    }
                    b.updateState();
                    collision.ballWithBar(gameObjectsList);
                    collision.ballWithBric(gameObjectsList);

                }else{
                    paint.setColor(Color.RED);
                    paint.setTextSize(80);
                    canvas.drawText("GAME OVER", width/2-200, height/2, paint);
                    canvas.drawText("Total Score:"+Score, width/2-180, height/2+100, paint);

                    try {

                        gameThread.setRunning(false);
                        gameThread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    ((CanvasActivity)getContext()).finish();

                }


            }else{
                try {

                    gameThread.setRunning(false);
                    gameThread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                gameThread.setRunning(true);

                if(level<2){
                    stage2();
                    ball.setX(width/2);
                    ball.setY(1000);
                    Ball s=(Ball)ball;
                    s.speedX=5;
                    s.speedY=5;

                }else if(level<3){
                    stage3();
                    ball.setX(width / 2);
                    ball.setY(1000);
                    Ball s = (Ball) ball;
                    s.speedX = 5;
                    s.speedY = 5;

                }else{
                    paint.setColor(Color.RED);
                    paint.setTextSize(80);
                    canvas.drawText("END", width/2-60, height/2, paint);
                    canvas.drawText("Total Score:"+Score, width/2-180, height/2+100, paint);

                    try {

                        gameThread.setRunning(false);
                        gameThread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    ((CanvasActivity)getContext()).finish();
                }
            }
        }


        invalidate();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        super.onTouchEvent(event);
        if(onTouch){
            if (event.getAction() == event.ACTION_UP){

            }
            if (event.getAction()==event.ACTION_DOWN){
                if(event.getX() <= width/2-100){
                    if(ba.x<=0){
                        speed=0;
                    }else {
                        speed=-20;
                    }
                }else if(event.getX() >= width/2+100){
                    if(ba.x1>=width){
                        speed=0;
                    }else {
                        speed=20;
                    }

                }

                ba.x+=speed;
                ba.x1+=speed;
            }
            if (event.getAction()==event.ACTION_MOVE){
                if(event.getX() <= width/2-100){
                    if(ba.x<=0){
                        speed=0;
                    }else {
                        speed=-20;
                    }
                }else if(event.getX() >= width/2+100){
                    if(ba.x1>=width){
                        speed=0;
                    }else {
                        speed=20;
                    }
                }

                ba.x+=speed;
                ba.x1+=speed;
            }
        }
        return true;
    }


}
