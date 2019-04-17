package com.lotty520.mango;

import android.text.TextUtils;

import com.lotty520.mango.services.StringService;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
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

    static void init() {
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


    public static void uploadFile(String url, Map<String, String> params, String key, File file, Callback<String> callback) {
        checkInit();
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        MultipartBody.Builder builder = new MultipartBody.Builder();
        if (params != null) {
            Set<String> keySet = params.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                String value = params.get(next);
                if (!TextUtils.isEmpty(next)) {
                    builder.addFormDataPart(next, value);
                }

            }
        }
        MultipartBody body = builder.addFormDataPart(key, file.getName(), fileBody).build();
        INSTANCE.uploadFile(url, body).enqueue(new CallBackProxy(callback));

    }

}
