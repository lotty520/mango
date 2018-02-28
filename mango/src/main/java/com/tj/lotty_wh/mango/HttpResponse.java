package com.tj.lotty_wh.mango;

import android.text.TextUtils;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 对RxJava的SingleObserver简单封装
 * Created by lotty_wh on 2017/5/9.
 */

public abstract class HttpResponse<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        onGetDisposable(d);
    }

    @Override
    public void onSuccess(@NonNull T t) {
        onResponse(t);

    }

    @Override
    public void onError(@NonNull Throwable e) {
        String message = e.getMessage();
        if (TextUtils.isEmpty(message)) {
            message = "unKnow error!";
        }
        onError(e, message);
    }

    /**
     * 请求成功的回调
     *
     * @param result 返回泛型的结果
     */
    public abstract void onResponse(@NonNull T result);

    /**
     * 出错的回调
     *
     * @param msg 错误信息
     * @param t 异常对象
     */
    public abstract void onError(@NonNull Throwable t, @NonNull String msg);

    /**
     * 获取对应请求Disposable对象，实现对请求的管理
     *
     * @param disposable 网络管理对象
     */
    public abstract void onGetDisposable(@NonNull Disposable disposable);

}
