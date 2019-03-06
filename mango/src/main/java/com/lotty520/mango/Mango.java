package com.lotty520.mango;


import android.text.TextUtils;

import com.lotty520.mango.converter.InputStreamConvertFactory;
import com.lotty520.mango.converter.StringConvertFactory;
import com.lotty520.mango.interceptor.OnProgressChangedListener;

import retrofit2.Retrofit;

/**
 * Http请求
 *
 * @author lotty_wh
 * @date 2017/5/8
 */

public class Mango {
    private static final String SUFFIX = "/";
    private static boolean isLogOpen = false;
    private static String baseUrl;

    private Mango() {
    }

    public static void init(MangoConfig config) {
        if (config != null) {
            isLogOpen = config.openLog;
            baseUrl = config.baseURL;
            if (config.initLoader) {
                FileClient.init();
            }
        }
        StringClient.init();
    }

    /**
     * 获取字符串的请求
     *
     * @param serviceClass service 类
     * @param <S>          用于请求的 service 泛型类型
     * @return 用于请求的 service 对象
     */
    public static <S> S createStringService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fetchBaseUrl())
                .client(HttpClientProvider.getDefault(isLogOpen))
                .addConverterFactory(StringConvertFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * 获取BaseUrl
     */
    private static String fetchBaseUrl() {
        if (!TextUtils.isEmpty(baseUrl) && baseUrl.endsWith(SUFFIX)) {
            return baseUrl;
        } else {
            throw new IllegalStateException("should init baseURL rightly");
        }
    }

    /**
     * 获取输入流的请求
     *
     * @param serviceClass service 类
     * @param <S>          用于请求的 service 泛型类型
     * @return 用于请求的 service 对象
     */
    public static <S> S createInputStreamService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fetchBaseUrl())
                .client(HttpClientProvider.getDefault(isLogOpen))
                .addConverterFactory(InputStreamConvertFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * 创建 下载进度回调的 请求
     *
     * @param serviceClass     service 类
     * @param <S>              用于请求的 service 泛型类型
     * @param progressListener 下载进度监听器
     * @return 用于请求的 service 对象
     */
    public static <S> S createServiceWithProgessListener(Class<S> serviceClass, OnProgressChangedListener progressListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fetchBaseUrl())
                .client(HttpClientProvider.getProgressiveHttpClient(progressListener, isLogOpen))
                .addConverterFactory(InputStreamConvertFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

}
