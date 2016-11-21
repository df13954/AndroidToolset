package com.ldrong.androidtoolset;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.ldrong.androidtoolset.base.AppContext;
import com.ldrong.androidtoolset.base.BaseActivity;
import com.ldrong.androidtoolset.conn.Constant;
import com.ldrong.androidtoolset.errors.ErrorReportActivity;
import com.ldrong.androidtoolset.greendao.DaoSession;
import com.ldrong.androidtoolset.greendao.User;
import com.ldrong.androidtoolset.ui.InputActivity;
import com.ldrong.androidtoolset.utils.OnNoDoubleClickListener;
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
    @BindView(R.id.btn_input)
    Button btnInput;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.nodouble)
    Button nodouble;
    private DaoSession mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSession = AppContext.getGreenDaoSessino();

        //Log.e(TAG, "表数据：" + DjsonUtils.bean2Json(mSession.getUserDao().queryBuilder().list()));
        setListener();
    }

    private void setListener() {
        //防止多次点击实现
        nodouble.setOnClickListener(new OnNoDoubleClickListener() {
            @Override
            public void onclick(View v) {
                Snackbar.make(activityMain,"点击",Snackbar.LENGTH_SHORT).show();
            }
        });


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

    @OnClick(R.id.btn_input)
    public void onClickinput() {
        startInt(InputActivity.class);
    }
}
