package com.lotty520.mango.client;

import com.lotty520.mango.Callback;
import com.lotty520.mango.HttpScheduler;
import com.lotty520.mango.Mango;
import com.lotty520.mango.services.StringService;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * @author lotty
 * @date 2018/2/27
 * 提供默认的String请求
 */

public class StringClient {

    private static StringService INSTANCE = null;

    private StringClient() {

    }

    public static void init() {
        INSTANCE = Mango.createStringService(StringService.class);
    }

    public static void get(String url, Callback callback) {
        checkInit();
        INSTANCE.doGet(url).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    private static void checkInit() {
        if (INSTANCE == null) {
            throw new IllegalStateException("should init first");
        }
    }

    public static void get(String url, Map<String, Object> parmas, Callback callback) {
        checkInit();
        INSTANCE.doGet(url, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void getWithPath(String path, Map<String, Object> parmas, Callback callback) {
        checkInit();
        INSTANCE.doGetWithPath(path, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void getWithPath(String path, Callback callback) {
        checkInit();
        INSTANCE.doGetWithPath(path).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }


    public static void post(String url, Callback callback) {
        checkInit();
        INSTANCE.doPost(url).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void post(String url, Map<String, Object> parmas, Callback callback) {
        checkInit();
        INSTANCE.doPost(url, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void postWithBody(String url, String parmas, Callback callback) {
        checkInit();
        RequestBody requestBody = RequestBody.create(null, parmas);
        INSTANCE.doPostWithBody(url, requestBody).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void postWithBody(String url, String parmas, String contentType, Callback callback) {
        checkInit();
        RequestBody requestBody = RequestBody.create(null, parmas);
        INSTANCE.doPostWithBody(url, requestBody, contentType).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void postWithPath(String path, Callback callback) {
        checkInit();
        INSTANCE.doPostWithPath(path).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

    public static void postWithPath(String path, Map<String, Object> parmas, Callback callback) {
        checkInit();
        INSTANCE.doPostWithPath(path, parmas).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(callback);
    }

}
