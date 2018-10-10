package com.lotty520.mango.client;

import com.lotty520.mango.CallBackProxy;
import com.lotty520.mango.Callback;
import com.lotty520.mango.HttpScheduler;
import com.lotty520.mango.Mango;
import com.lotty520.mango.services.StreamService;

import java.io.InputStream;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * @author lotty
 */
public class StreamClient {

    private static StreamService INSTANCE = null;


    private StreamClient() {
    }

    public static void init() {
        INSTANCE = Mango.createInputStreamService(StreamService.class);
    }

    public static void get(String url, Callback callback) {
        checkInit();
        INSTANCE.doGet(url).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    private static void checkInit() {
        if (INSTANCE == null) {
            throw new IllegalStateException("should init first");
        }
    }

    public static void get(String url, Callback callback, Map<String, Object> parmas) {
        checkInit();
        INSTANCE.doGet(url, parmas).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void getWithPath(String path, Callback callback) {
        checkInit();
        INSTANCE.doGetWithPath(path).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void getWithPath(String path, Callback callback, Map<String, Object> parmas) {
        checkInit();
        INSTANCE.doGetWithPath(path, parmas).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void post(String url, Callback callback) {
        checkInit();
        INSTANCE.doPost(url).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void post(String url, Callback callback, Map<String, Object> parmas) {
        checkInit();
        INSTANCE.doPost(url, parmas).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void postWithBody(String url, String parmas, Callback callback) {
        checkInit();
        RequestBody requestBody = RequestBody.create(null, parmas);
        INSTANCE.doPostWithBody(url, requestBody).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void postWithPath(String path, Callback callback) {
        checkInit();
        INSTANCE.doPostWithPath(path).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }

    public static void postWithPath(String path, Callback callback, Map<String, Object> parmas) {
        checkInit();
        INSTANCE.doPostWithPath(path, parmas).compose(HttpScheduler.<InputStream>applyAndroidSchedulers())
                .subscribe(new CallBackProxy(callback));
    }
}
