package com.jacrowd.jobspider.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 不可滑动的 ViewPager
 * <p>
 * author: Shawn
 * time  : 2016/11/29 15:13
 */

public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 不拦截子控件的事件
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // 禁用滑动事件
        return true;
    }
}
