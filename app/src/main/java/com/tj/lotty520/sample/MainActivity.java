package com.tj.lotty520.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lotty520.mango.Callback;
import com.lotty520.mango.client.StringClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lotty
 */
public class MainActivity extends AppCompatActivity {

    private final static String CITY_PATH = "GetCity";

    private final static String POST_URL = "https://env.tj-ckkj.com/Air/App/GetCity";
    private final static String GET_URL = "http://www.weather.com.cn/data/sk/101010100.html";

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
        StringClient.get(GET_URL, new Callback<String>() {
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
        StringClient.post(POST_URL, new Callback<String>() {

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
        StringClient.getWithPath(CITY_PATH, new Callback<String>() {
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
        StringClient.getWithPath(CITY_PATH, new Callback<String>() {
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
        param.put("city", "杭州");
        StringClient.getWithPath(CITY_PATH, param, new Callback<String>() {
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
        param.put("city", "杭州");
        StringClient.postWithPath(CITY_PATH, param, new Callback<String>() {
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
}
