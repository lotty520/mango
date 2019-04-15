package com.lotty520.mango.services;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
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
    Call<String> doGet(@Url String url);

    @GET
    Call<String> doGet(@Url String url, @QueryMap Map<String, Object> params);

    @GET("{path}")
    Call<String> doGetWithPath(@Path("path") String path);

    @GET("{path}")
    Call<String> doGetWithPath(@Path("path") String path, @QueryMap Map<String, Object> params);

    @GET
    Call<String> doGetWithHeader(@Url String url, @HeaderMap Map<String, String> headers);

    @GET("{path}")
    Call<String> doGetPathWithHeader(@Path("path") String url, @HeaderMap Map<String, String> headers);


    @POST
    Call<String> doPost(@Url String url);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Call<String> doPostWithBody(@Url String url, @Body RequestBody params);

    @POST
    Call<String> doPostWithBody(@Url String url, @Body RequestBody params, @HeaderMap Map<String, String> header);

    @POST("{path}")
    Call<String> doPostWithPath(@Path("path") String path);

    @FormUrlEncoded
    @POST("{path}")
    Call<String> doPostWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);

    @POST
    Call<String> uploadFile(@Url String url, @Body RequestBody body);

}
