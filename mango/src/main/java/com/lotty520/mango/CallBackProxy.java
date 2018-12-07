package com.lotty520.mango;

import android.text.TextUtils;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;

/**
 * @author lotty
 */
public class CallBackProxy<T> implements SingleObserver<T> {

    private Callback<T> callback;

    public CallBackProxy(@Nullable Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
        if (callback != null) {
            callback.onGetClient(new Client(disposable));
        }

    }

    @Override
    public void onSuccess(@NonNull T t) {
        if (callback != null) {
            callback.onSuccess(t);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        String message = e.getMessage();
        if (TextUtils.isEmpty(message)) {
            message = "unKnow error";
        }
        if (callback != null) {
            callback.onError(e, message);
        }
    }
}
