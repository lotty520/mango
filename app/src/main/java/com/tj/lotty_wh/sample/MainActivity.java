package com.tj.lotty_wh.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lotty520.mango.Callback;
import com.lotty520.mango.Client;
import com.lotty520.mango.client.StringClient;

/**
 * @author lotty
 */
public class MainActivity extends AppCompatActivity {
    private final static String PATH = "data/sk/101010100.html";

    private final static String URL = "http://www.weather.com.cn/data/sk/101010100.html";
    private final static String IO_URL = "https://gank.io/api/today";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
    }

    public void doGetString(View view) {
        StringClient.getWithPath(PATH, new Callback<String>() {
            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onGetClient(Client client) {

            }

            @Override
            public void onSuccess(String result) {
                mTextView.setText(result);
            }


        });
    }

    public void doPostWithBody(View view) {
        StringClient.postWithBody(IO_URL, "", new Callback<String>() {
            @Override
            public void onGetClient(Client client) {

            }

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
