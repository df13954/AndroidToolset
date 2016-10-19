package com.ldrong.androidtoolset.utils;

/**
* 
* @author ldr
* created at 2016/10/19 15:20
* @Description: 类的描述 -防止控件n次点击
 * 用法
 * if (!NoDoubleClickUtils.isDoubleClick()) {
        事件响应方法
        }

2、通过修改manifest中页面的launchMode属性改为单例模式

3利用RxBinding实现防重复点击

RxBinding 是 Jake Wharton 的一个开源库，它提供了一套在 Android 平台上的基于 RxJava 的 Binding API。
compile 'com.jakewharton.rxbinding:rxbinding:0.4.0'
RxView.clickEvents(button)
.throttleFirst(500, TimeUnit.MILLISECONDS)
.subscribe(clickAction);

http://blog.csdn.net/hjiangshujing/article/details/51613985
*/
public class NoDoubleClickUtils {
    private static long lastClickTime;
    private final static int SPACE_TIME = 500;

    public static void initLastClickTime() {
        lastClickTime = 0;
    }

    public synchronized static boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick2;
        if (currentTime - lastClickTime >
                SPACE_TIME) {
            isClick2 = false;
        } else {
            isClick2 = true;
        }
        lastClickTime = currentTime;
        return isClick2;
    }
}
