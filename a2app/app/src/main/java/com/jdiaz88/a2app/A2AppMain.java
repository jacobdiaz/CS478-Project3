package com.jdiaz88.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class A2AppMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hides the title bar

        setContentView(R.layout.a2_app_main);
    }
}