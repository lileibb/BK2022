package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //this是context对象,获取宽度和高度，更好的修改布局
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width11 = wm.getDefaultDisplay().getWidth();//getWidth()过期
        int height11 = wm.getDefaultDisplay().getHeight();//同上过期
        Log.d("ll", "onCreate: 宽"+width11+"   高"+height11);
    }
}