package com.seachal.seacahldemos.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.seachal.seacahldemos.R;

/**
 * *
 * *
 * Project_Name:SeachalDemos
 *
 * @author zhangxc
 * @date 2019-10-23 16:10
 * *
 */
public class CountDownTimerActivity extends Activity {

    public static final String TAG = "CountDownTimerActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);

        TextView textView = findViewById(R.id.tv_time);
        TextView textView2 = findViewById(R.id.tv_time2);

        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished + "");
                Log.i(TAG, "seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "done!");
            }
        }.start();
    }


}
