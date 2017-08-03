package com.crane.cranesdemoa.activity.gong;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.crane.cranesdemoa.R;

public class SchoolOutActivity extends AppCompatActivity {

    private TextView titleView;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_out);
        titleView = (TextView) findViewById(R.id.headTitle);
        webView = (WebView) findViewById(R.id.webView);
        titleView.setText("校外维修店");
        findViewById(R.id.headLeftImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient(this));
        webView.loadUrl("https://baidu.com/");
    }

    private class MyWebViewClient extends WebViewClient {
        private Context mContext;
        private ProgressDialog dialog;
        public MyWebViewClient(Context context){
            super();
            mContext = context;
            dialog = new ProgressDialog(SchoolOutActivity.this);
            dialog.setMessage("正在加载中...");
            dialog.setCanceledOnTouchOutside(false);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            dialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dialog.dismiss();
        }
    }
}
