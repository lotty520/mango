package com.lotty520.mango.services;

import java.util.Map;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
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
    Single<String> doGet(@Url String url, @QueryMap Map<String, Object> params);

    @GET("{path}")
    Single<String> doGetWithPath(@Path("path") String path);

    @GET("{path}")
    Single<String> doGetWithPath(@Path("path") String path, @QueryMap Map<String, Object> params);

    @GET
    Single<String> doGetWithHeader(@Url String url, @HeaderMap Map<String, String> headers);

    @GET("{path}")
    Single<String> doGetPathWithHeader(@Path("path") String url, @HeaderMap Map<String, String> headers);


    @POST
    Single<String> doPost(@Url String url);

    @FormUrlEncoded
    @POST
    Single<String> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Single<String> doPostWithBody(@Url String url, @Body RequestBody params);

    @POST
    Single<String> doPostWithBody(@Url String url, @Body RequestBody params, @HeaderMap Map<String, String> header);

    @POST("{path}")
    Single<String> doPostWithPath(@Path("path") String path);

    @FormUrlEncoded
    @POST("{path}")
    Single<String> doPostWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);

}
