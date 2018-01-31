package com.anxin.testlibrary;

import android.app.Application;

import com.anxin.utils.Loger;

/**
 * Created by anxin on 2018/1/30.
 * <p>
 */

public class TestApplication extends Application {
    private static final String TAG = "TestApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Loger.setLogEnable(BuildConfig.ENABLE_LOG);
        Loger.setGlobalTag("testLibrary");
        Loger.d(TAG, "onCreate() -> ");
    }
}
