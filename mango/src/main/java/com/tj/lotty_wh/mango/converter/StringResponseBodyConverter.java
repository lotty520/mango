package com.tj.lotty_wh.mango.converter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 字符集响应Body转换器，提供将数据已字符串的形式响应给Retrofit
 * Created by lotty_wh on 2017/5/8.
 */

public class StringResponseBodyConverter implements Converter<ResponseBody, String> {

    StringResponseBodyConverter() {
    }

    @Override
    public String convert(ResponseBody value) throws IOException {
        try {
            return value.string();
        } finally {
            value.close();
        }
    }
}
