package com.destroinc.dxball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button newgame;
    private Button exit;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newgame = (Button)findViewById(R.id.newgame);
        exit = (Button)findViewById(R.id.exit);
        mp=MediaPlayer.create(this, R.raw.stage);

        newgame.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newgame:
                Intent i=new Intent(this, CanvasActivity.class);
                startActivity(i);
                break;
            case R.id.exit:
                finish();
                mp.stop();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
