package com.seachal.seacahldemos;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.seachal.seacahldemos.Activity.CountDownTimerActivity;
import com.seachal.seacahldemos.Activity.SkipToTaobaoActivity;
import com.seachal.seacahldemos.Activity.SkipToTaobaoActivity2;
import com.seachal.seacahldemos.Activity.URITestActivity;
import com.seachal.seacahldemos.BitmapDip.BitmapDipActivity;
import com.seachal.seacahldemos.RecyclerViewTest.RecyclerViewTestActivity;
import com.seachal.seacahldemos.ShareGeneratePicture.ShareGeneratePictureActivity;
import com.seachal.seacahldemos.TextView.LinkTextViewActivity;
import com.seachal.seacahldemos.bean.StartActivityBean;
import com.seachal.seacahldemos.customview.CustomTextViewTestActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private final int RESULT_CODE_1 = 100;
    private long exitTime = 0;


    private List<StartActivityBean> activityList = new ArrayList<StartActivityBean>();


    {
        activityList.add(new StartActivityBean("Bitmmap 放在不同的资源文件夹下，加载时所占用的内存", BitmapDipActivity.class));
        activityList.add(new StartActivityBean("TextView setText 的时候，onMessure,会被调用吗", CustomTextViewTestActivity.class));
        activityList.add(new StartActivityBean("android 分享生成图片", ShareGeneratePictureActivity.class));
        activityList.add(new StartActivityBean("textView 带超链接", LinkTextViewActivity.class));
        activityList.add(new StartActivityBean("RecyclerView 多种 gride 布局", RecyclerViewTestActivity.class));
        activityList.add(new StartActivityBean("CountDownTimer 倒计时", CountDownTimerActivity.class));
        activityList.add(new StartActivityBean("uri", URITestActivity.class));
        activityList.add(new StartActivityBean("跳转到淘宝", SkipToTaobaoActivity.class));
        activityList.add(new StartActivityBean("跳转到淘宝2", SkipToTaobaoActivity.class));
        activityList.add(new StartActivityBean("android 跳转栈测试", SkipToTaobaoActivity2.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        // 判断权限
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            recycler_view.setAdapter(new MyAdapter(MainActivity.this, activityList));
            recycler_view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        } else {
            // 如果用户拒绝权限，第二次打开才会显示提示文字
            EasyPermissions.requestPermissions(this, "维持App正常运行需要存储权限", RESULT_CODE_1, perms);
        }
    }

//    private void initListener() {
////        recycler_view.setOnItemClickListener((adapterView, view, i, l) ->
////                startActivity(new Intent(MainActivity.this, activityList.get(i).getActivityClass())
////                ));
//    }

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


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context context;
        private List<StartActivityBean> arrayList;

        public MyAdapter(Context context, List<StartActivityBean> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent,
                    false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(arrayList.get(position).getTitle());
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, arrayList.get(position).getActivityClass());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return activityList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
           private  TextView mTextView;


            public MyViewHolder(View itemView) {
                super(itemView);
                mTextView = itemView.findViewById(R.id.tv_items);

            }
        }
    }
}
