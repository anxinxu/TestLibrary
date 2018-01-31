package com.anxin.modulea;

import android.app.Application;

import com.anxin.utils.Loger;

/**
 * Created by anxin on 2018/1/31.
 * <p>
 */

public class DemoApplication extends Application {
    private static final String TAG = "DemoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Loger.setLogEnable(BuildConfig.ENABLE_LOG);
        Loger.setGlobalTag("ModuleA");
        Loger.d(TAG, "onCreate() -> ");
    }
}
