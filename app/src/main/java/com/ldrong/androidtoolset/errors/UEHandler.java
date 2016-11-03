package com.ldrong.androidtoolset.errors;

import android.content.Intent;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.androidtoolset.base.AppContext;
import com.ldrong.androidtoolset.conn.Constant;
import com.ldrong.androidtoolset.utils.SharePerferenceUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

/**
 * @author ldr
 *         created at 2016/11/3 15:18
 * @Description: 类的描述 -奔溃异常的捕获
 */
public class UEHandler implements Thread.UncaughtExceptionHandler {
    private AppContext softApp;
//    private File fileErrorLog;

    public static final String PATH_ERROR_LOG = File.separator + "data" + File.separator + "data"
            + File.separator + "com.ldrong.androidtoolset" + File.separator + "files" + File.separator
            + "error123.log";

    public UEHandler(AppContext app) {
        softApp = app;
//        fileErrorLog = new File(PATH_ERROR_LOG);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // fetch Excpetion Info
        String info = null;
        ByteArrayOutputStream baos = null;
        PrintStream printStream = null;
        try {
            baos = new ByteArrayOutputStream();
            printStream = new PrintStream(baos);
            ex.printStackTrace(printStream);
            byte[] data = baos.toByteArray();
            info = new String(data);
            data = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (printStream != null) {
                    printStream.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // print
        long threadId = thread.getId();
        String s = PATH_ERROR_LOG;
        LogUtils.e("ANDROID_LAB", "Thread.getName()=" + thread.getName() + " id=" + threadId + " state=" + thread.getState());
        LogUtils.e("ANDROID_LAB", "Error[" + info + "]");
        if (threadId != 1) {
            SharePerferenceUtil perferenceUtil = SharePerferenceUtil.getInstance(softApp,
                    Constant.APP_INFO);
            String stringValue = perferenceUtil.getStringValue(Constant.ERRORMSG);
            Intent intent = new Intent(softApp, ErrorReportActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("error", stringValue);
            intent.putExtra("by", "uehandler");
            softApp.startActivity(intent);
        } else {
            //报错信息保存
            SharePerferenceUtil perferenceUtil = SharePerferenceUtil.getInstance(softApp, Constant.APP_INFO);
            perferenceUtil.setStringValue(Constant.ERRORMSG, info);
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
//            // kill App Progress
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

}