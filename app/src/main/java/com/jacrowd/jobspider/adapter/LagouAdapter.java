package com.jacrowd.jobspider.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jacrowd.jobspider.App;
import com.jacrowd.jobspider.R;
import com.jacrowd.jobspider.retroservice.JobRetrofit;
import com.jacrowd.jobspider.retroservice.LagouResponse;

import java.util.ArrayList;
import java.util.Collection;

/**
 * author: Shawn
 * time  : 2017/7/8 13:27
 * desc  :
 */
public class LagouAdapter extends RecyclerView.Adapter<LagouAdapter.ViewHolder> {
    private int positionType;
    private ArrayList<LagouResponse.DataEntity> datas = null;
    private OnItemClickListener mOnItemClickListener;

    public LagouAdapter(int positionType, ArrayList<LagouResponse.DataEntity> datas) {
        this.positionType = positionType;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        int res = positionType == 1 ? R.layout.item_list : R.layout.item_grid;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(res, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tvCom.setText(datas.get(position).getCompanyFullName());
        viewHolder.tvPosition.setText(datas.get(position).getPositionName());
        viewHolder.rlContainer.setOnClickListener(v -> mOnItemClickListener.onClick(position));

        Glide.with(App.appContext)
                .load(JobRetrofit.LAGOU_HOST + datas.get(position).getCompanyLogo())
                .error(R.drawable.com_logo)
                .into(viewHolder.ivComLogo);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addAll(Collection<? extends LagouResponse.DataEntity> collection) {
        datas.addAll(collection);
        notifyDataSetChanged();
    }

    public void clearAll() {
        datas.clear();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCom;
        public TextView tvPosition;
        public ImageView ivComLogo;
        public RelativeLayout rlContainer;

        public ViewHolder(View view) {
            super(view);
            tvCom = (TextView) view.findViewById(R.id.tv_com);
            tvPosition = (TextView) view.findViewById(R.id.tv_position);
            ivComLogo = (ImageView) view.findViewById(R.id.iv_com_logo);
            rlContainer = (RelativeLayout) view.findViewById(R.id.rl_container);
        }
    }
}
