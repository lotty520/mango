package com.lotty520.mango.services;

import java.io.InputStream;
import java.util.Map;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @author lotty
 */
public interface StreamService {

    @GET
    @Streaming
    Single<InputStream> doGet(@Url String url);

    @GET
    @FormUrlEncoded
    @Streaming
    Single<InputStream> doGet(@Url String url, @FieldMap Map<String, Object> params);


    @GET("{path}")
    @Streaming
    Single<InputStream> doGetWithPath(@Path("path") String path);

    @GET("{path}")
    @FormUrlEncoded
    @Streaming
    Single<InputStream> doGetWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);


    @POST
    @Streaming
    Single<InputStream> doPost(@Url String url);

    @POST
    @FormUrlEncoded
    @Streaming
    Single<InputStream> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    @Streaming
    Single<InputStream> doPostWithBody(@Url String url, @Body RequestBody params);

    @POST("{path}")
    @Streaming
    Single<InputStream> doPostWithPath(@Path("path") String path);

    @POST("{path}")
    @FormUrlEncoded
    @Streaming
    Single<InputStream> doPostWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);

}
