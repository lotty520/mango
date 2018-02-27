package com.tj.lotty_wh.sample;

import com.tj.lotty_wh.mango.HttpResponse;
import com.tj.lotty_wh.mango.HttpScheduler;
import com.tj.lotty_wh.mango.client.StringClient;
import com.tj.lotty_wh.sample.entity.WeatherInfo;
import com.tj.lotty_wh.sample.services.JsonService;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private final static String GET_URL = "http://www.weather.com.cn/data/sk/101010100.html";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
    }

    public void doGetString(View view) {
        StringClient.getString(GET_URL, new HttpResponse<String>() {
            @Override
            public void onResponse(String result) {
                mTextView.setText(result);
            }

            @Override
            public void onError(Throwable t, String msg) {
                mTextView.setText(msg);
            }

            @Override
            public void onGetDisposable(Disposable disposable) {

            }
        });

    }

    public void doGetJson(View view) {
        JsonService.INSTANCE.doGet(GET_URL).compose(HttpScheduler.<WeatherInfo>applyAndroidSchedulers())
                .subscribe(new HttpResponse<WeatherInfo>() {
                    @Override
                    public void onResponse(@NonNull WeatherInfo result) {
                        mTextView.setText(result.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable t, @NonNull String msg) {
                        mTextView.setText(msg);

                    }

                    @Override
                    public void onGetDisposable(@NonNull Disposable disposable) {

                    }
                });


    }
}
