package com.seachal.seacahldemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CustomTextViewTestActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_text_view_test);
          textView = findViewById(R.id.tv_measure);

    }

    public void buttonClick(View view) {
        textView.setText("12343434344111111111111111111111111111111111111111111111111111111111111111111111111133333333333");

    }

}
