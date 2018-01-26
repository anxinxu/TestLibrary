package com.anxin.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.support.annotation.IntDef;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * Created by anxin on 2018/1/26.
 * <p>日志
 */

public class Logger {

    public static final int V = Log.VERBOSE;
    public static final int D = Log.DEBUG;
    public static final int I = Log.INFO;
    public static final int W = Log.WARN;
    public static final int E = Log.ERROR;
    public static final int A = Log.ASSERT;

    @IntDef({V, D, I, W, E, A})
    private @interface Type {
    }

    private static boolean sLogEnable = true;   //log总开关，默认true
    private static boolean sLog2ConsoleEnable = true;    //log打印到console开关，默认true
    private static String sGlobalTag = null;   //log前缀
    private static boolean sLog2FileEnable = false;  //log写入文件开关，默认false
    private static String sDefaultDir = null;   //log默认写入文件目录，默认为空


    private static final Config CONFIG = new Config();
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");
    @SuppressLint("SimpleDateFormat")
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ");

    private Logger() {
    }

    public static Config getCONFIG() {
        return CONFIG;
    }

//    private static void log(final int type, final String tag, final Object... contents) {
//        if (!sLogEnable || (!sLog2ConsoleEnable && !sLog2FileEnable)) return;
//        if (sLog2ConsoleEnable) {
//            String msg = processMsg(contents);
//            print2Console(type, tag, msg);
//        }
//        if (sLog2FileEnable) {
//            print2File(type_low, tagHead.tag, tagHead.fileHead + body);
//        }
//    }

    private static String processMsg(Object[] contents) {
        return null;
    }

    private static String formatJson(String json) {
        try {
            if (json.startsWith("{")) {
                json = new JSONObject(json).toString(4);
            } else if (json.startsWith("[")) {
                json = new JSONArray(json).toString(4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static void print2Console(final int type, final String tag, final String msg){

    }

    public static class Config {

        private Config() {
            if (sDefaultDir != null) return;
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                    && Utils.getApp().getExternalCacheDir() != null)
                sDefaultDir = Utils.getApp().getExternalCacheDir() + FILE_SEP + "log" + FILE_SEP;
            else {
                sDefaultDir = Utils.getApp().getCacheDir() + FILE_SEP + "log" + FILE_SEP;
            }
        }

        public Config enableLog(boolean enableLog) {
            sLogEnable = enableLog;
            return this;
        }

        public Config enableLog2Console(boolean enableLog2Console) {
            sLog2ConsoleEnable = enableLog2Console;
            return this;
        }

        public Config enableLog2File(boolean enableLog2File) {
            sLog2FileEnable = enableLog2File;
            return this;
        }

        public Config globalTag(String globalTag) {
            sGlobalTag = globalTag;
            return this;
        }

    }
}
