package com.ldrong.androidtoolset.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.ldrong.androidtoolset.R;
import com.ldrong.androidtoolset.utils.edittext.CheckTextNumber;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);

        //android:windowSoftInputMode="adjustResize" 配置文件对应的Activity
        //检查剩余字数
        CheckTextNumber.setEditTextChangeListener(etContent,tvContent,800);
    }
}
