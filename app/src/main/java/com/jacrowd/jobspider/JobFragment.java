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
import com.jacrowd.jobspider.util.LogUtil;

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
        String type = args.getString("type");
        LogUtil.d(TAG, type);

        FragmentManager fragmentManager = getChildFragmentManager();

        SubFragment pythonFragment = SubFragment.newInstance("Python");
        SubFragment androidFragment = SubFragment.newInstance("Android");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(pythonFragment);
        fragments.add(androidFragment);

        List<String> titles = Arrays.asList("Python", "Android");

        SubPagerAdapter adapter = new SubPagerAdapter(fragmentManager, fragments, titles);
        vpContainer.setAdapter(adapter);
        tab.setupWithViewPager(vpContainer);
    }

    public static JobFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
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
