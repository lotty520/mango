package com.lotty520.mango;

/**
 * @author lotty
 */
public class MangoConfig {
    boolean openLog;
    boolean initLoader;
    String baseURL;

    private MangoConfig(Builder builder) {
        this.openLog = builder.openLog;
        this.baseURL = builder.baseURL;
        this.initLoader = builder.initLoader;
    }

    public static class Builder {
        private boolean openLog;
        private boolean initLoader;
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
         * 初始化下载器
         *
         * @param init 是否初始化下载器
         * @return 当前对象
         */
        public Builder initDownloader(boolean init) {
            this.initLoader = init;
            return this;
        }


        /**
         * 设置默认 baseUrl
         *
         * @param url 网络请求的 baseUrl
         * @return 当前对象
         */
        public Builder baseUrl(String url) {
            this.baseURL = url;
            return this;
        }

        public MangoConfig build() {
            return new MangoConfig(this);
        }
    }
}
