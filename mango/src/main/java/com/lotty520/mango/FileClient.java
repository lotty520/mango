package com.lotty520.mango;

import com.lotty520.mango.services.FileService;

import java.io.InputStream;

/**
 * @ProjectName: mango
 * @Package: com.lotty520.mango.client
 * @ClassName: FileClient
 * @Description: java类作用描述
 * @Author: 吴晗
 */
public class FileClient {

    private static FileService INSTANCE = null;

    private FileClient() {
    }

    static void init() {
        INSTANCE = Mango.createInputStreamService(FileService.class);
    }


    public static void get(String url, Callback<InputStream> callback) {
        checkInit();
        INSTANCE.doGet(url).enqueue(new CallBackProxy(callback));
    }

    private static void checkInit() {
        if (INSTANCE == null) {
            throw new IllegalStateException("should init first");
        }
    }

    public static void post(String url, Callback<InputStream> callback) {
        checkInit();
        INSTANCE.doPost(url).enqueue(new CallBackProxy(callback));
    }
}
