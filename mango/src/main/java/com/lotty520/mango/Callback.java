package com.lotty520.mango;


/**
 * @author lotty_wh
 * @date 2017/5/9
 */

public interface Callback<T> {

    /**
     * 出错的回调
     *
     * @param msg 错误信息
     * @param t   异常对象
     */
    void onError(Throwable t, String msg);

    /**
     * 请求成功的回调
     *
     * @param result 返回泛型的结果
     */
    void onSuccess(T result);

}
