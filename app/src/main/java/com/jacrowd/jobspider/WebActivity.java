package com.jacrowd.jobspider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jacrowd.jobspider.util.LogUtil;

import butterknife.BindView;

/**
 * author: Shawn
 * time  : 2017/7/10 19:16
 * desc  :
 */
public class WebActivity extends BaseActivity {
    @BindView(R.id.wv)
    WebView wv;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getContentView() {
        return R.layout.activity_position_detail;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String detailUrl = intent.getStringExtra("DETAIL_URL");

        wv.loadUrl(detailUrl);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);


        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                LogUtil.i(TAG, "onPageStarted: ");
                pb.setVisibility(View.VISIBLE);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                LogUtil.i(TAG, "onPageFinished: ");
                pb.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pb.setProgress(newProgress * pb.getMax());
            }


            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                LogUtil.e(TAG, "onReceivedTitle: " + title);
                tvTitle.setText(title);
            }
        });

    }

    @Override
    protected void initListener() {
        super.initListener();
        ivBack.setOnClickListener(v -> finish());
    }
}
