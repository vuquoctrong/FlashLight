package rikkesoft.trongvu.com.flashlight;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backActivityMenu();

    }

    /*
    chuyển màn hình menu
     */
    private void backActivityMenu(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.back_menu,R.anim.exit_menu);
                finish();
            }
        },3000);
    }
}
