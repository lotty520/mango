package com.tj.lotty_wh.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.tj.lotty_wh.mango.HttpResponse;
import com.tj.lotty_wh.mango.HttpScheduler;
import com.tj.lotty_wh.sample.services.OmsStringService;

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
        doGet(GET_URL);
    }

    private void doGet(String url) {
        OmsStringService.INSTANCE.doGet(url).compose(HttpScheduler.<String>applyAndroidSchedulers())
                .subscribe(new HttpResponse<String>() {
                    @Override
                    public void onResponse(@NonNull String result) {
                        mTextView.setText(result);
                    }

                    @Override
                    public void onError(@NonNull Throwable t, @NonNull String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onGetDisposable(@NonNull Disposable disposable) {
                        // if you want to cancel this request, you can use disposable to do like this:
                        // if (!disposable.isDisposed()) {
                        //     disposable.dispose();
                        // }
                    }
                });
    }
}
