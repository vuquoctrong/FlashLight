package rikkesoft.trongvu.com.flashlight;

import android.app.Activity;
import android.graphics.drawable.LevelListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class DenGiaoThongActivity extends Activity {

    private ImageView imageView;
    private Timer timer;
    private Handler handler;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengiaothong);
        init();
        xetDenGiaoTthong();
        mediaPlayer = MediaPlayer.create(DenGiaoThongActivity.this,R.raw.nhac);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    /*
    anh xạ
     */
    private void init(){
        imageView = (ImageView) findViewById(R.id.imv_dengiaothong);
    }

    /*
    xet den nhap nhay
     */
    private void xetDenGiaoTthong(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                LevelListDrawable levelListDrawable = (LevelListDrawable) imageView.getDrawable();
                int currentleve = levelListDrawable.getLevel();
                if(currentleve==0||currentleve==1){
                    currentleve++;
                }else {
                    currentleve=0;
                }
                imageView.setImageLevel(currentleve);
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },500,500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
