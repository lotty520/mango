package com.lotty520.mango.converter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 字符集响应Body转换器，提供将数据以字符串的形式响应给Retrofit
 *
 * @author lotty_wh
 * @date 2017/5/8
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
