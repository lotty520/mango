package com.tj.lotty_wh.mango.services;

import java.util.List;
import java.util.Map;

import com.tj.lotty_wh.mango.Mango;

import io.reactivex.Single;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by lotty_wh on 2017/5/15.
 */

public interface StringService {

    StringService INSTANCE = Mango.createStringService(StringService.class);

    @GET()
    Single<String> doGet(@Url String url);

    @GET
    Single<String> doGet(@Url String url, @FieldMap Map<String, String> params);


    @POST()
    Single<String> doPost(@Url String url);

    @POST()
    Single<String> doPost(@Url String url, @FieldMap Map<String, String> params);

    @GET
    @Streaming
    Call<String> get(@Url String url);

    @GET
    @Streaming
    Call<String> get(@Url String url, @FieldMap Map<String, String> params);

    @POST
    @Streaming
    Call<String> post(@Url String url);

    @POST
    @Streaming
    Call<String> post(@Url String url, @FieldMap Map<String, String> params);
}
