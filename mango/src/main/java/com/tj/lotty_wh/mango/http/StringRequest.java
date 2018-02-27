package com.tj.lotty_wh.mango.http;

import java.util.Map;

import com.tj.lotty_wh.mango.HttpResponse;
import com.tj.lotty_wh.mango.HttpScheduler;
import com.tj.lotty_wh.mango.services.StringService;

/**
 * Created by lotty on 2018/2/27.
 * 提供默认的String请求
 */

public class StringRequest {

    private StringRequest() {
    }

    public static void getString(String url, HttpResponse httpResponse) {
        StringService.INSTANCE.doGet(url).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(httpResponse);
    }

    public static void getString(String url, HttpResponse httpResponse, Map<String, String> parmas) {
        StringService.INSTANCE.doGet(url, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(httpResponse);
    }

    public static void postString(String url, HttpResponse httpResponse) {
        StringService.INSTANCE.doPost(url).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(httpResponse);
    }

    public static void postString(String url, HttpResponse httpResponse, Map<String, String> parmas) {
        StringService.INSTANCE.doPost(url, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(httpResponse);
    }

}
