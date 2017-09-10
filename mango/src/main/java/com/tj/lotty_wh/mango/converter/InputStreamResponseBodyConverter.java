package com.tj.lotty_wh.mango.converter;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 输入流响应Body转换器，提供将数据已输入流的形式响应给Retrofit
 * Created by lotty_wh on 2017/5/9.
 */

public class InputStreamResponseBodyConverter implements Converter<ResponseBody, InputStream> {

    InputStreamResponseBodyConverter() {
    }

    @Override
    public InputStream convert(ResponseBody value) throws IOException {
        return value.byteStream();
    }
}
