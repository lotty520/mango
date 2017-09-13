package com.tj.lotty_wh.sample.services;

import com.tj.lotty_wh.mango.Mango;
import com.tj.lotty_wh.sample.entity.WeatherInfo;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by lotty on 2017/9/13.
 */

public interface JsonService {
    JsonService INSTANCE = Mango.createJsonService(JsonService.class);

    @GET()
    Single<WeatherInfo> doGet(@Url String url);
}
