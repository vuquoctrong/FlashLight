package rikkesoft.trongvu.com.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import static android.hardware.Camera.Parameters.FLASH_MODE_OFF;
import static android.hardware.Camera.Parameters.FLASH_MODE_ON;

public class FlashCameraActivity extends Activity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton tbtn_turnCamera;
    private Camera camera;
    private Camera.Parameters parameters;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcamera);
        camera = camera.open();
        parameters = camera.getParameters();
        init();
    }

    /*
    anh xa
     */
    private void init(){
        tbtn_turnCamera = (ToggleButton)findViewById(R.id.tbtn_turnCamera);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            turnCamera();
        }else {
            offCamera();
        }
    }

    private void offCamera() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private void turnCamera() {
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.startPreview();
    }
}
