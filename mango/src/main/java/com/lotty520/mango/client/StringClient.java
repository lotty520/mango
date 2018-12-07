package com.lotty520.mango.client;

import com.lotty520.mango.CallBackProxy;
import com.lotty520.mango.Callback;
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

    public static void get(String url, Callback<String> callback) {
        checkInit();
        INSTANCE.doGet(url).enqueue(new CallBackProxy(callback));
    }

    private static void checkInit() {
        if (INSTANCE == null) {
            throw new IllegalStateException("should init first");
        }
    }

    public static void get(String url, Map<String, Object> parmas, Callback<String> callback) {
        checkInit();
        INSTANCE.doGet(url, parmas).enqueue(new CallBackProxy(callback));
    }

    public static void getWithPath(String path, Callback<String> callback) {
        checkInit();
        INSTANCE.doGetWithPath(path).enqueue(new CallBackProxy(callback));
    }

    public static void getWithPath(String path, Map<String, Object> parmas, Callback<String> callback) {
        checkInit();
        INSTANCE.doGetWithPath(path, parmas).enqueue(new CallBackProxy(callback));
    }

    public static void getWithHeaderFromUrl(String url, Map<String, String> header, Callback<String> callback) {
        checkInit();
        INSTANCE.doGetWithHeader(url, header).enqueue(new CallBackProxy(callback));
    }

    public static void getWithHeaderFromPath(String path, Map<String, String> header, Callback<String> callback) {
        checkInit();
        INSTANCE.doGetPathWithHeader(path, header).enqueue(new CallBackProxy(callback));
    }


    public static void post(String url, Callback<String> callback) {
        checkInit();
        INSTANCE.doPost(url).enqueue(new CallBackProxy(callback));
    }

    public static void post(String url, Map<String, Object> parmas, Callback<String> callback) {
        checkInit();
        INSTANCE.doPost(url, parmas).enqueue(new CallBackProxy(callback));
    }

    public static void postWithBody(String url, String parmas, Callback<String> callback) {
        checkInit();
        RequestBody requestBody = RequestBody.create(null, parmas);
        INSTANCE.doPostWithBody(url, requestBody).enqueue(new CallBackProxy(callback));
    }

    public static void postWithBody(String url, String parmas, Map<String, String> header, Callback<String> callback) {
        checkInit();
        RequestBody requestBody = RequestBody.create(null, parmas);
        INSTANCE.doPostWithBody(url, requestBody, header).enqueue(new CallBackProxy(callback));
    }

    public static void postWithPath(String path, Callback<String> callback) {
        checkInit();
        INSTANCE.doPostWithPath(path).enqueue(new CallBackProxy(callback));
    }

    public static void postWithPath(String path, Map<String, Object> parmas, Callback<String> callback) {
        checkInit();
        INSTANCE.doPostWithPath(path, parmas).enqueue(new CallBackProxy(callback));
    }

}
