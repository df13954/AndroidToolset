package com.ldrong.androidtoolset;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.androidtoolset.base.AppContext;
import com.ldrong.androidtoolset.base.BaseActivity;
import com.ldrong.androidtoolset.conn.Constant;
import com.ldrong.androidtoolset.errors.ErrorReportActivity;
import com.ldrong.androidtoolset.greendao.DaoSession;
import com.ldrong.androidtoolset.greendao.User;
import com.ldrong.androidtoolset.utils.SharePerferenceUtil;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_insert)
    Button btnInsert;
    @BindView(R.id.btn_query)
    Button btnQuery;
    @BindView(R.id.errortext)
    Button errortext;
    @BindView(R.id.rep)
    Button rep;
    private DaoSession mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSession = AppContext.getGreenDaoSessino();

        //Log.e(TAG, "表数据：" + DjsonUtils.bean2Json(mSession.getUserDao().queryBuilder().list()));

    }

    @OnClick(R.id.btn_insert)
    public void onClickInsert() {
        //插入数据
        mSession.getUserDao().insert(new User(null, "xiaoming", new Random().nextInt(100)));
    }

    @OnClick(R.id.btn_query)
    public void onClick() {
        LogUtils.e(mSession.getUserDao().queryBuilder().list());
        Toast.makeText(mContext, "" + mSession.getUserDao().queryBuilder().list(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.errortext)
    public void onClick11() {
        //进入查看错误报告的界面
        SharePerferenceUtil perferenceUtil = SharePerferenceUtil.getInstance(this, Constant.APP_INFO);
        String s = perferenceUtil.getStringValue(Constant.ERRORMSG);
        if (TextUtils.isEmpty(s)) {
            return;
        }
        Intent intent = new Intent(this, ErrorReportActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("error", s);
        intent.putExtra("by", "uehandler");
        startActivity(intent);
    }
}
