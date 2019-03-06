package com.tj.lotty520.sample;

import android.app.Application;

import com.lotty520.mango.Mango;
import com.lotty520.mango.MangoConfig;

/**
 * @author lotty
 * @date 2017/9/10
 */

public class SampleApplication extends Application {

    private static final String BASE_POST_URL = "https://api.github.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        Mango.init(new MangoConfig.Builder().openLog(true).baseUrl(BASE_POST_URL).initDownloader(true).build());
    }
}
