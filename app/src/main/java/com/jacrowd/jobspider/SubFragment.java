package com.jacrowd.jobspider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jacrowd.jobspider.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: Shawn
 * time  : 2017/7/9 00:47
 * desc  :
 */
public class SubFragment extends BaseFragment {
    @BindView(R.id.tv_sub)
    TextView tvSub;

    @Override
    protected View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub, container, false);
    }

    @Override
    protected void initData() {
        Bundle args = getArguments();
        String type = args.getString("sub");
        tvSub.setText(type);
        LogUtil.d(TAG, type);
    }

    public static SubFragment newInstance(String sub) {
        Bundle args = new Bundle();
        args.putString("sub", sub);
        SubFragment fragment = new SubFragment();
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
