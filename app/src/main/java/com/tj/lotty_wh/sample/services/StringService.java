package com.tj.lotty_wh.sample.services;

import com.tj.lotty_wh.mango.Mango;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by lotty_wh on 2017/5/15.
 */

public interface StringService {

    StringService INSTANCE = Mango.createStringService(StringService.class);

    @GET()
    Single<String> doGet(@Url String url);

}
