package com.ldrong.androidtoolset;

import android.os.Bundle;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.androidtoolset.base.AppContext;
import com.ldrong.androidtoolset.base.BaseActivity;
import com.ldrong.androidtoolset.greendao.DaoSession;

public class MainActivity extends BaseActivity {

    private DaoSession mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSession = AppContext.getGreenDaoSessino();

        //插入数据
        //mSession.getUserDao().insert(new User(1l, "xiaoming", 20));

        //Log.e(TAG, "表数据：" + DjsonUtils.bean2Json(mSession.getUserDao().queryBuilder().list()));

        LogUtils.e(mSession.getUserDao().queryBuilder().list());

    }
}
