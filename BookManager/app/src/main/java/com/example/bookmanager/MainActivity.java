package com.example.bookmanager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.bookmanager.CustomizeView.CustomView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CustomView mVideoView;
    private int recLen = 10;   //视频时长
    private Button mTvJump;
    private Thread mThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView() {
        mTvJump=findViewById(R.id.tv_jump);
        mTvJump.setOnClickListener(this);
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        Message message = new Message();
                        message.what =1;
                        mHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mThread.start();
    }
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    recLen--;
                    mTvJump.setText(" "+recLen);
                    if (recLen <=6 && recLen>=0){
                        Log.d("lilei", "handleMessage: lllllllllkkkkk");
                        mTvJump.setVisibility(View.VISIBLE);
                        mTvJump.setText("跳过 "+recLen);

                    }else if(recLen <=0){
                        mTvJump.setVisibility(View.GONE);
                        mVideoView.stopPlayback();                  //停止播放
                        mHandler.removeCallbacks(mThread);          //移除
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        finish();  //退出
                        //结束线程，解决跳到登录界面一直收发消息的问题
                        mThread.stop();
                    }
            }
            super.handleMessage(msg);
        }


    };

    private void initData() {
        mVideoView = findViewById(R.id.video_view);
        // 加载视频资源
        mVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.boot));
        //播放
        mVideoView.start();
        //循环播放
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.start();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_jump:                  //跳过
               mVideoView.stopPlayback();                  //停止播放
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();                        //退出
                mThread.stop();
                break;
            default:
                break;
        }
    }

}