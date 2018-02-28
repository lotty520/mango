package com.tj.lotty_wh.mango.interceptor;

/**
 * 下载进度回调
 */
public interface ProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}
