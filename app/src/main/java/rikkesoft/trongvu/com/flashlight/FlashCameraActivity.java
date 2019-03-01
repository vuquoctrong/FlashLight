package rikkesoft.trongvu.com.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import static android.hardware.Camera.Parameters.FLASH_MODE_OFF;
import static android.hardware.Camera.Parameters.FLASH_MODE_ON;

public class FlashCameraActivity extends Activity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton tbtn_turnCamera;
    private Button btn_click;
    private Camera camera;
    private Camera.Parameters parameters;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcamera);
        getCamera();
        init();
    }

    /*
    anh xa
     */
    private void init(){
        tbtn_turnCamera = (ToggleButton)findViewById(R.id.tbtn_turnCamera);
        btn_click = (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parameters = camera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            turnCamera();
        }else {
            offCamera();
        }
    }

    private void turnCamera() {
        parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void offCamera() {
        parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    /*
    get Camera
     */
    private void getCamera(){
        if(camera==null&&parameters==null){
            camera = camera.open();
            parameters = camera.getParameters();
        }
    }
}
