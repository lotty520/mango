package com.tj.lotty_wh.sample;

import android.app.Application;

import com.tj.lotty_wh.mango.Mango;
import com.tj.lotty_wh.mango.MangoConfig;

/**
 * Created by lotty on 2017/9/10.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mango.init(new MangoConfig.Builder().openLog(true).baseUrl("http://www.baidu.com/").build());
    }
}
