package com.lotty520.mango;

import com.lotty520.mango.interceptor.OnProgressChangedListener;
import com.lotty520.mango.interceptor.ProgressInterceptor;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * provide Retrofit an  OkHttpClient instance
 * <p>
 * Created by lotty_wh on 2017/5/8.
 */

class HttpClientProvider {

    private final static long DEFAULT_CONNECT_TIMEOUT = 20;
    private final static long DEFAULT_WRITE_TIMEOUT = 20;
    private final static long DEFAULT_READ_TIMEOUT = 20;


    /**
     * 缓存默认的OkHttpClient对象
     */
    private static OkHttpClient sDefaultClient;

    /**
     * 不希望调用者创建对象
     */
    private HttpClientProvider() {
    }

    /**
     * 获取默认的OkHttpClient
     */
    static OkHttpClient getDefault(boolean openLog) {
        synchronized (HttpClientProvider.class) {
            if (sDefaultClient == null) {
                OkHttpClient.Builder builder = apply(new OkHttpClient.Builder());
                if (openLog) {
                    builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
                }
                sDefaultClient = builder.build();
            }
        }
        return sDefaultClient;
    }

    /**
     * OkHttpClient.Builder settings
     */
    private static OkHttpClient.Builder apply(@NonNull OkHttpClient.Builder builder) {
        //设置超时时间
        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        return builder;
    }

    /**
     * 请求监听的OkHttpClient
     */
    static OkHttpClient getProgressiveHttpClient(OnProgressChangedListener progressListener, boolean openLog) {
        OkHttpClient.Builder builder = apply(new OkHttpClient.Builder());
        if (openLog) {
            builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.addInterceptor(new ProgressInterceptor(progressListener)).build();
    }

}
