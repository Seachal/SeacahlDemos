package com.seachal.seacahldemos.TextView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.seachal.seacahldemos.R;
import com.seachal.seacahldemos.customview.CustomTextViewTestActivity;

/**
 * *
 * *
 * Project_Name:SeachalDemos
 * <p>
 * <p>
 * https://www.jianshu.com/p/29a379512a13
 * https://blog.csdn.net/lyankj/article/details/51882335
 *
 * @author zhangxc
 * @date 2019-09-25 10:33
 * *
 */
public class LinkTextViewActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_textview);


//         1 .
        TextView mTextView = (TextView) findViewById(R.id.text);
        //将TextView的显示文字设置为SpannableString
        mTextView.setText(getClickableSpan());
        //设置该句使文本的超连接起作用
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());


//       解析 2.
        //解析 html
        TextView textView1 = findViewById(R.id.text1);
        CharSequence charSequence;
//      String content = "<p>简介：</p><p>1.nickname:wildma！</p><p>2.职业：android攻城狮</p>";

        String content = "<a href='http://www.baidu.com'>百度一下</a>";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            charSequence = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY);
        } else {
            charSequence = Html.fromHtml(content);
        }
        textView1.setText(charSequence);


        //解析 html
        String html = "http://www.baidu.com";
        mTextView.setAutoLinkMask(Linkify.ALL);//布局中设置android:autoLink 后这一句就不需要了
        mTextView.setText(html);


    }

    //设置超链接文字
    private SpannableString getClickableSpan() {
        String string1 = "使用该软件，即表示您同意该软件的使用条款和隐私政策-测试";
        SpannableString spanStr = new SpannableString(string1);
        //设置下划线文字,16、20 是根据问题长度计算到使用条款的位置。
        spanStr.setSpan(new UnderlineSpan(), 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的单击事件，调到其他 activity
        spanStr.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(LinkTextViewActivity.this, CustomTextViewTestActivity.class));
            }
        }, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的前景色
        spanStr.setSpan(new ForegroundColorSpan(Color.RED), 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        /*第二个文字*/

        //设置下划线文字
        spanStr.setSpan(new UnderlineSpan(), 21, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的单击事件， 调用自带浏览器。https://blog.csdn.net/bzlj2912009596/article/details/80673555
        spanStr.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
//                startActivity(new Intent(LinkTextViewActivity.this, CustomTextViewTestActivity.class));
                Uri uri = Uri.parse("https://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        }, 21, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的前景色
        spanStr.setSpan(new ForegroundColorSpan(Color.BLUE), 21, string1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanStr;
    }
}
