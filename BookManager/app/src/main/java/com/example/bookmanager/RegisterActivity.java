package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookmanager.Utils.IronUtils;

import cn.bmob.v3.Bmob;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private TextView ironTitle,showButton;
    private EditText account,password;
    private boolean showpsd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(RegisterActivity.this,"e3229472d1c86ff68ad4b1962c1e656a");
        initView();
    }

    private void initView() {
        register = findViewById(R.id.registerButton);
        account = findViewById(R.id.AccountText);
        password = findViewById(R.id.PasswordText);
        ironTitle =findViewById(R.id.ironTitle);
        showButton = findViewById(R.id.ShowButton);
        //默认密码不可见
        showpsd = false;
        //设置字体样式(方正舒体)
        ironTitle.setTypeface(Typeface.createFromAsset(getAssets(),"font/FZSTK.TTF"));
        register.setTypeface(Typeface.createFromAsset(getAssets(),"font/FZSTK.TTF"));
        //适配账号密码图标
        IronUtils.changeDraw(this,account,R.mipmap.account);
        IronUtils.changeDraw(this,password,R.mipmap.password);
        showButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ShowButton:
                if(showpsd == false){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password.setSelection(password.getText().toString().length());
                    showButton.setSelected(true);
                    showpsd = true;
                }else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password.setSelection(password.getText().toString().length());
                    showButton.setSelected(false);
                    showpsd = false;
                }
                break;
        }

    }
}