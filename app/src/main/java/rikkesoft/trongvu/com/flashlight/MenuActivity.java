package rikkesoft.trongvu.com.flashlight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends Activity implements View.OnClickListener {

    private ImageButton ibtn_lightOnOff;
    private ImageButton ibtn_bulbtwo;
    private ImageButton ibtn_traffic;
    private ImageButton ibtn_car;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
        ibtn_lightOnOff.setOnClickListener(this);
        ibtn_bulbtwo.setOnClickListener(this);
        ibtn_traffic.setOnClickListener(this);
        ibtn_car.setOnClickListener(this);
    }

    /*
    ánh xạ
     */
    private void init(){
        ibtn_lightOnOff = (ImageButton) findViewById(R.id.ibtn_flashlight);
        ibtn_bulbtwo = (ImageButton) findViewById(R.id.ibtn_bulbtwo);
        ibtn_traffic = (ImageButton) findViewById(R.id.ibtn_traffic);
        ibtn_car = (ImageButton) findViewById(R.id.ibtn_car);

    }

    /*
    Onclick
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtn_flashlight:
                Intent intent = new Intent(MenuActivity.this,LightActivity.class);
                startActivity(intent);
                break;
            case R.id.ibtn_bulbtwo:
                Intent intent2 = new Intent(MenuActivity.this,BulbtwoActivity.class);
                startActivity(intent2);
                break;
            case R.id.ibtn_traffic:
                Intent intent3 = new Intent(MenuActivity.this,DenGiaoThongActivity.class);
                startActivity(intent3);
                break;
            case R.id.ibtn_car:
                Intent intent4 = new Intent(MenuActivity.this,FlashCameraActivity.class);
                startActivity(intent4);
                break;
                default:
                    break;
        }
    }
}
