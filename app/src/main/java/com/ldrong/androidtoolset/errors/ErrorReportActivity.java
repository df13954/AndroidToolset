package com.ldrong.androidtoolset.errors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ldrong.androidtoolset.R;
import com.ldrong.androidtoolset.base.AppContext;
import com.ldrong.androidtoolset.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ldr
 *         created at 2016/11/3 15:41
 * @Description: 类的描述 -收集最后一次奔溃的时候，捕获的异常
 */
public class ErrorReportActivity extends BaseActivity {
    @BindView(R.id.tv_errormsg)
    TextView tvErrormsg;
    @BindView(R.id.btn_clear)
    Button btnClear;
    private AppContext softApplication;
    private String info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
        softApplication = (AppContext) getApplication();

        TextView tv_errormsg = (TextView) findViewById(R.id.tv_errormsg);
        Button btn_clear = (Button) findViewById(R.id.btn_clear);

        info = getIntent().getStringExtra("error");
        tv_errormsg.setText(info);


        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                SharePerferenceUtil perferenceUtil = SharePerferenceUtil.getInstance(ErrorReportActivity.this,
//                        Constant.APP_INFO);
//                perferenceUtil.setStringValue(Constant.ERRORMSG, "");
                finish();
            }
        });

    }

}