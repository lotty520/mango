package com.lotty520.mango.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 获取字符的ConvertFactory
 *
 * @author lotty_wh
 * @date 2017/5/8
 */

public class StringConvertFactory extends Converter.Factory {

    private StringConvertFactory() {
    }

    public static StringConvertFactory create() {
        return new StringConvertFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new StringResponseBodyConverter();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}
