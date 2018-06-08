package com.example.quarterhour.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApp extends Application{
    {
        PlatformConfig.setQQZone("1106791541", "4cjDBYUvtHJlkML0");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        UMConfigure.init(this,"5b19391df43e4835440000c6"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

    }
}
