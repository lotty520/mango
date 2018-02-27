package com.tj.lotty_wh.mango.converter;

import java.io.IOException;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Fast json converter
 * <p>
 * Created by Robin on 5/17/17.
 */

public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return JSON.parseObject(value.byteStream(), type);
    }
}
