package com.lotty520.mango.services;

import java.io.InputStream;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.FieldMap;
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
    @Streaming
    Single<InputStream> doGet(@Url String url, @FieldMap Map<String, Object> params);


    @GET("{path}")
    @Streaming
    Single<InputStream> doGetWithPath(@Path("path") String path);

    @GET("{path}")
    @Streaming
    Single<InputStream> doGetWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);


    @POST
    @Streaming
    Single<InputStream> doPost(@Url String url);

    @POST
    @Streaming
    Single<InputStream> doPost(@Url String url, @FieldMap Map<String, Object> params);

    @POST("{path}")
    @Streaming
    Single<InputStream> doPostWithPath(@Path("path") String path);

    @POST("{path}")
    @Streaming
    Single<InputStream> doPostWithPath(@Path("path") String path, @FieldMap Map<String, Object> params);

}
