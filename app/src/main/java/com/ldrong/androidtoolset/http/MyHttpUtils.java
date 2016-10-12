package com.ldrong.androidtoolset.http;

import android.content.Context;

import com.ldrong.androidtoolset.conn.Constant;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.Map;

/**
 * Created by Administrator on 2016/9/21.
 */

public class MyHttpUtils {

    public static void sendPost(Map map, Context mContext, Callback call) {
        try {
            OkHttpUtils
                    .postString()
                    .url(Constant.BaseUrl)
                    .addHeader("head", "head")//把map转json
                    .content("")//入参
                    .tag(mContext)  //可标记请求，然后destroy里面取消
                    .build()
                    .execute(call);//关于call，是自定义继承Callback
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
