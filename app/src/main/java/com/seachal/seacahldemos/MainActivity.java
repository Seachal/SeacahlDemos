package com.seachal.seacahldemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 一个用于验证，不同尺寸的图片，放在不同的资源文件夹（drawable）下， 加载出来会有什么效果差别。
 *
 * 缺少，相同尺寸的图片，放在不同的资源文件夹（drawable）下,会有什么差别
 */
public class MainActivity extends AppCompatActivity {


    ImageView iv_l;


    ImageView iv_m;

    ImageView iv_h;

    ImageView iv_xh;


    ImageView iv_xxh;

    ImageView iv_xxxh;
    //--
    ImageView iv_240_h;
    ImageView iv_240_xh;


    ImageView iv_240_xxh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        TextView textView = findViewById(R.id.tv_dpi);
        textView.setText("x:" + xdpi + ",y:" + ydpi);

        iv_l = findViewById(R.id.iv_l);
        iv_m = findViewById(R.id.iv_m);
        iv_h = findViewById(R.id.iv_h);
        iv_xh = findViewById(R.id.iv_xh);
        iv_xxh = findViewById(R.id.iv_xxh);
        iv_xxxh = findViewById(R.id.iv_xxxh);

        iv_240_h = findViewById(R.id.iv_240_h);
        iv_240_xh = findViewById(R.id.iv_240_xh);
        iv_240_xxh = findViewById(R.id.iv_240_xxh);
    }

    public void buttonClick(View view) {
        Log.i("iv_l:", iv_l.getWidth() + ":" + iv_l.getHeight());
        Log.i("iv_m:", iv_m.getWidth() + ":" + iv_m.getHeight());
        Log.i("iv_h:", iv_h.getWidth() + ":" + iv_h.getHeight());
        Log.i("iv_xh:", iv_xh.getWidth() + ":" + iv_xh.getHeight());
        Log.i("iv_xxh:", iv_xxh.getWidth() + ":" + iv_xxh.getHeight());
        Log.i("iv_xxxh:", iv_xxxh.getWidth() + ":" + iv_xxxh.getHeight());


        Log.i("iv_240_h:", iv_240_h.getWidth() + ":" + iv_240_h.getHeight());
        Log.i("iv_240_xh:", iv_240_xh.getWidth() + ":" + iv_240_xh.getHeight());
        Log.i("iv_240_xxh:", iv_240_xxh.getWidth() + ":" + iv_240_xxh.getHeight());
    }


}
