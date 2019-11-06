package com.example.seachal.launchotherapp;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * https://blog.csdn.net/qq475703980/article/details/78941370
 * <p>
 * https://blog.csdn.net/hust_twj/article/details/73477454
 * <p>
 * https://www.jianshu.com/p/42ae7066f8f3
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 启动另一个 app 的 default activity， 主 activity，不能灵活指定 activity
     *
     * @param view
     */
    public void startOtherAppActivity1(View view) {
        Intent intent = new Intent();
        //这里是采用的自定义action
        intent.setAction("com.example.seachal.launchedapp.app");
        startActivity(intent);
    }

    /**
     * @param view
     */
    public void startOtherAppActivity2(View view) {
        ComponentName componetName = new ComponentName(
                "com.example.seachal.launchedapp",  //这个是另外一个应用程序的包名
                "com.example.seachal.launchedapp.Main2Activity");   //这个参数是要启动的Activity的全路径名

        try {
            Intent intent = new Intent();
            intent.setComponent(componetName);
            intent.putExtra("wangluo", "这个参数是要启动的Activity的全路径名");
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }

    /**
     * @param view
     */
    public void startOtherAppActivity22(View view) {
        ComponentName componetName = new ComponentName(
                "com.example.seachal.launchedapp",  //这个是另外一个应用程序的包名
                "com.example.seachal.launchedapp.Main2Activity");   //这个参数是要启动的Activity的全路径名

        try {
            Intent intent = new Intent();
            intent.setComponent(componetName);
            intent.putExtra("wangluo", "这个参数是要启动的Activity的全路径名");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            GlobalLication.getContext().startActivity(intent);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }


    //       被启动 app 的 androidmanifest 中 activity 中要指定的数据， <data 数据。
    public void startOtherAppActivity3(View view) {
        Uri uri = Uri.parse("app://my.test");
        Intent intent = new Intent("com.example.seachal.launchedapp.app", uri);
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }

    //    与第二种启动方式类似。
    public void startOtherAppActivity4(View view) {
        try {
            Intent intent = new Intent();
            //第二种方式
            intent.setClassName("com.example.seachal.launchedapp",  //这个是另外一个应用程序的包名
                    "com.example.seachal.launchedapp.Main4Activity");
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }

    //    与第二种启动方式类似。
    public void startOtherAppActivity42(View view) {
        try {
            Intent intent = new Intent();
            //第二种方式
            intent.setClassName("com.example.seachal.launchedapp",  //这个是另外一个应用程序的包名
                    "com.example.seachal.launchedapp.Main4Activity");
//            GlobalLication.getContext().startActivity(intent);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            GlobalLication.getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }

}
