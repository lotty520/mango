package com.lotty520.mango.services;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @ProjectName: mango
 * @Package: com.lotty520.mango.services
 * @ClassName: FileService
 * @Description: java类作用描述
 * @Author: 吴晗
 */
public interface FileService {

    @GET
    @Streaming
    Call<InputStream> doGet(@Url String url);

    @POST
    @Streaming
    @FormUrlEncoded
    Call<InputStream> doPost(@Url String url);

}
