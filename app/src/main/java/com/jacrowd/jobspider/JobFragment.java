package com.jacrowd.jobspider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacrowd.jobspider.adapter.SubPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: Shawn
 * time  : 2017/7/8 21:42
 * desc  :
 */
public class JobFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;

    @Override
    protected View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_job, container, false);
    }

    @Override
    protected void initData() {
        Bundle args = getArguments();
        int jobType = args.getInt("JOB_TYPE");

        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = new ArrayList<>();

        if (jobType == 1) {
            // 创建拉钩对应的 Fragment
            LagouFragment lagouPythonFragment = LagouFragment.newInstance(1);
            LagouFragment lagouAndroidFragment = LagouFragment.newInstance(2);
            fragments.add(lagouPythonFragment);
            fragments.add(lagouAndroidFragment);
        } else {
            // 创建智联对应的 Fragment
            ZhilianFragment zhilianPythonFragment = ZhilianFragment.newInstance(1);
            ZhilianFragment zhilianAndroidFragment = ZhilianFragment.newInstance(2);
            fragments.add(zhilianPythonFragment);
            fragments.add(zhilianAndroidFragment);
        }


        List<String> titles = Arrays.asList("Python", "Android");

        SubPagerAdapter adapter = new SubPagerAdapter(fragmentManager, fragments, titles);
        vpContainer.setAdapter(adapter);
        tab.setupWithViewPager(vpContainer);
    }

    /**
     * 创建不同类型的 JobFragment
     *
     * @param jobType 1：拉钩; 2:智联
     * @return
     */
    public static JobFragment newInstance(int jobType) {
        Bundle args = new Bundle();
        args.putInt("JOB_TYPE", jobType);
        JobFragment fragment = new JobFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
