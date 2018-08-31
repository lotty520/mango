package com.lotty520.mango;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lotty_wh
 * @date 2017/5/9
 */

public class HttpScheduler {

    /**
     * RxJava的链式流转换器，实现生产在IO线程，消费在安卓主线程
     */
    public static <T> SingleTransformer<T, T> applyAndroidSchedulers() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(@NonNull Single<T> single) {
                return single.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

    /**
     * RxJava的链式流转换器，实现生产和消费都在IO线程
     */
    public static <T> SingleTransformer<T, T> applyIOSchedulers() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(@NonNull Single<T> single) {
                return single.observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
            }
        };
    }

}
