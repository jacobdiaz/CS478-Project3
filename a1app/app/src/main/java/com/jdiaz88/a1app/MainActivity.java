package com.jdiaz88.a1app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button grantAccessBtn;

    private static final String KABOOM_PERMISSION = "edu.uic.cs478.s19.kaboom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Hides the title bar

        grantAccessBtn = (Button) findViewById(R.id.grantaccessbtn);
        grantAccessBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkPermissionAndBroadcast();
            }
        }) ;

    }

    private void checkPermissionAndBroadcast(){
        boolean isGranted = ActivityCompat.checkSelfPermission(this, KABOOM_PERMISSION) == PackageManager.PERMISSION_GRANTED;
        if(isGranted){
            //TODO Broadcast an intent
            Toast.makeText(this, "Permission is already granted!", Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{KABOOM_PERMISSION},0);
        }
    }
    public void onRequestPermissionsResult(int code, String[] permissions, int[] results){
        if(results.length > 0){
            if (results[0] == PackageManager.PERMISSION_GRANTED) { // If its granted
                //TODO Broadcast an intent
                Toast.makeText(this, "Broadcasting an intent!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        }


    }
}