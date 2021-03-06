package com.lotty520.mango.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 获取输入流的ConvertFactory，适用于下载
 *
 * @author lotty_wh
 * @date 2017/5/9
 */

public class InputStreamConvertFactory extends Converter.Factory {

    private InputStreamConvertFactory() {
    }

    public static InputStreamConvertFactory create() {
        return new InputStreamConvertFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new InputStreamResponseBodyConverter();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}
