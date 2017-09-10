package com.tj.lotty_wh.sample.services;

import com.tj.lotty_wh.mango.Mango;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by lotty_wh on 2017/5/15.
 * 返回类型为String类型的service
 */

public interface OmsStringService {

    String BASE_URL = "http://www.baidu.com/";

    OmsStringService INSTANCE = Mango.createStringService(OmsStringService.class);

    @GET()
    Single<String> doGet(@Url String url);

    @Streaming
    Call<String> get(@Url String url);

}
