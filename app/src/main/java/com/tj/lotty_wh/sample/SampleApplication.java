package com.tj.lotty_wh.sample;

import android.app.Application;

import com.lotty520.mango.Mango;
import com.lotty520.mango.MangoConfig;

/**
 * @author lotty
 * @date 2017/9/10
 */

public class SampleApplication extends Application {

    private static final String BASE_URL = "http://www.weather.com.cn/";

    @Override
    public void onCreate() {
        super.onCreate();
        Mango.init(new MangoConfig.Builder().openLog(true).baseUrl(BASE_URL).build());
    }
}
