package com.syc.a43_eventbus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivShow = (ImageView) findViewById(R.id.iv_show);

        //注册EventBus
        EventBus.getDefault().register(this);
    }

    //跳转
    public void start(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    //publish:发布.--->
    //@Subscribe:订阅
    //ThreadMode:--->线程模型.
    //ThreadMode.MAIN:--->无论消息来自哪个线程,一律在主线程中接受消息;
    //注意:就不能在该线程进行耗时的操作.
    //ThreadMode.BACKGROUND:--->无论消息来自于哪个线程,此时该方法就属于工作线程;
    //此时就不能进行ui的更新;
    //ThreadMode.POSTING:--->消息的发送发生在哪个线程,此时该方法就属于哪个线程;
    //ThreadMode.ASYNC:--->无论消息的发送发生在哪个线程,此时一律开启一个新线程!
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiverMsg(BitmapInfo msg){
        Bitmap bitmap = msg.getmBitmap();
        ivShow.setImageBitmap(bitmap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        EventBus.getDefault().unregister(this);
    }
}
