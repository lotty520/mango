package com.lotty520.mango;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author lotty_wh
 * @date 2017/5/9
 */

public interface Callback<T> {

    /**
     * 出错的回调
     *
     * @param msg 错误信息
     * @param t   异常对象
     */
    void onError(@NonNull Throwable t, @NonNull String msg);

    /**
     * 请求成功的回调
     *
     * @param result 返回泛型的结果
     */
    void onSuccess(@NonNull T result);

    /**
     * 获取对应请求Disposable对象，实现对请求的管理
     *
     * @param disposable 网络管理对象
     */
    void onGetDisposable(@NonNull Disposable disposable);

}
