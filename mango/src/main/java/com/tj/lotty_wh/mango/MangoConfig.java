package com.tj.lotty_wh.mango;

import io.reactivex.annotations.NonNull;

public class MangoConfig {
    boolean mOpenLog;
    String mBaseUrl;

    private MangoConfig(Builder builder) {
        mOpenLog = builder.mOpenLog;
        mBaseUrl = builder.mBaseUrl;
    }

    public static class Builder {
        private boolean mOpenLog;
        private String mBaseUrl;

        /**
         * 开启 okhttp 日志
         *
         * @param openLog 是否开启日志
         * @return 当前对象
         */
        public Builder openLog(boolean openLog) {
            this.mOpenLog = openLog;
            return this;
        }

        /**
         * 设置默认 baseUrl
         *
         * @param url 网络请求的 baseUrl
         * @return 当前对象
         */
        public Builder baseUrl(@NonNull String url) {
            this.mBaseUrl = url;
            return this;
        }

        public MangoConfig build() {
            return new MangoConfig(this);
        }
    }
}
