package com.anxin.testlibrary;

import android.app.Application;

import com.anxin.utils.Logger;

/**
 * Created by anxin on 2018/1/30.
 * <p>
 */

public class TestApplication extends Application {
    private static final String TAG = "TestApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.getCONFIG().enableLog(BuildConfig.DEBUG);
        Logger.d(TAG, this, "onCreate", BuildConfig.DEBUG);
    }
}
