package com.tj.lotty_wh.mango;

import java.util.concurrent.TimeUnit;

import com.tj.lotty_wh.mango.interceptor.ProgressInterceptor;
import com.tj.lotty_wh.mango.interceptor.ProgressListener;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * provide Retrofit an  OkHttpClient instance
 * <p>
 * Created by lotty_wh on 2017/5/8.
 */

class HttpClientProvider {

    private final static long DEFAULT_CONNECT_TIMEOUT = 10;
    private final static long DEFAULT_WRITE_TIMEOUT = 20;
    private final static long DEFAULT_READ_TIMEOUT = 10;


    //缓存默认的OkHttpClient对象
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
     * 请求监听的OkHttpClient
     */
    static OkHttpClient getProgressiveHttpClient(ProgressListener progressListener, boolean openLog) {
        OkHttpClient.Builder builder = apply(new OkHttpClient.Builder());
        if (openLog) {
            builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return builder.addInterceptor(new ProgressInterceptor(progressListener)).build();
    }

    /**
     * OkHttpClient.Builder settings
     */
    private static OkHttpClient.Builder apply(@NonNull OkHttpClient.Builder builder) {
        //设置超时时间
        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        // TODO: 2017/5/9 添加一些通用的拦截器
        return builder;
    }

}
