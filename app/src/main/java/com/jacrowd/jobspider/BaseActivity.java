package com.jacrowd.jobspider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * author: Shawn
 * time  : 2017/7/8 19:26
 * desc  :
 */
public abstract class BaseActivity extends FragmentActivity {

    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        setContentView(getContentView());
        ButterKnife.bind(this);

        initViews();
        initData();
        initListener();
    }

    /**
     * @return 返回子类自己布局，即 layout id。
     */
    protected abstract int getContentView();

    /**
     * 初始化某些View
     */
    protected void initViews() {

    }

    /**
     * 初始化监听器
     */
    protected void initListener() {

    }

    /**
     * 获取数据
     */
    protected void initData() {

    }
}
