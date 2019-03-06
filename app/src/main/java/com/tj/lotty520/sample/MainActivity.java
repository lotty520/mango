package com.tj.lotty520.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lotty520.mango.Callback;
import com.lotty520.mango.FileClient;
import com.lotty520.mango.StringClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lotty
 */
public class MainActivity extends AppCompatActivity {

    private final static String USERS_PATH = "users";

    private final static String URL = "https://api.github.com";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);
    }

    /**
     * get完整路径请求
     *
     * @param view
     */
    public void doGetString(View view) {
        mTextView.setText("");
        StringClient.get(URL, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }


        });
    }

    /**
     * post完整路径请求
     *
     * @param view
     */
    public void doPostString(View view) {
        mTextView.setText("");
        StringClient.post(URL, new Callback<String>() {

            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }


        });
    }

    /**
     * path GET请求
     *
     * @param view
     */
    public void doGetPath(View view) {
        mTextView.setText("");
        StringClient.getWithPath(USERS_PATH, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }

        });
    }

    /**
     * path POST请求
     *
     * @param view
     */
    public void doPostPath(View view) {
        mTextView.setText("");
        StringClient.postWithPath(USERS_PATH, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }

        });
    }

    public void doGetParamPath(View view) {
        mTextView.setText("");
        Map<String, Object> param = new HashMap<>();
        StringClient.getWithPath(USERS_PATH, param, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }

        });
    }

    public void doPostParamPath(View view) {
        mTextView.setText("");
        Map<String, Object> param = new HashMap<>();
        StringClient.postWithPath(USERS_PATH, param, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }

        });
    }

    public void download(View view) {
        FileClient.get("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1752460159,226752426&fm=26&gp=0.jpg", new Callback<InputStream>() {
            @Override
            public void onError(Throwable t, String msg) {

            }

            @Override
            public void onSuccess(InputStream is) {

                if (is == null) {
                }
                try {
                    File targetFile = new File(getCacheDir().getAbsolutePath() + "/shell.jpg");
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    Toast.makeText(MainActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}