package com.ldrong.androidtoolset.utils.screen;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;

import com.ldrong.androidtoolset.conn.Constant;


/**
 * @author ldr
 *         created at 2016/10/12 11:00
 * @Description: 类的描述 -获取屏幕信息
 */
public class ScreenInfo {

    public static int getScreenWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
//	    //取得窗口属性    
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
//	    //窗口的宽度    
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
//	    Log.i("changeportrai", screenWidth+"");
        Constant.screenWidth = screenWidth;
        Constant.screenHeight = screenHeight;
        Log.i("screenWidth", "" + screenWidth);
        Log.i("screenHeight", "" + screenHeight);
        return screenWidth;
    }
}
