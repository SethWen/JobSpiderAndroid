package com.jacrowd.jobspider;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.jacrowd.jobspider.adapter.JobPagerAdapter;
import com.jacrowd.jobspider.util.LogUtil;
import com.jacrowd.jobspider.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    private FragmentManager fragmentManager;
    private JobPagerAdapter adapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        super.initViews();
        fragmentManager = getSupportFragmentManager();

        JobFragment zhilianFragment = JobFragment.newInstance(1);
        JobFragment lagouFragment = JobFragment.newInstance(2);
        MeFragment meFragment = MeFragment.newInstance();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(zhilianFragment);
        fragments.add(lagouFragment);
        fragments.add(meFragment);

        LogUtil.d(TAG, fragments.size() + "");

        adapter = new JobPagerAdapter(fragmentManager, fragments);
        vpContainer.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
        super.initListener();
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vpContainer.setCurrentItem(0, false);
                    return true;
                case R.id.navigation_dashboard:
                    vpContainer.setCurrentItem(1, false);
                    return true;
                case R.id.navigation_notifications:
                    vpContainer.setCurrentItem(2, false);
                    return true;
            }
            return false;
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
