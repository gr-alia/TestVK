package com.alia.testvk.screen.player;

import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alia.testvk.R;
import com.alia.testvk.network.RetrofitService;
import com.alia.testvk.network.VKApi;
import com.alia.testvk.screen.feed.FeedActivity;
import com.alia.testvk.screen.feed.VideoAdapter;

import rx.Subscription;

public class PlayerActivity extends AppCompatActivity {
    String playerUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        playerUrl = getIntent().getStringExtra(FeedActivity.EXTRA_PLAYER);


        WebView webview = new WebView(this);
        setContentView(webview);
        webview.setWebViewClient ( new  WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(playerUrl);
    }
}
