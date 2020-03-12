package com.seachal.seacahldemos.bean;

/**
 * *
 * *
 * Project_Name:SeachalDemos
 *
 * @author zhangxc
 * @date 2020/3/2 11:52
 * *
 */
public class StartActivityBean {

    private String mTitle;

    private Class mActivityClass;


    public StartActivityBean(String title, Class activityClass) {
        mTitle = title;
        mActivityClass = activityClass;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Class getActivityClass() {
        return mActivityClass;
    }

    public void setActivityClass(Class activityClass) {
        mActivityClass = activityClass;
    }
}
