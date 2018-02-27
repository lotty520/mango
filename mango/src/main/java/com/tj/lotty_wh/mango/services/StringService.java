package com.tj.lotty_wh.mango.services;

import java.util.Map;

import com.tj.lotty_wh.mango.Mango;

import io.reactivex.Single;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by lotty_wh on 2017/5/15.
 *
 * 通用String请求
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
}
