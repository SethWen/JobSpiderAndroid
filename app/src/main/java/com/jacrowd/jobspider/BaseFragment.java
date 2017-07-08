package com.jacrowd.jobspider;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * author: Shawn
 * time  : 2017/7/8 21:35
 * desc  :
 */
public abstract class BaseFragment extends Fragment {
    protected String TAG;
    protected Activity mActivity;
    protected View rootView;

    /**
     * 当前界面呈现给用户的状态
     */
    protected boolean isVisible = false;
    /**
     * 标志位，标志Fragment已经初始化完成
     */
    protected boolean isPrepared = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            // 如果view为空，才新建向ViewPager添加，也即第一次
            rootView = getView(inflater, container, savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                // 如果View不为空，直接复用，这样之前页面的数据不会丢失，但是同一个View不能被添加两次，先移除，再添加
                parent.removeView(rootView);
            }
        }
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initListener();
    }

    /**
     * 子类重写这一方法初始化View即可
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 子类必需实现，初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听器
     */
    protected void initListener() {

    }
}
