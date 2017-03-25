package com.syc.a43_eventbus;

import android.graphics.Bitmap;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/10/26 16:34
 * 备注:
 */

public class BitmapInfo {

    private Bitmap mBitmap;

    public BitmapInfo(Bitmap bitmap){
        this.mBitmap=bitmap;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }
}
