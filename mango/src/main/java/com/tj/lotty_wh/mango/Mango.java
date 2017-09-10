package com.tj.lotty_wh.mango;


import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Field;

import com.tj.lotty_wh.mango.converter.FastJsonConverterFactory;
import com.tj.lotty_wh.mango.converter.InputStreamConvertFactory;
import com.tj.lotty_wh.mango.converter.StringConvertFactory;
import com.tj.lotty_wh.mango.interceptor.ProgressListener;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Http请求
 * Created by lotty_wh on 2017/5/8.
 */

public class Mango {
    private static final String TAG = "Mango";
    private static boolean sIsLogOpen = false;
    private static String sDefaultBaseUrl;

    public static void init(@Nullable MangoConfig config) {
        if (config != null) {
            sIsLogOpen = config.mOpenLog;
            sDefaultBaseUrl = config.mBaseUrl;
        }
    }

    private Mango() {
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
                .baseUrl(fetchBaseUrl(serviceClass))
                .client(HttpClientProvider.getDefault(sIsLogOpen))
                .addConverterFactory(StringConvertFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
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
                .baseUrl(fetchBaseUrl(serviceClass))
                .client(HttpClientProvider.getDefault(sIsLogOpen))
                .addConverterFactory(InputStreamConvertFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * 创建 JSON 请求
     *
     * @param serviceClass service 类
     * @param <S>          用于请求的 service 泛型类型
     * @return 用于请求的 service 对象
     */
    public static <S> S createJsonService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fetchBaseUrl(serviceClass))
                .client(HttpClientProvider.getDefault(sIsLogOpen))
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * 创建 下载进度回调的 请求
     *
     * @param serviceClass service 类
     * @param <S>          用于请求的 service 泛型类型
     * @param progressListener 下载进度监听器
     * @return 用于请求的 service 对象
     */
    public static <S> S createInputStreamServiceWithProgessListener(Class<S> serviceClass, ProgressListener progressListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fetchBaseUrl(serviceClass))
                .client(HttpClientProvider.getProgressiveHttpClient(progressListener, sIsLogOpen))
                .addConverterFactory(InputStreamConvertFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * 获取BaseUrl
     */
    private static String fetchBaseUrl(Class serviceClass) {
        String baseUrl = "";
        try {
            Field urlFiled = serviceClass.getDeclaredField("BASE_URL");
            urlFiled.setAccessible(true);
            baseUrl = (String) urlFiled.get(serviceClass);
        } catch (NoSuchFieldException e) {
            if (sIsLogOpen) {
                Log.d(TAG, "Get baseUrl with reflection failed", e);
            }
        } catch (IllegalAccessException e) {
            if (sIsLogOpen) {
                Log.d(TAG, "Get baseUrl with reflection failed", e);
            }
        }
        if (TextUtils.isEmpty(baseUrl)) {
            baseUrl = sDefaultBaseUrl;
        }
        return baseUrl;
    }

}
