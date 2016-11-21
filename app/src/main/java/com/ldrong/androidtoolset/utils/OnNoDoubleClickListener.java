package com.ldrong.androidtoolset.utils;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author ldr
 *         created at 2016/11/21 15:00
 * @Description: 类的描述 -点击事件，实现这个类，即可实现防止多次点击的效果，策略的事件课可以自由修改
 */
public abstract class OnNoDoubleClickListener implements OnClickListener {
    //记录上一次时间
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 1000) {
            lastClickTime = 0;
            return true;
        }
        lastClickTime = time;
        return false;
    }

    @Override
    public void onClick(View view) {
        if (OnNoDoubleClickListener.isFastDoubleClick()) {
            return;
        }
        onclick(view);
    }

    public abstract void onclick(View v);
}
