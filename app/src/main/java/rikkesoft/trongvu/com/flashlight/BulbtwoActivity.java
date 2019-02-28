package rikkesoft.trongvu.com.flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class BulbtwoActivity extends Activity {

    private ToggleButton tbtn_bulbtwo;
    private Handler handler;
    private Timer timer;
    boolean checkOnOff = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulbtwo);
        init();
        turnAndOffLight();
    }

    /*
    ánh xa
     */
    private void init(){
        tbtn_bulbtwo = (ToggleButton) findViewById(R.id.tbtn_bulbtwo);
    }

    /*
    xet đèn nhấp nháy
     */
    private void turnAndOffLight(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(!checkOnOff){
                    checkOnOff=true;
                }else {
                    checkOnOff=false;
                }
                tbtn_bulbtwo.setChecked(checkOnOff);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }
}
