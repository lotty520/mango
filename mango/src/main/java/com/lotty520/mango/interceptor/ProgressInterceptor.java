package com.lotty520.mango.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author lotty
 */
public class ProgressInterceptor implements Interceptor {

    private OnProgressChangedListener mListener;

    public ProgressInterceptor(OnProgressChangedListener progressListener) {
        this.mListener = progressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder()
                .body(new ProgressResponseBody(response.body(), mListener))
                .build();
    }

}