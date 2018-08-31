package com.lotty520.mango.services;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author lotty_wh
 * @date 2017/5/15
 * <p>
 * 通用String请求
 */

public interface StringService {

    @GET
    Single<String> doGet(@Url String url);

    @GET
    Single<String> doGet(@Url String url, @FieldMap Map<String, Object> params);


    @GET("{path}")
    Single<String> doGetWithPath(@Path("path") String path);

    @GET("{path}")
    Single<String> doGetWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);


    @POST
    Single<String> doPost(@Url String url);

    @POST
    Single<String> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST("{path}")
    Single<String> doPostWithPath(@Path("path") String path);

    @POST("{path}")
    Single<String> doPostWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);

}
