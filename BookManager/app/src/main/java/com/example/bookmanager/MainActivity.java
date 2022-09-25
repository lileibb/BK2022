package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.bookmanager.CustomizeView.CustomView;

public class MainActivity extends AppCompatActivity {


    private CustomView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = findViewById(R.id.video_view);
        // 加载视频资源
        mVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.boot));
        //播放
        mVideoView.start();

    }
}