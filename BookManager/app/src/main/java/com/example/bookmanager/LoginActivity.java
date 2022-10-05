package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookmanager.Utils.IronUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView ironTitle,showButton;
    private EditText account,password;
    public boolean showpsd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //this是context对象,获取宽度和高度，更好的修改布局
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width11 = wm.getDefaultDisplay().getWidth();//getWidth()过期
        int height11 = wm.getDefaultDisplay().getHeight();//同上过期
        Log.d("ll", "onCreate: 宽"+width11+"   高"+height11);
        initView();
    }

    //初始化View
    private void initView() {
        account = findViewById(R.id.AccountText);
        password = findViewById(R.id.PasswordText);
        ironTitle =findViewById(R.id.ironTitle);
        showButton = findViewById(R.id.ShowButton);
        //默认密码不可见
        showpsd = false;
        //设置appiron标题字体样式(方正舒体)
        ironTitle.setTypeface(Typeface.createFromAsset(getAssets(),"font/FZSTK.TTF"));
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

        }
    }
}