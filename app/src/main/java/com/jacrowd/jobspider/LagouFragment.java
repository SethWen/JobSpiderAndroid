package com.jacrowd.jobspider;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacrowd.jobspider.adapter.LagouAdapter;
import com.jacrowd.jobspider.retroservice.LagouResponse;
import com.jacrowd.jobspider.util.LogUtil;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author: Shawn
 * time  : 2017/7/9 00:47
 * desc  :
 */
public class LagouFragment extends BaseFragment {
    @BindView(R.id.xrv_job)
    XRecyclerView xrvJob;

    private ArrayList<LagouResponse.DataEntity> datas;
    private LagouAdapter adapter;
    private int offset = 0;
    private int positionType;

    @Override
    protected View getView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub, container, false);
    }

    @Override
    protected void initData() {
        Bundle args = getArguments();
        positionType = args.getInt("POSITION_TYPE");

        if (positionType == 1) {
            // Python 显示成 List 形式
            LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            xrvJob.setLayoutManager(layoutManager);
        } else {
            // Android 显示成 Grid 形式
            GridLayoutManager layoutManager = new GridLayoutManager(mActivity, 2);
            xrvJob.setLayoutManager(layoutManager);
        }


        xrvJob.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrvJob.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xrvJob.setArrowImageView(R.drawable.iconfont_downgrey);

        datas = new ArrayList<>();
        adapter = new LagouAdapter(positionType, datas);
        xrvJob.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(position -> {
            LogUtil.i(TAG, "initListener: " + position);
            Intent intent = new Intent(mActivity, WebActivity.class);
            intent.putExtra("DETAIL_URL", String.format("http://www.lagou.com/jobs/%s.html", datas.get(position).getPositionId()));
            startActivity(intent);
        });

        xrvJob.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                LogUtil.i(TAG, "onRefresh: ---------------");
                offset = 0;
                getData(offset);
            }

            @Override
            public void onLoadMore() {
                offset++;
                App.jobRetrofit.getJobService().getLagouJobs(positionType, offset)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LagouResponse>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                LogUtil.d(TAG, "onSubscribe: ");
                            }

                            @Override
                            public void onNext(@NonNull LagouResponse response) {
                                LogUtil.d(TAG, response.getCode() + "");
                                List<LagouResponse.DataEntity> nextDatas = response.getData();
                                datas.addAll(response.getData());
                                if (nextDatas.size() == 10) {
                                    xrvJob.loadMoreComplete();
                                } else {
                                    xrvJob.setNoMore(true);
                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                LogUtil.d(TAG, "onError: ");
                            }

                            @Override
                            public void onComplete() {
                                LogUtil.d(TAG, "onComplete: ");
                            }
                        });
            }
        });

        xrvJob.refresh();
    }

    private void getData(int offset) {
        App.jobRetrofit.getJobService().getLagouJobs(positionType, offset)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LagouResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        LogUtil.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull LagouResponse response) {
                        LogUtil.d(TAG, response.getCode() + "");
                        adapter.clearAll();
                        adapter.addAll(response.getData());
                        xrvJob.refreshComplete();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        LogUtil.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete: ");
                    }
                });
    }

    /**
     * 创建不同求职位置的 Fragment
     *
     * @param positionType 1:Python; 2:Android
     * @return
     */
    public static LagouFragment newInstance(int positionType) {
        Bundle args = new Bundle();
        args.putInt("POSITION_TYPE", positionType);
        LagouFragment fragment = new LagouFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
