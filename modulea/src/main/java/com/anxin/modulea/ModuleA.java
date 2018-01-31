package com.anxin.modulea;

import com.anxin.utils.Loger;

/**
 * Created by anxin on 2018/1/31.
 * <p>
 */

public class ModuleA {
    private static final String TAG = "ModuleA";

    public ModuleA() {
    }

    public void printLog(){
        Loger.d(TAG, "printLog() -> ");
    }
}
