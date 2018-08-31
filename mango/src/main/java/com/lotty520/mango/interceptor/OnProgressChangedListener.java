package com.lotty520.mango.interceptor;

/**
 * 下载进度回调
 *
 * @author lotty
 */
public interface OnProgressChangedListener {
    /**
     * @param bytesRead     已经下载的长度
     * @param contentLength 内容总长度
     * @param done          是否结束
     */
    void onUpdate(long bytesRead, long contentLength, boolean done);
}
