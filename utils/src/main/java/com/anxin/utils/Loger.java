package com.anxin.utils;

import android.support.annotation.IntDef;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by anxin on 2018/1/26.
 * <p>日志
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class Loger {

    public static final int V = Log.VERBOSE;
    public static final int D = Log.DEBUG;
    public static final int I = Log.INFO;
    public static final int W = Log.WARN;
    public static final int E = Log.ERROR;
    public static final int A = Log.ASSERT;

    @IntDef({V, D, I, W, E, A})
    private @interface Type {
    }

    private static final int OBJ = 0x10;
    private static final int JSON = 0x20;
    private static final int XML = 0x30;

    @IntDef({OBJ, JSON, XML})
    private @interface OutputType {
    }

    private static boolean sLogEnable = true;   //log总开关，默认true
    private static String sGlobalTag = "TAG";

    private static final String LINE_SEP = System.getProperty("line.separator");
    private static final String NULL = "null";
    private static final String ARGS = "args";
    private static final String NOTHING = "log nothing";

    private Loger() {
    }

    public static void setLogEnable(boolean logEnable) {
        sLogEnable = logEnable;
    }

    public static void setGlobalTag(String globalTag) {
        sGlobalTag = globalTag;
    }

    public static void v(String tag, final Object... contents) {
        log(V, OBJ, tag, contents);
    }

    public static void d(String tag, final Object... contents) {
        log(D, OBJ, tag, contents);
    }

    public static void i(String tag, final Object... contents) {
        log(I, OBJ, tag, contents);
    }

    public static void w(String tag, final Object... contents) {
        log(W, OBJ, tag, contents);
    }

    public static void e(String tag, final Object... contents) {
        log(E, OBJ, tag, contents);
    }

    public static void a(String tag, final Object... contents) {
        log(A, OBJ, tag, contents);
    }

    public static void json(String tag, final String content) {
        log(D, JSON, tag, content);
    }

    public static void json(@Type int type, String tag, final String content) {
        log(type, JSON, tag, content);
    }

    public static void xml(String tag, final String content) {
        log(D, XML, tag, content);
    }

    public static void xml(@Type int type, String tag, final String content) {
        log(type, XML, tag, content);
    }

    private static void log(@Type int type, @OutputType int outputType, final String tag, final Object... contents) {
        if (!sLogEnable) return;
        String msg = processMsg(outputType, contents);
        String resultTag = !TextUtils.isEmpty(tag) ? "[" + sGlobalTag + " -> " + tag + "]" : "[" + sGlobalTag + "]";
        print2Console(type, resultTag, msg);
    }

    private static String processMsg(@OutputType int outputType, Object... contents) {
        String msg = NULL;
        if (contents != null && contents.length > 0) {
            if (contents.length == 1) {
                Object object = contents[0];
                if (object == null) return msg;
                if (outputType == OBJ) {
                    msg = object.toString();
                } else if (outputType == JSON) {
                    msg = formatJson(object.toString());
                } else if (outputType == XML) {
                    msg = formatXml(object.toString());
                }
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < contents.length; i++) {
                    Object object = contents[i];
                    sb.append(ARGS)
                            .append("[")
                            .append(i)
                            .append("]")
                            .append(" = ")
                            .append(object == null ? NULL : object.toString())
                            .append(i == contents.length - 1 ? "" : LINE_SEP);
                }
                msg = sb.toString();
            }
        }
        return msg.length() == 0 ? NOTHING : msg;
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

    private static String formatXml(String xml) {
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(xmlInput, xmlOutput);
            xml = xmlOutput.getWriter().toString().replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    private static void print2Console(final int type, final String tag, final String msg) {
        Log.println(type, tag, msg);
    }

}
