package com.lotty520.mango;

import android.text.TextUtils;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author lotty
 */
public class CallBackProxy<T> implements retrofit2.Callback<T> {

    private Callback<T> callback;

    public CallBackProxy(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (callback != null) {
            if (response.isSuccessful()) {
                callback.onSuccess(response.body());
            } else {
                callback.onError(null, response.body() == null ? "unKnow error" : response.body().toString());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String message = t.getMessage();
        if (TextUtils.isEmpty(message)) {
            message = "unKnow error";
        }
        if (callback != null) {
            callback.onError(t, message);
        }
    }
}
