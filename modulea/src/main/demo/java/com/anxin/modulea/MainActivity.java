package com.anxin.modulea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anxin.utils.Loger;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulea_activity_main);
        Loger.d(TAG, "onCreate() -> ");
    }
}
