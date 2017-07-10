package com.jacrowd.jobspider;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jacrowd.jobspider.util.PackageInfoUtil;

import butterknife.BindView;

/**
 * author: Shawn
 * time  : 2017/7/9 15:38
 * desc  :
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.rl_github)
    RelativeLayout rlGithub;
    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    protected void initData() {
        tvVersion.setText(String.format("Version-%s", PackageInfoUtil.getPackageVersion(mActivity)));
    }

    @Override
    protected void initListener() {
        super.initListener();
        rlGithub.setOnClickListener(v -> {
            Intent intent = new Intent(mActivity, WebActivity.class);
            intent.putExtra("DETAIL_URL", "https://github.com/SethWen?tab=repositories");
            startActivity(intent);
        });
    }

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
