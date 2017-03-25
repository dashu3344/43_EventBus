package com.syc.a43_eventbus;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends Activity {

    private String url="http://pimg1.126.net/movie/product/movie/147462332316110247_520_692_webp.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    //下载图片
    public void download(View view) {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url(url).get().build();
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()){
                        byte[] data = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        //传递信息的方法
                        EventBus.getDefault().post(new BitmapInfo(bitmap));
                        finish();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
