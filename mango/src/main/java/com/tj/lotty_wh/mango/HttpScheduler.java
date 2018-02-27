package com.tj.lotty_wh.mango;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lotty_wh on 2017/5/9.
 */

public class HttpScheduler {

    /**
     * RxJava的链式流转换器，实现生产在IO线程，消费在安卓主线程
     *
     * @return
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
     *
     * @return
     */
    public static <T> SingleTransformer<T, T> applyAllInIOSchedulers() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(@NonNull Single<T> single) {
                return single.observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
            }
        };
    }

    /**
     * RxJava的链式流转换器，生产在新线程,消费在IO线程
     *
     * @return
     */
    public static <T> SingleTransformer<T, T> applySubscribeOnNewThread() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(@NonNull Single<T> single) {
                return single.observeOn(Schedulers.io()).subscribeOn(Schedulers.newThread());
            }
        };
    }

    /**
     * RxJava的链式流转换器，生产在新线程,消费在安卓主线程
     *
     * @return
     */
    public static <T> SingleTransformer<T, T> applyObserveOnMainThread() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(@NonNull Single<T> single) {
                return single.observeOn(Schedulers.io()).subscribeOn(Schedulers.newThread());
            }
        };
    }
}
