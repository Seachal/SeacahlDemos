package com.seachal.seacahldemos;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.seachal.seacahldemos.Activity.CountDownTimerActivity;
import com.seachal.seacahldemos.Activity.SkipToTaobaoActivity;
import com.seachal.seacahldemos.Activity.SkipToTaobaoActivity2;
import com.seachal.seacahldemos.Activity.URITestActivity;
import com.seachal.seacahldemos.BitmapDip.BitmapDipActivity;
import com.seachal.seacahldemos.RecyclerViewTest.RecyclerViewTestActivity;
import com.seachal.seacahldemos.ShareGeneratePicture.ShareGeneratePictureActivity;
import com.seachal.seacahldemos.TextView.LinkTextViewActivity;
import com.seachal.seacahldemos.customview.CustomTextViewTestActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.list)
    ListView list;

    private final int RESULT_CODE_1 = 100;
    private long exitTime = 0;

    private String[] mTitle = new String[]{
            "Bitmmap 放在不同的资源文件夹下，加载时所占用的内存",
            "TextView setText 的时候，onMessure,会被调用吗",
            "android 分享生成图片",
            "textView 带超链接",
            "RecyclerView 多种 gride 布局",
            "CountDownTimer 倒计时",
            "uri",
            "跳转到淘宝",
            "跳转到淘宝2"


    };
    private Class[] mClasses = new Class[]{BitmapDipActivity.class,
            CustomTextViewTestActivity.class,
            ShareGeneratePictureActivity.class,
            LinkTextViewActivity.class,
            RecyclerViewTestActivity.class,
            CountDownTimerActivity.class,
            URITestActivity.class,
            SkipToTaobaoActivity.class,
            SkipToTaobaoActivity2.class


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list.setAdapter(new ArrayAdapter<String>(this, R.layout.item_list, R.id.tv_items, mTitle));

        // 判断权限
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            initListener();
        } else {
            // 如果用户拒绝权限，第二次打开才会显示提示文字
            EasyPermissions.requestPermissions(this, "维持App正常运行需要存储权限", RESULT_CODE_1, perms);
        }
    }

    private void initListener() {
        list.setOnItemClickListener((adapterView, view, i, l) ->
                startActivity(new Intent(MainActivity.this, mClasses[i])
                ));
    }

    // 双击退出
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 同意授权
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        initListener();
    }

    /**
     * 拒绝授权
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(this, "权限", Toast.LENGTH_SHORT).show();
        finish();
    }
}
