package com.lotty520.mango;

import io.reactivex.annotations.NonNull;

/**
 * @author lotty
 */
public class MangoConfig {
    boolean openLog;
    String baseURL;

    private MangoConfig(Builder builder) {
        this.openLog = builder.openLog;
        this.baseURL = builder.baseURL;
    }

    public static class Builder {
        private boolean openLog;
        private String baseURL;

        /**
         * 开启日志
         *
         * @param openLog 是否开启日志
         * @return 当前对象
         */
        public Builder openLog(boolean openLog) {
            this.openLog = openLog;
            return this;
        }

        /**
         * 设置默认 baseUrl
         *
         * @param url 网络请求的 baseUrl
         * @return 当前对象
         */
        public Builder baseUrl(@NonNull String url) {
            this.baseURL = url;
            return this;
        }

        public MangoConfig build() {
            return new MangoConfig(this);
        }
    }
}
