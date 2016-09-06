package com.destroinc.dxball;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.destroinc.dxball.MainCanvas;

/**
 * Created by siraj on 07-May-16.
 */
public class CanvasActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mp=MediaPlayer.create(this, R.raw.stage);
        mp.start();

        setContentView(new MainCanvas(this));
    }

    @Override
    protected void onStop() {
        mp.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mp.stop();
        super.onDestroy();
    }
}
