package com.anxin.testlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anxin.modulea.ModuleA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ModuleA tModuleA = new ModuleA();
        tModuleA.printLog();
    }
}
